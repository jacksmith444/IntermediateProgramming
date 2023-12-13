
public class Carpet extends Object implements Rentable {
    private String pattern;

    public Carpet(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public double getRentalPrice() {
        return 25; // Updated rental price for Carpet
    }

    @Override
    public String toString() {
        return "Brand new carpet with a " + pattern + " pattern costing " + getRentalPrice() + "$ per day";
    }
}