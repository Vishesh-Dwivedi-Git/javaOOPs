import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class TimeTableManager {
    private Map<Integer, Semester> semesters;

    public TimeTableManager() {
        this.semesters = new HashMap<>();
        initializeSemesters();
    }

    private void initializeSemesters() {
        for (int i = 1; i <= 8; i++) {
            semesters.put(i, new Semester(i));
        }
    }

    public void loadFromCSV(String coursesFile, String timetableFile) {
        loadCourses(coursesFile);
        loadTimetable(timetableFile);
    }

    private void loadCourses(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // Skip header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    int semester = Integer.parseInt(data[0]);
                    Course course = new Course(data[1], data[2], data[3], data[4]);
                    semesters.get(semester).addCourse(course);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading courses file: " + e.getMessage());
        }
    }

    private void loadTimetable(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            // Skip header line
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 5) {
                    int semester = Integer.parseInt(data[0]);
                    String day = data[1];
                    String startTime = data[2];
                    String endTime = data[3];
                    String courseCode = data[4];
                    semesters.get(semester).assignCourseToTimeSlot(day, startTime, endTime, courseCode);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading timetable file: " + e.getMessage());
        }
    }

    public void displayTimetable(int semester) {
        Semester sem = semesters.get(semester);
        if (sem == null) {
            System.out.println("Semester not found!");
            return;
        }

        System.out.println("\nTIMETABLE FOR SEMESTER " + semester);
        System.out.println("=".repeat(120));

        // Print header with time slots
        List<TimeSlot> timeSlots = sem.getDays().get(0).getTimeSlots();
        System.out.printf("%-10s", "DAY");
        for (TimeSlot slot : timeSlots) {
            System.out.printf("| %-16s", slot.getStartTime() + "-" + slot.getEndTime());
        }
        System.out.println();
        System.out.println("-".repeat(120));

        // Print each day's schedule
        for (Day day : sem.getDays()) {
            System.out.printf("%-10s", day.getName());
            for (TimeSlot slot : day.getTimeSlots()) {
                String courseInfo = slot.getCourse() != null ? slot.getCourse().getCourseCode() : "FREE";
                System.out.printf("| %-16s", courseInfo);
            }
            System.out.println();
        }
        System.out.println("-".repeat(120));

        // Print break times information
        System.out.println("\nBreak Times:");
        System.out.println("Morning Break : 10:30 - 10:45");
        System.out.println("Lunch Break  : 13:15 - 14:30");

        // Print legend with course details
        System.out.println("\nCourse Legend:");
        System.out.println("-".repeat(80));
        System.out.printf("%-8s | %-30s | %-10s | %-20s\n", 
            "CODE", "TITLE", "CREDITS", "FACULTY");
        System.out.println("-".repeat(80));
        
        for (Course course : sem.getCourses().values()) {
            System.out.println(course);
        }
    }
}
