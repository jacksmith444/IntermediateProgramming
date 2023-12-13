/************************************************************************
Programmer: Jackson Smith
Program: Project_4
Purpose: This program reads the contents of a .csv file and then allows
the user to determine how much money they would like to invest in
stocks listed in that file. The program will finish by writing all of
the assets chosen by the user to a .txt file to display them.
 ************************************************************************/

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        // Read potential assets from file
        List<Asset> potentialAssets = AssetDataReader.readDataFromFile("assetData.csv");
        
        // Create a portfolio to manage investments
        Portfolio portfolio = new Portfolio();
        
        // Initialize a scanner to take user input
        Scanner scanner = new Scanner(System.in);

        // Display available assets for investment
        System.out.println("Available assets for investment");
        System.out.println("-------------------------------");
        for (Asset asset : potentialAssets) {
            System.out.println(asset.getName() + " (" + asset.getSymbol() + ")");
        }

        // Continue taking user input until a negative value is entered
        while (true) {
            try {
                // Prompt user for investment amount
                System.out.print("Enter the amount to invest in dollars (or negative to end): ");
                int amount = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                
                // Check if user wants to end the program
                if (amount < 0) {
                    break;
                }

                // Prompt user for asset symbol
                System.out.print("Enter the asset symbol to invest in: ");
                scanner.nextLine(); // Consume newline character
                String symbol = scanner.nextLine().trim();

                // Find the selected asset based on the symbol entered
                Asset selectedAsset = null;
                for (Asset asset : potentialAssets) {
                    if (asset.getSymbol().equals(symbol)) {
                        selectedAsset = asset;
                        break;
                    }
                }

                // If a valid asset is selected
                if (selectedAsset != null) {
                    // Calculate the future value of the investment
                    int futureValue = (int) (amount * Math.pow(1 + selectedAsset.getExpectedReturn(), 10));
                    
                    // Create an investment and add it to the portfolio
                    Investment investment = new Investment(selectedAsset.getSymbol(), amount, futureValue);
                    portfolio.addInvestment(investment);
                    
                    // Print the expected future value
                    System.out.println("Investing " + amount + " in " + selectedAsset.getName() + " has an expected future value of: " + futureValue);
                } else {
                    // If the selected asset is not valid
                    System.out.println(symbol + " is not in the input, or had invalid input data. Choose something else to invest in.");
                }
            } catch (InputMismatchException e) {
                // Handle invalid input (non-integer)
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        // Generate and display the output table
        portfolio.generateOutputTable();
    }
}