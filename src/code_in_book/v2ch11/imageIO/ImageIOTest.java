package imageIO;

import java.awt.*;
import javax.swing.*;

/**
 * This program lets you read and write image files in the formats that the JDK supports.
 * Multi-file images are supported.
 *
 * @author Cay Horstmann
 * @version 1.05 2018-05-01
 */
public class ImageIOTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            var frame = new ImageIOFrame();
            frame.setTitle("CompositeTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
