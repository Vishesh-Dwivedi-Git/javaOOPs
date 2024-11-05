public class Main {
    public static void main(String[] args) {
        TimeTableManager manager = new TimeTableManager();
        manager.loadFromCSV("courses.csv", "timetable.csv");

        // Display timetables for all semesters
        for (int sem = 1; sem <= 8; sem++) {
            manager.displayTimetable(sem);
        }
    }
}
