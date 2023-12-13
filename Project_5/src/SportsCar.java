
public class SportsCar extends Car {
    private String model;
    private int horsepower;

    public SportsCar(String model, int horsepower) {
        super(320); // Updated rental price for SportsCar
        this.model = model;
        this.horsepower = horsepower;
    }

    @Override
    public String toString() {
        return "Brand new " + model + " sports car with " + horsepower + " HP costing " + getRentalPrice() + "$ per day";
    }
}
