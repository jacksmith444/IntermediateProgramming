
import javax.swing.*;
import java.awt.*;

public class BasePanel extends JPanel {
    private JRadioButton thinButton;
    private JRadioButton raisedButton;

    public BasePanel() {
        setLayout(new GridLayout(2, 1));
        setBorder(BorderFactory.createTitledBorder("Base"));

        thinButton = new JRadioButton("Thin");
        raisedButton = new JRadioButton("Raised");

        ButtonGroup group = new ButtonGroup();
        group.add(thinButton);
        group.add(raisedButton);

        add(thinButton);
        add(raisedButton);
    }

    public String getSelectedBase() {
        if (thinButton.isSelected()) {
            return "Thin";
        } else if (raisedButton.isSelected()) {
            return "Raised";
        } else {
            return ""; // Return an empty string if no base selected
        }
    }
}