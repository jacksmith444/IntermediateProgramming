
import java.util.Random;

public class RentableFactory {
    public static Rentable create(String purpose) {
        Random random = new Random();

        switch (purpose.toLowerCase()) {
            case "fly by day":
                return new Carpet("pink and purple"); // Updated pattern and rental price for Carpet
            case "racing":
                return new SportsCar("Bugatti Veyron", 1200); // Updated model, horsepower, and rental price for SportsCar
            case "inner city ride":
                return new Subcompact("Kia Rio"); // Updated model and rental price for Subcompact
            default:
                return null;
        }
    }
}
