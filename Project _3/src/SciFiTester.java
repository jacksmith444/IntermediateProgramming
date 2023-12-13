import java.util.Scanner;

public class SciFiTester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AvailableTravelers availableTravelers = createAvailableTravelers();

        SpaceShip[] spaceships = createSpaceShips();

        // Implement the text-menu system
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add traveler to a Spaceship");
            System.out.println("2. Search for traveler on a Spaceship");
            System.out.println("3. Move a spaceship to a new location");
            System.out.println("4. Display a list of Available Travelers");
            System.out.println("5. Display a list of Travelers on a specific SpaceShip");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add traveler to a Spaceship
                    addTravelerToSpaceShip(scanner, availableTravelers, spaceships);
                    break;
                case 2:
                    // Search for traveler on a Spaceship
                    searchTravelerOnSpaceShip(scanner, spaceships);
                    break;
                case 3:
                    // Move a spaceship to a new location
                    moveSpaceShip(scanner, spaceships);
                    break;
                case 4:
                    // Display a list of Available Travelers
                    System.out.println(availableTravelers);
                    break;
                case 5:
                    // Display a list of Travelers on a specific SpaceShip
                    displayTravelersOnSpaceShip(scanner, spaceships);
                    break;
                case 6:
                    // Exit
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);
    }

    private static AvailableTravelers createAvailableTravelers() {
        AvailableTravelers availableTravelers = new AvailableTravelers(10);

        // Creating Travelers (Passengers and Crew members)
        availableTravelers.addTraveler(new Passenger("John Doe", Location.EARTH, 1499.00, SeatCategory.FIRST, 12000));
        availableTravelers.addTraveler(new Passenger("Jane Smith", Location.BELT, 998.00, SeatCategory.BUSINESS, 8000));
        availableTravelers.addTraveler(new Passenger("Bob Johnson", Location.MARS, 449.00, SeatCategory.COACH, 3000));
        availableTravelers.addTraveler(new Passenger("Mary Davis", Location.RING, 998.00, SeatCategory.BUSINESS, 15000));
        availableTravelers.addTraveler(new Crew("Captain 1", Location.EARTH, "Captain", 500.00, 10000));
        availableTravelers.addTraveler(new Crew("Captain 2", Location.EARTH, "Captain", 500.00, 10000));
        availableTravelers.addTraveler(new Crew("Co-Captain 1", Location.EARTH, "Co-Captain", 450.00, 9000));
        availableTravelers.addTraveler(new Crew("Co-Captain 2", Location.EARTH, "Co-Captain", 450.00, 9000));
        availableTravelers.addTraveler(new Crew("Crewman 1", Location.EARTH, "Crewman", 300.00, 7000));
        availableTravelers.addTraveler(new Crew("Crewman 2", Location.EARTH, "Crewman", 300.00, 7000));

        return availableTravelers;
    }

    private static SpaceShip[] createSpaceShips() {
        SpaceShip[] spaceships = new SpaceShip[2];

        // Create spaceships with default values
        spaceships[0] = new SpaceShip("Rocinante", Location.RING, 20);
        spaceships[1] = new SpaceShip("Behemoth", Location.EARTH, 15);

        return spaceships;
    }

    private static void addTravelerToSpaceShip(Scanner scanner, AvailableTravelers availableTravelers, SpaceShip[] spaceships) {
        System.out.print("Enter the ID of the traveler to add: ");
        int travelerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Available Spaceships:");
        for (int i = 0; i < spaceships.length; i++) {
        System.out.println(i + ". " + spaceships[i].getName());
        }

        System.out.print("Select a spaceship by entering its index: ");
        int spaceshipIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        SpaceShip selectedSpaceShip = spaceships[spaceshipIndex];
        Traveler selectedTraveler = availableTravelers.findTravelerById(travelerId);

        if (selectedTraveler != null) {
            boolean boarded = selectedSpaceShip.addTraveler(selectedTraveler);
            if (boarded) {
                availableTravelers.removeTraveler(selectedTraveler);
                System.out.println("Traveler successfully added to " + selectedSpaceShip.getName());
            } else {
            System.out.println("Boarding failed. The spaceship is full.");
            }
        } else {
            System.out.println("Invalid traveler ID.");
        }
    }

    private static void searchTravelerOnSpaceShip(Scanner scanner, SpaceShip[] spaceships) {
        System.out.print("Enter the ID of the traveler to search: ");
        int travelerId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (SpaceShip spaceShip : spaceships) {
            Traveler foundTraveler = spaceShip.findTravelerById(travelerId);
            if (foundTraveler != null) {
                System.out.println("Traveler found on " + spaceShip.getName() + ": " + foundTraveler);
                return;
            }
        }

        System.out.println("Traveler with ID " + travelerId + " not found on any spaceship.");
    }

    private static void moveSpaceShip(Scanner scanner, SpaceShip[] spaceships) {
        System.out.println("Available Spaceships:");
        for (int i = 0; i < spaceships.length; i++) {
            System.out.println(i + ". " + spaceships[i].getName());
        }

        System.out.print("Select a spaceship by entering its index: ");
        int spaceshipIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter the new location: ");
        String newLocation = scanner.nextLine();

        spaceships[spaceshipIndex].setCurrentLocation(newLocation);
    }

    private static void displayTravelersOnSpaceShip(Scanner scanner, SpaceShip[] spaceships) {
        System.out.println("Available Spaceships:");
        for (int i = 0; i < spaceships.length; i++) {
            System.out.println(i + ". " + spaceships[i].getName());
        }

        System.out.print("Select a spaceship by entering its index: ");
        int spaceshipIndex = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.println("Travelers on " + spaceships[spaceshipIndex].getName() + ":");
        System.out.println(spaceships[spaceshipIndex].getPassengerCount() + " out of " + spaceships[spaceshipIndex].getPassengers().length + " seats filled.");
        for (Traveler traveler : spaceships[spaceshipIndex].getPassengers()) {
            if (traveler != null) {
                System.out.println(traveler);
            }
        }
    }
}