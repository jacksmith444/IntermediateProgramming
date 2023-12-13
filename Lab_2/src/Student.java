
public class Student {
	private int totalHoursToTake;

    public Student() {
        this.totalHoursToTake = 120;
    }

    public Student(int totalHoursToTake) {
        this.totalHoursToTake = totalHoursToTake;
    }

    public int getTotalHoursToTake() {
        return totalHoursToTake;
    }

    public void setTotalHoursToTake(int totalHoursToTake) {
        this.totalHoursToTake = totalHoursToTake;
    }

    public int hoursLeft() {
        return totalHoursToTake;
    }

}
