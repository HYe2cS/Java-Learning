package spinner;

import java.awt.*;
import javax.swing.*;

/**
 * A program to test spinners.
 *
 * @author Cay Horstmann
 * @version 1.04 2018-05-01
 */
public class SpinnerTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            var frame = new SpinnerFrame();
            frame.setTitle("SpinnerTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

