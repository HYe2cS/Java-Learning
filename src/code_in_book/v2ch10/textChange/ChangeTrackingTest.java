package textChange;

import java.awt.*;
import javax.swing.*;

/**
 * @author Cay Horstmann
 * @version 1.42 2018-05-01
 */
public class ChangeTrackingTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            var frame = new ColorFrame();
            frame.setTitle("ChangeTrackingTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
