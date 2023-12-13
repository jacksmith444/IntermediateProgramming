
import javax.swing.*;
import java.awt.*;

public class DrinksPanel extends JPanel {
    private JRadioButton cokeButton;
    private JRadioButton dietCokeButton;
    private JRadioButton sweetTeaButton;
    private JSpinner drinksSpinner;

    public DrinksPanel() {
        setLayout(new GridLayout(5, 1));
        setBorder(BorderFactory.createTitledBorder("Drinks"));

        cokeButton = new JRadioButton("Coke");
        dietCokeButton = new JRadioButton("Diet Coke");
        sweetTeaButton = new JRadioButton("Sweet Tea");

        ButtonGroup group = new ButtonGroup();
        group.add(cokeButton);
        group.add(dietCokeButton);
        group.add(sweetTeaButton);

        drinksSpinner = new JSpinner();

        add(cokeButton);
        add(dietCokeButton);
        add(sweetTeaButton);
        add(new JLabel("Quantity:"));
        add(drinksSpinner);
    }

    public String getSelectedDrink() {
        if (cokeButton.isSelected()) {
            return "Coke";
        } else if (dietCokeButton.isSelected()) {
            return "Diet Coke";
        } else if (sweetTeaButton.isSelected()) {
            return "Sweet Tea";
        } else {
            return ""; // Return an empty string if no drink selected
        }
    }

    public int getDrinkQuantity() {
        return (int) drinksSpinner.getValue();
    }
}