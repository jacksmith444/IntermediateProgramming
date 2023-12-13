
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class RightPanel extends JPanel {
    private ArrayList<JCheckBox> checkBoxes;

    public RightPanel() {
        // Initialize components
        JLabel additionsLabel = new JLabel("Additions:");
        checkBoxes = new ArrayList<>();

        // Create checkboxes
        JCheckBox milkCheckbox = new JCheckBox("Milk");
        JCheckBox sugarCheckbox = new JCheckBox("Sugar");
        JCheckBox sweetenerCheckbox = new JCheckBox("Sweetener");

        // Add checkboxes to the list
        checkBoxes.add(milkCheckbox);
        checkBoxes.add(sugarCheckbox);
        checkBoxes.add(sweetenerCheckbox);

        // Add components to the panel
        setLayout(new GridLayout(4, 1));
        add(additionsLabel);
        add(milkCheckbox);
        add(sugarCheckbox);
        add(sweetenerCheckbox);
    }

    public void displayOrder(String type) {
        // Build the order text based on selected checkboxes
        StringBuilder orderText = new StringBuilder(type + " with:");

        for (JCheckBox checkBox : checkBoxes) {
            if (checkBox.isSelected()) {
                orderText.append(" ").append(checkBox.getText());
            }
        }

        // Update the order confirmation label
        JOptionPane.showMessageDialog(this, orderText.toString(), "Order Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }
}