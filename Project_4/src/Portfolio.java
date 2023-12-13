import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Portfolio {
    private List<Investment> investments;

    // Constructor to initialize the list of investments
    public Portfolio() {
        this.investments = new ArrayList<>();
    }

    // Method to add an investment to the portfolio
    public void addInvestment(Investment investment) {
        investments.add(investment);
    }

    // Method to generate and print the output table
    public void generateOutputTable() {
        // Print the header of the output table
        System.out.println("+--------------+-----------------+--------------------+");
        System.out.println("| ASSET SYMBOL | AMOUNT INVESTED | VALUE IN TEN YEARS |");
        System.out.println("+==============+=================+====================+");

        int totalInvested = 0;
        int totalValue = 0;

        // Iterate through each investment in the portfolio
        for (Investment investment : investments) {
            // Print the details of each investment
            System.out.printf("| %-13s| %-16d| %-20d|\n", investment.getAssetSymbol(), investment.getAmountInvested(), investment.getFutureValue());

            // Update the total invested and total value
            totalInvested += investment.getAmountInvested();
            totalValue += investment.getFutureValue();
        }

        // Print the footer of the output table
        System.out.println("+--------------+-----------------+--------------------+");
        System.out.printf("| %-13s| %-16d| %-20d|\n", "TOTAL", totalInvested, totalValue);
        System.out.println("+--------------+-----------------+--------------------+");

        // Write to portfolio.txt
        try (FileWriter writer = new FileWriter("portfolio.txt")) {
            writer.write("+--------------+-----------------+--------------------+\n");
            writer.write("| ASSET SYMBOL | AMOUNT INVESTED | VALUE IN TEN YEARS |\n");
            writer.write("+==============+=================+====================+\n");

            for (Investment investment : investments) {
                writer.write(String.format("| %-13s| %-16d| %-20d|\n", investment.getAssetSymbol(), investment.getAmountInvested(), investment.getFutureValue()));
            }

            writer.write("+--------------+-----------------+--------------------+\n");
            writer.write(String.format("| %-13s| %-16d| %-20d|\n", "TOTAL", totalInvested, totalValue));
            writer.write("+--------------+-----------------+--------------------+\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}