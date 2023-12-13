
public class SUV extends Car {
    private String model;

    public SUV(String model) {
        super(320); // Updated rental price for SUV
        this.model = model;
    }

    @Override
    public String toString() {
        return "Brand new " + model + " SUV costing " + getRentalPrice() + "$ per day";
    }
}
