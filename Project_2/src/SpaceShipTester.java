/*****************************************************************************************************************************************
Programmer: Jackson Smith
Program: Project_2
Purpose: This program collects data about travelers and spaceships regarding to their names, locations, ids, capacity, and destinations.
The program keeps track of this data and any changes that come from the spaceships or travelers moving from one location to another.
*******************************************************************************************************************************************/
import java.util.Scanner;

public class SpaceShipTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Part 1: Asking for travelers and spaceships
        Traveler[] travelers = new Traveler[4];
        SpaceShip[] spaceships = new SpaceShip[2];

        for (int i = 0; i < 4; i++) {
            travelers[i] = createTraveler(scanner, i + 1);
        }

        for (int i = 0; i < 2; i++) {
            spaceships[i] = createSpaceShip(scanner, i + 1);
        }

        // Part 2-4: Executing a text-menu
        int choice;
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add traveler to a Spaceship
                    boardTraveler(scanner, spaceships, travelers);
                    break;
                case 2:
                    // Search for traveler on a Spaceship
                    searchForTraveler(scanner, spaceships);
                    break;
                case 3:
                    // Move a spaceship to a new location
                    moveSpaceships(spaceships);
                    break;
                case 4:
                    // Exit the program
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);
    }

	private static Traveler createTraveler(Scanner scanner, int travelerNum) {
		//Getting traveler information
        System.out.println("Data for Traveler " + travelerNum);
        scanner.nextLine(); // Consume newline
        System.out.print("Name: ");
        String name = scanner.nextLine();
        
        Location location;
        do {
            System.out.print("Current: ");
            try {
                location = Location.valueOf(scanner.nextLine().toUpperCase());
                break; // Valid input, exit loop
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid location. Please try again.");
            }
        } while (true);

        Traveler traveler = new Traveler(name, location);
        traveler.setId(); // Set unique ID
        System.out.println("Traveler " + travelerNum + " " + traveler);
        return traveler;
    }

    // Helper method to create a Spaceship
    private static SpaceShip createSpaceShip(Scanner scanner, int shipNum) {
    	//Getting spaceship's info
        System.out.println("Data for Ship " + shipNum);
        scanner.nextLine(); // Consume newline
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Current: ");
        Location currentLocation = Location.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Destination: ");
        Location destination = Location.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Capacity: ");
        int capacity = scanner.nextInt();

        SpaceShip spaceship = new SpaceShip(name, currentLocation, destination, capacity);
        System.out.println("Ship " + shipNum + " " + spaceship);
        return spaceship;
    }

    // Method to display the menu
    private static void displayMenu() {
        System.out.println("Choose an option");
        System.out.println("1: Add traveler to Spaceship");
        System.out.println("2: Search for traveler on Spaceship");
        System.out.println("3: Move Spaceship to new Location");
        System.out.println("4: Exit");
        System.out.print("Enter choice (1-4): ");
    }

    // Method to board a traveler on a spaceship
    private static void boardTraveler(Scanner scanner, SpaceShip[] spaceships, Traveler[] travelers) {
        System.out.print("Enter the ID of the Traveler (1-" + travelers.length + "): ");
        int travelerIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the ID of the Spaceship (1-" + spaceships.length + "): ");
        int spaceshipIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (travelerIndex < 1 || travelerIndex > travelers.length || spaceshipIndex < 1 || spaceshipIndex > spaceships.length) {
            System.out.println("Invalid input. Please try again.");
            return;
        }

        Traveler traveler = travelers[travelerIndex - 1];
        SpaceShip spaceship = spaceships[spaceshipIndex - 1];

        // Check if the current location of the traveler matches the current location of the spaceship
        if (traveler.getCurrent() != spaceship.getCurrent()) {
            System.out.println("Traveler and Spaceship are not at the same location. Boarding unsuccessful.");
            return;
        }

        boolean success = spaceship.board(traveler);

        System.out.println("Boarding Traveler " + traveler.getName());
        System.out.println("Boarding Ship " + spaceship.getName());
        System.out.println(success ? "Successful!" : "Unsuccessful!");
        System.out.println(traveler);
        System.out.println(spaceship);
    }

    private static void searchForTraveler(Scanner scanner, SpaceShip[] spaceships) {
    	//Searching for traveler
        System.out.print("Enter the name of the Traveler: ");
        String travelerName = scanner.nextLine();

        System.out.print("Enter the name of the Spaceship: ");
        String shipName = scanner.nextLine();

        Traveler foundTraveler = null;
        SpaceShip foundShip = null;

        for (SpaceShip spaceship : spaceships) {
            if (spaceship != null && spaceship.getName().equals(shipName)) {
                for (Traveler traveler : spaceship.getTravelers()) {
                    if (traveler != null && traveler.getName().equals(travelerName)) {
                        foundTraveler = traveler;
                        foundShip = spaceship;
                        break;
                    }
                }
                break; // Found the spaceship, no need to continue searching
            }
        }

        System.out.println("Searching for Traveler: " + travelerName);
        System.out.println("Searching in Ship " + shipName);
        if (foundTraveler != null) {
            System.out.println("true");
            System.out.println(foundTraveler);
            System.out.println(foundShip);
        } else {
            System.out.println("false");
            System.out.println("Traveler " + travelerName + " not found on Ship " + shipName);
        }
    }

    // Method to move a spaceship
    private static void moveSpaceships(SpaceShip[] spaceships) {
        System.out.println("Choose a Spaceship to move:");
        for (int i = 0; i < spaceships.length; i++) {
            if (spaceships[i] != null) {
                System.out.println((i + 1) + ": " + spaceships[i].getName());
            }
        }

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice < 1 || choice > spaceships.length || spaceships[choice - 1] == null) {
            System.out.println("Invalid choice. Please try again.");
            return;
        }

        SpaceShip spaceship = spaceships[choice - 1];
        spaceship.move();

        System.out.println("Moving Ship " + spaceship.getName());
        System.out.println(spaceship);
    }
}
