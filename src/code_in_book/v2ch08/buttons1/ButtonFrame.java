package buttons1;

import javax.swing.*;

/**
 * A frame with a button panel.
 *
 * @author Cay Horstmann
 * @version 1.00 2007-11-02
 */
public class ButtonFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    
    private final JPanel panel;
    private final JButton yellowButton;
    private final JButton blueButton;
    private final JButton redButton;
    
    public ButtonFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        panel = new JPanel();
        panel.setName("panel");
        add(panel);
        
        yellowButton = new JButton("Yellow");
        yellowButton.setName("yellowButton");
        blueButton = new JButton("Blue");
        blueButton.setName("blueButton");
        redButton = new JButton("Red");
        redButton.setName("redButton");
        
        panel.add(yellowButton);
        panel.add(blueButton);
        panel.add(redButton);
    }
}
