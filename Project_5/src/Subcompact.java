
public class Subcompact extends Car {
    private String model;

    public Subcompact(String model) {
        super(25); // Updated rental price for Subcompact
        this.model = model;
    }

    @Override
    public String toString() {
        return "Brand new " + model + " subcompact car costing " + getRentalPrice() + "$ per day";
    }
}
