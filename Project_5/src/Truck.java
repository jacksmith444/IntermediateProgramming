
public class Truck extends Car {
    private String model;

    public Truck(String model) {
        super(320); // Updated rental price for Truck
        this.model = model;
    }

    @Override
    public String toString() {
        return "Brand new " + model + " truck costing " + getRentalPrice() + "$ per day";
    }
}
