
public abstract class Traveler {
    private static int nextIDNum=1;
    private int id;
    private Location current;
    private String name;

    public Location getCurrent() {
        return current;
    }

    public void setCurrent(Location current) {
        this.current = current;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Traveler() {
        name = null;
        current = null;
        setId(); // Assign a unique ID
    }

    public Traveler(String name, Location current) {
        this.name = name;
        this.current = current;
        setId(); // Assign a unique ID
    }

    private void setId() {
        this.id = nextIDNum;
        nextIDNum++;
    }

    public abstract void move(SpaceShip s);

    public abstract String toString();
}
