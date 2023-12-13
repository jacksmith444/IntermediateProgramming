
import javax.swing.*;
import java.awt.*;

public class ToppingPanel extends JPanel {
    private JCheckBox cheeseCheckbox;
    private JCheckBox pineappleCheckbox;
    private JCheckBox pepperoniCheckbox;
    private JCheckBox goldFlakesCheckbox;

    public ToppingPanel() {
        setLayout(new GridLayout(4, 1));
        setBorder(BorderFactory.createTitledBorder("Topping"));

        cheeseCheckbox = new JCheckBox("Cheese");
        pineappleCheckbox = new JCheckBox("Pineapple");
        pepperoniCheckbox = new JCheckBox("Pepperoni");
        goldFlakesCheckbox = new JCheckBox("Gold Flakes");

        add(cheeseCheckbox);
        add(pineappleCheckbox);
        add(pepperoniCheckbox);
        add(goldFlakesCheckbox);
    }

    public int getSelectedToppingCount() {
        int count = 0;
        if (cheeseCheckbox.isSelected()) {
            count++;
        }
        if (pineappleCheckbox.isSelected()) {
            count++;
        }
        if (pepperoniCheckbox.isSelected()) {
            count++;
        }
        if (goldFlakesCheckbox.isSelected()) {
            count++;
        }
        return count;
    }
}