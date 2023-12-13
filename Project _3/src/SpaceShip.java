public class SpaceShip {
    private String name;
    private Location currentLocation;
    private Traveler[] passengers;
    private int passengerCount;
    private int flightHours;

    public SpaceShip(String name, Location currentLocation, int capacity) {
        this.name = name;
        this.currentLocation = currentLocation;
        this.passengers = new Traveler[capacity];
        this.passengerCount = 0;
        this.flightHours = 0; // Initialize flight hours to 0
    }

    public String getName() {
        return name;
    }
    
    public Traveler[] getPassengers() {
        return passengers;
    }
    
    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setCurrentLocation(String location) {
        Location newLocation = Location.valueOf(location.toUpperCase());
        if (newLocation != this.currentLocation) {
            this.currentLocation = newLocation;
            System.out.println("Spaceship moved to " + newLocation);
        } else {
            System.out.println("Spaceship is already at " + newLocation);
        }
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public boolean addTraveler(Traveler traveler) {
        if (passengerCount == passengers.length) {
            return false; // SpaceShip is already full
        }

        passengers[passengerCount] = traveler;
        passengerCount++;
        return true;
    }

    public boolean removeTraveler(Traveler traveler) {
        for (int i = 0; i < passengerCount; i++) {
            if (passengers[i] == traveler) {
                for (int j = i; j < passengerCount - 1; j++) {
                    passengers[j] = passengers[j + 1];
                }
                passengers[passengerCount - 1] = null;
                passengerCount--;
                return true; // Traveler successfully removed
            }
        }
        return false; // Traveler not found
    }

    public Traveler findTravelerById(int id) {
        for (Traveler traveler : passengers) {
            if (traveler != null && traveler.getId() == id) {
                return traveler;
            }
        }
        return null; // Traveler not found
    }

    public int getFlightHours() {
        return flightHours;
    }

    public void incrementFlightHours(int hours) {
        flightHours += hours;
    }

    @Override
    public String toString() {
        return "SpaceShip{" +
                "name='" + name + '\'' +
                ", currentLocation=" + currentLocation +
                ", passengerCount=" + passengerCount +
                ", flightHours=" + flightHours +
                '}';
    }
}