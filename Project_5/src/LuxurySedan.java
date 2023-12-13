
public class LuxurySedan extends Car {
    private String model;

    public LuxurySedan(String model) {
        super(50); // Updated rental price for LuxurySedan
        this.model = model;
    }

    @Override
    public String toString() {
        return "Brand new " + model + " luxury sedan costing " + getRentalPrice() + "$ per day";
    }
}
