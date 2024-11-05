
public class Course {
    private String courseCode;
    private String courseTitle;
    private String credits;
    private String faculty;

    public Course(String courseCode, String courseTitle, String credits, String faculty) {
        this.courseCode = courseCode;
        this.courseTitle = courseTitle;
        this.credits = credits;
        this.faculty = faculty;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public String getCredits() {
        return credits;
    }

    public String getFaculty() {
        return faculty;
    }

    @Override
    public String toString() {
        return String.format("%-8s | %-30s | %-10s | %-20s", 
            courseCode, courseTitle, credits, faculty);
    }
}