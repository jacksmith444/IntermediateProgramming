
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderCalculator extends JFrame {

    private BasePanel basePanel;
    private ToppingPanel toppingPanel;
    private DrinksPanel drinksPanel;
    private ButtonPanel buttonPanel;

    public OrderCalculator(String title) {
        super(title);
        initializeComponents();
    }

    private void initializeComponents() {
        basePanel = new BasePanel();
        toppingPanel = new ToppingPanel();
        drinksPanel = new DrinksPanel();
        buttonPanel = new ButtonPanel(this);

        setLayout(new BorderLayout());
        add(basePanel, BorderLayout.WEST);
        add(toppingPanel, BorderLayout.CENTER);
        add(drinksPanel, BorderLayout.EAST);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void displayOrderSummary(double subtotal, double tax, double total) {
        String summary = String.format("Subtotal: $%.2f\nTax: $%.2f\nTotal: $%.2f", subtotal, tax, total);
        JOptionPane.showMessageDialog(this, summary, "Order Summary", JOptionPane.INFORMATION_MESSAGE);
    }

    public void calculateOrder() {
        // Get the selected base
        String selectedBase = basePanel.getSelectedBase();
        double baseCost = getBaseCost(selectedBase);

        // Get the selected toppings
        int toppingCount = toppingPanel.getSelectedToppingCount();
        double toppingCost = getToppingCost(toppingCount);

        // Get the selected drink
        String selectedDrink = drinksPanel.getSelectedDrink();
        int drinkQuantity = drinksPanel.getDrinkQuantity();
        double drinkCost = getDrinkCost(selectedDrink, drinkQuantity);

        // Calculate subtotal, tax, and total
        double subtotal = baseCost + toppingCost + drinkCost;
        double tax = subtotal * 0.1; // Assuming a 10% tax rate, adjust as needed
        double total = subtotal + tax;

        // Display the order summary
        displayOrderSummary(subtotal, tax, total);
    }

    private double getBaseCost(String selectedBase) {
        if (selectedBase.equals("Thin")) return 5.99;
        else if (selectedBase.equals("Raised")) return 6.99;
        return 0.0; // Default if no base is selected
    }

    private double getToppingCost(int toppingCount) {
        return toppingCount * 1.50; // $1.50 per topping
    }

    private double getDrinkCost(String selectedDrink, int quantity) {
        if (selectedDrink.equals("Coke")) return quantity * 1.00;
        else if (selectedDrink.equals("Diet Coke")) return quantity * 1.20;
        else if (selectedDrink.equals("Sweet Tea")) return quantity * 1.50;
        else return 0.0; // Default if no drink is selected
    }
}