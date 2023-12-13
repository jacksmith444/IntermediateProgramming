
import java.awt.GridLayout;

import javax.swing.*;

public class CoffeeShopApp extends JFrame {
    public CoffeeShopApp() {
        // Initialize components
        RightPanel rightPanel = new RightPanel();
        LeftPanel leftPanel = new LeftPanel(rightPanel);

        // Set layout for the main frame
        setLayout(new GridLayout(1, 2));

        // Add panels to the frame
        add(leftPanel);
        add(rightPanel);

        // Set frame properties
        setTitle("Coffee Shop App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CoffeeShopApp();
            }
        });
    }
}