/********************************
 * Programmer: Jackson Smith
 * Program: Project 6
 *******************************/
import javax.swing.SwingUtilities;

public class PizzaShop {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OrderCalculator orderCalculator = new OrderCalculator("Pizza Shop Order Calculator");
            orderCalculator.setSize(500, 300);
            orderCalculator.setDefaultCloseOperation(OrderCalculator.EXIT_ON_CLOSE);
            orderCalculator.setVisible(true);
        });
    }
}