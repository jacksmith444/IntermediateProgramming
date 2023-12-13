
public abstract class Vehicle implements Rentable {
    private double rentalPrice;

    public Vehicle(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    @Override
    public double getRentalPrice() {
        return rentalPrice;
    }
}
