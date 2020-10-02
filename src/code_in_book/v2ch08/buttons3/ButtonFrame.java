package buttons3;

import java.awt.*;
import javax.swing.*;

import runtimeAnnotations.*;

/**
 * A frame with a button panel.
 *
 * @author Cay Horstmann
 * @version 1.00 2004-08-17
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
        add(panel);
        
        yellowButton = new JButton("Yellow");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");
        
        panel.add(yellowButton);
        panel.add(blueButton);
        panel.add(redButton);
        
        ActionListenerInstaller.processAnnotations(this);
    }
    
    @ActionListenerFor(source = "yellowButton")
    public void yellowBackground() {
        panel.setBackground(Color.YELLOW);
    }
    
    @ActionListenerFor(source = "blueButton")
    public void blueBackground() {
        panel.setBackground(Color.BLUE);
    }
    
    @ActionListenerFor(source = "redButton")
    public void redBackground() {
        panel.setBackground(Color.RED);
    }
}
