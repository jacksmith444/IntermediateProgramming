public class Crew extends Traveler {
	private String position;
    private double pay;
    private int flightHours;

    public Crew() {
        super();
        position = null;
        pay = 0.0;
        flightHours = 0;
    }

    public Crew(String name, Location current, String position, double pay, int flightHours) {
        super(name, current);
        this.position = position;
        this.pay = pay;
        this.flightHours = flightHours;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    public int getFlightHours() {
        return flightHours;
    }

    public void setFlightHours(int flightHours) {
        this.flightHours = flightHours;
    }

    @Override
    public void move(SpaceShip s) {
        // Update flight hours based on the flight hours of the SpaceShip
        flightHours += s.getFlightHours();
    }

    @Override
    public String toString() {
        return "Crew [name=" + getName() + ", id=" + getId() + ", current=" + getCurrent() +
                ", position=" + position + ", pay = $" + pay + ", flight hours = " + flightHours + "]";
    }
}
