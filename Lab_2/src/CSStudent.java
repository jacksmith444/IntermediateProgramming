
public class CSStudent extends Student {
	private int genEdHours;
    private int mathHours;

    public CSStudent() {
        super();
        this.genEdHours = 0;
        this.mathHours = 0;
    }

    public CSStudent(int totalHoursToTake, int genEdHours, int mathHours) {
        super(totalHoursToTake);
        this.genEdHours = genEdHours;
        this.mathHours = mathHours;
    }

    public int getGenEdHours() {
        return genEdHours;
    }

    public void setGenEdHours(int genEdHours) {
        this.genEdHours = genEdHours;
    }

    public int getMathHours() {
        return mathHours;
    }

    public void setMathHours(int mathHours) {
        this.mathHours = mathHours;
    }

    @Override
    public int hoursLeft() {
        return getTotalHoursToTake() - (genEdHours + mathHours);
    }
}
