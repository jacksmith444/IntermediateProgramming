/****************************
 * 
 * Programmer: Jackson Smith
 * Program: Project_5
 * 
 ***************************/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello and welcome to Rent-A-Thingy");

        boolean renting = true;

        while (renting) {
            System.out.print("Please tell me the purpose of the object you want to rent (type 'checkout' to finish): ");
            String purpose = scanner.nextLine();

            if (purpose.equalsIgnoreCase("checkout")) {
                System.out.println("Thank you for renting with us! Have a great day!");
                renting = false;
            } else {
                Rentable rentable = RentableFactory.create(purpose);

                if (rentable != null) {
                    System.out.println(rentable);
                    System.out.print("Would you like to rent it? (y/n) ");
                    String response = scanner.nextLine();

                    if (response.equalsIgnoreCase("y")) {
                        System.out.print("How many days? ");
                        int days = scanner.nextInt();
                        double totalCost = rentable.getRentalPrice() * days;
                        System.out.println("That would be " + totalCost + "$. Thank you!");
                    }
                } else {
                    System.out.println("Sorry, we don't have anything available for that purpose.");
                }

                System.out.print("Do you want to rent anything else? (y/n) ");
                String rentAgainResponse = scanner.next();
                renting = rentAgainResponse.equalsIgnoreCase("y");

                // Clear the buffer
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
