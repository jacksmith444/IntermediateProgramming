import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AssetDataReader {

    // Method to read asset data from a file and return a list of assets
    public static List<Asset> readDataFromFile(String filename) {
        List<Asset> assets = new ArrayList<>(); // Create a list to store assets

        try {
            Scanner scanner = new Scanner(new File(filename)); // Open the file for reading
            while (scanner.hasNextLine()) { // Loop through each line in the file
                String[] line = scanner.nextLine().split(","); // Split the line into an array of strings
                
                // If the line contains stable asset data (3 elements)
                if (line.length >= 3) {
                    String symbol = line[0]; // Extract symbol
                    String name = line[1];   // Extract name
                    
                    try {
                        double expectedReturn = Double.parseDouble(line[2]); // Extract expected return
                        assets.add(new StableAsset(symbol, name, expectedReturn)); // Create a new StableAsset and add it to the list
                    } catch (NumberFormatException e) {
                        // Handle bad data gracefully (e.g., non-numeric expected return)
                    }
                } 
                // If the line contains stock data (5 elements)
                else if (line.length == 5) {
                    String symbol = line[0]; // Extract symbol
                    String name = line[1];   // Extract name
                    
                    try {
                        double fiveYear = Double.parseDouble(line[2]);   // Extract 5-year return
                        double oneYear = Double.parseDouble(line[3]);    // Extract 1-year return
                        double ninetyDay = Double.parseDouble(line[4]);  // Extract 90-day return
                        
                        // Create a new Stock and add it to the list
                        assets.add(new Stock(symbol, name, fiveYear, oneYear, ninetyDay));
                    } catch (NumberFormatException e) {
                        // Handle bad data gracefully (e.g., non-numeric return values)
                    }
                }
            }
            scanner.close(); // Close the scanner after reading the file
        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            System.out.println("The input file (" + filename + ") could not be found.");
            System.exit(1); // Terminate the program
        }

        return assets; // Return the list of assets
    }
}