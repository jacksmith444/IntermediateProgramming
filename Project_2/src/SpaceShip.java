/************************
Programmer: Jackson Smith 
*************************/
public class SpaceShip {
	private Location current;
	private Location destination;
	private String name;
	private int capacity;
	private int numTravelers = 0;
	private Traveler[] travelers;



	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public int getCapacity() {
		return capacity;
	}

	public Location getCurrent() {
		return current;
	}

	public void setCurrent(Location current) {
		this.current = current;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setDestination(Location destination) {
		this.destination = destination;
	}

	public Location getDestination() {
		return destination;
	}

	public SpaceShip() {
		name = null;
		current = null;
		destination = null;
		capacity = 10;
		travelers = new Traveler[capacity];
	}

	public SpaceShip(String name, Location current, Location destination, int capacity) {
		this.name = name;
		this.current = current;
		this.destination = destination;
		this.capacity = capacity;
		travelers = new Traveler[capacity];
	}

	 // Method to board a traveler
    public boolean board(Traveler t) {
        if (numTravelers < capacity && !isOnBoard(t)) {
            travelers[numTravelers] = t;
            numTravelers++;
            return true;
        }
        return false;
    }
    
    // Method to remove a traveler from the spaceship
    public boolean leave(Traveler t) {
        for (int i = 0; i < numTravelers; i++) {
            if (travelers[i] == t) {
                travelers[i] = null;
                for (int j = i; j < numTravelers - 1; j++) {
                    travelers[j] = travelers[j + 1];
                }
                travelers[numTravelers - 1] = null;
                numTravelers--;
                return true;
            }
        }
        return false;
    }

	// Method to check if a traveler is on board
    public boolean isOnBoard(Traveler t) {
        for (int i = 0; i < numTravelers; i++) {
            if (travelers[i] == t) {
                return true;
            }
        }
        return false;
    }
    
    // Method to move the spaceship
    public void move() {
        Location temp = current;
        current = destination;
        destination = temp;

        for (int i = 0; i < numTravelers; i++) {
            travelers[i].setCurrent(current);
        
        }

     // Clear the travelers array
       travelers = new Traveler[capacity];
       numTravelers = 0;
    }

    // toString method
    public String toString() {
        return "Spaceship [name=" + name + ", current=" + current + ", destination=" + destination + ", capacity=" + capacity + ", passengers=" + numTravelers + "]";
    }

	public Traveler[] getTravelers() {
		return travelers;
	}
}