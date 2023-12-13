/************************
Programmer: Jackson Smith 
*************************/
public class Traveler {
	private static int nextIDNum = 1;
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

	public void setId() {
	this.id = nextIDNum;
	nextIDNum++;
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
	id = nextIDNum;
	nextIDNum++;
	}

	public Traveler(String name, Location current) {
	this.name = name;
	this.current = current;
	}

	public String toString() {
	return  "[Name: " + name + ", id: " + id + ", Current: " + current + "]";
	}
}
