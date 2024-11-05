import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Semester {
    private int semesterNumber;
    private List<Day> days;
    private Map<String, Course> courses;

    public Semester(int semesterNumber) {
        this.semesterNumber = semesterNumber;
        this.days = new ArrayList<>();
        this.courses = new HashMap<>();
        initializeDays();
    }

    private void initializeDays() {
        days.add(new Day("Monday"));
        days.add(new Day("Tuesday"));
        days.add(new Day("Wednesday"));
        days.add(new Day("Thursday"));
        days.add(new Day("Friday"));
    }

    public void addCourse(Course course) {
        courses.put(course.getCourseCode(), course);
    }

    public Course getCourse(String courseCode) {
        return courses.get(courseCode);
    }

    public void assignCourseToTimeSlot(String day, String startTime, String endTime, String courseCode) {
        Course course = courses.get(courseCode);
        if (course != null) {
            for (Day d : days) {
                if (d.getName().equalsIgnoreCase(day)) {
                    d.assignCourseToSlot(startTime, endTime, course);
                    break;
                }
            }
        }
    }

    public List<Day> getDays() {
        return days;
    }

    public Map<String, Course> getCourses() {
        return courses;
    }

    public int getSemesterNumber() {
        return semesterNumber;
    }
}