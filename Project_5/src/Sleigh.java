
public class Sleigh extends Object implements Rentable {
	
	private String purpose;

    public Sleigh(String purpose) {
        this.purpose = purpose;
    }
    
    @Override
    public double getRentalPrice() {
        return 320; // Updated rental price for Sleigh
    }

    @Override
    public String toString() {
        return "Brand new sleigh costing " + getRentalPrice() + "$ per day";
    }
}
