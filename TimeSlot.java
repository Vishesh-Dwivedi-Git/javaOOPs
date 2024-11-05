
public class TimeSlot {
    private String startTime;
    private String endTime;
    private Course course;

    public TimeSlot(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.course = null;
    }

    public void assignCourse(Course course) {
        this.course = course;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public String toString() {
        String timeRange = String.format("%s-%s", startTime, endTime);
        String courseInfo = (course != null) ? course.getCourseCode() : "FREE";
        return String.format("%-15s | %-8s", timeRange, courseInfo);
    }
}