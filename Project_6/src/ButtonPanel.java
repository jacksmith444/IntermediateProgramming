
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {
    private JButton calculateButton;
    private JButton exitButton;

    public ButtonPanel(OrderCalculator orderCalculator) {
        setLayout(new FlowLayout(FlowLayout.RIGHT));

        calculateButton = new JButton("Calculate");
        exitButton = new JButton("Exit");

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                orderCalculator.calculateOrder();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(calculateButton);
        add(exitButton);
    }
}