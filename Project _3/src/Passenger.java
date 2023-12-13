
public class Passenger extends Traveler{
	private double cost;
    private SeatCategory seat;
    private int rewardsPoints;

    public Passenger() {
        super();
        cost = 0.0;
        seat = SeatCategory.NOSEAT;
        rewardsPoints = 0;
    }

    public Passenger(String name, Location current, double cost, SeatCategory seat, int rewardsPoints) {
        super(name, current);
        this.cost = cost;
        this.seat = seat;
        this.rewardsPoints = rewardsPoints;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public SeatCategory getSeat() {
        return seat;
    }

    public void setSeat(SeatCategory seat) {
        this.seat = seat;
    }

    public int getRewardsPoints() {
        return rewardsPoints;
    }

    public void setRewardsPoints(int rewardsPoints) {
        this.rewardsPoints = rewardsPoints;
    }

    @Override
    public void move(SpaceShip s) {
        if (rewardsPoints > 10000) {
        if (seat != SeatCategory.FIRST) {
            seat = SeatCategory.FIRST;
        } else {
            cost *= 0.8; // Apply 20% discount
        }
        rewardsPoints = 0; // Reset points
        }

        // Add 100 rewards points for each flight hour
        rewardsPoints += s.getFlightHours() * 100;
    }

    @Override
    public String toString() {
        return "Passenger [name=" + getName() + ", id=" + getId() + ", current=" + getCurrent() +
                ", seat=" + seat + ", cost = $" + cost + ", rewardsPoints = " + rewardsPoints + "]";
    }
}
