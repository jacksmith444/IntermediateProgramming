
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel {
    private JButton regularButton;
    private JButton decafButton;
    private JButton orderButton;

    public LeftPanel(RightPanel rightPanel) {
        // Initialize components
        regularButton = new JButton("Regular");
        decafButton = new JButton("Decaf");
        orderButton = new JButton("Order!");

        // Add action listeners to the buttons
        regularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle regular button click
                rightPanel.displayOrder("Regular");
            }
        });

        decafButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle decaf button click
                rightPanel.displayOrder("Decaf");
            }
        });

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle order button click
                rightPanel.displayOrder("Custom Order");
            }
        });

        // Add components to the panel
        setLayout(new FlowLayout());
        add(regularButton);
        add(decafButton);
        add(orderButton);
    }
}