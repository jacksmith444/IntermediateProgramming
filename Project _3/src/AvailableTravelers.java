import java.util.Arrays;

public class AvailableTravelers {
    private Traveler[] travelers;
    private int numOfTravelers;

    public AvailableTravelers() {
        travelers = new Traveler[20];
        numOfTravelers = 0;
    }

    public AvailableTravelers(int capacity) {
        travelers = new Traveler[capacity];
        numOfTravelers = 0;
    }

    public boolean addTraveler(Traveler t) {
        if (numOfTravelers == travelers.length) {
            return false; // Array is already full
        }

        for (int i = 0; i < numOfTravelers; i++) {
            if (travelers[i].getId() == t.getId()) {
                return false; // Traveler with the same ID already exists
            }
        }

        travelers[numOfTravelers] = t;
        numOfTravelers++;
        return true;
    }

    public boolean removeTraveler(Traveler t) {
        for (int i = 0; i < numOfTravelers; i++) {
            if (travelers[i].equals(t)) {
                for (int j = i; j < numOfTravelers - 1; j++) {
                    travelers[j] = travelers[j + 1];
                }
                travelers[numOfTravelers - 1] = null;
                numOfTravelers--;
                return true; // Traveler successfully removed
            }
        }
        return false; // Traveler not found
    }

    public Traveler[] getAllTravelers() {
        Traveler[] available = new Traveler[numOfTravelers];
        int count = 0;

        for (int i = 0; i < numOfTravelers; i++) {
            Location currentLocation = travelers[i].getCurrent();

            if (currentLocation != Location.EARTH &&
                currentLocation != Location.BELT &&
                currentLocation != Location.MARS &&
                currentLocation != Location.RING) {
                available[count++] = travelers[i];
            }      
        }

        return Arrays.copyOf(available, count);
    }

    public Traveler findTravelerByName(String name) {
        for (int i = 0; i < numOfTravelers; i++) {
            if (travelers[i].getName().equals(name)) {
                return travelers[i];
            }
        }
        return null; // Traveler not found
    }

    public Traveler findTravelerById(int id) {
        for (int i = 0; i < numOfTravelers; i++) {
            if (travelers[i].getId() == id) {
                return travelers[i];
            }
        }
        return null; // Traveler not found
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Available Travelers:\n");

        for (int i = 0; i < numOfTravelers; i++) {
            result.append(travelers[i].toString()).append("\n");
        }

        return result.toString();
    }
}