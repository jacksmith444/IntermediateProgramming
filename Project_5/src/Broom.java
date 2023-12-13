
public class Broom extends Object implements Rentable {
    private String purpose;

    public Broom(String purpose) {
        this.purpose = purpose;
    }

    @Override
    public double getRentalPrice() {
        return purpose.equalsIgnoreCase("fly by night") ? 25 : 15; // Updated rental price for Broom
    }

    @Override
    public String toString() {
        return "Brand new broom for " + purpose + " costing " + getRentalPrice() + "$ per day";
    }
}
