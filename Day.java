import java.util.ArrayList;
import java.util.List;

public class Day {
    private String name;
    private List<TimeSlot> timeSlots;

    public Day(String name) {
        this.name = name;
        this.timeSlots = new ArrayList<>();
        initializeTimeSlots();
    }

    private void initializeTimeSlots() {
        timeSlots.add(new TimeSlot("09:00", "09:30"));
        timeSlots.add(new TimeSlot("09:30", "10:30"));
        timeSlots.add(new TimeSlot("10:45", "12:15"));
        timeSlots.add(new TimeSlot("12:15", "13:15"));
        timeSlots.add(new TimeSlot("14:30", "16:00"));
        timeSlots.add(new TimeSlot("16:00", "16:30"));
        timeSlots.add(new TimeSlot("16:30", "17:30"));
    }

    public String getName() {
        return name;
    }

    public List<TimeSlot> getTimeSlots() {
        return timeSlots;
    }

    public void assignCourseToSlot(String startTime, String endTime, Course course) {
        for (TimeSlot slot : timeSlots) {
            if (slot.getStartTime().equals(startTime) && slot.getEndTime().equals(endTime)) {
                slot.assignCourse(course);
                break;
            }
        }
    }
}