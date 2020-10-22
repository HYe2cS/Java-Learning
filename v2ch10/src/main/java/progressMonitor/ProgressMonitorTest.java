package progressMonitor;

import java.awt.*;
import javax.swing.*;

/**
 * A program to test a progress monitor dialog.
 *
 * @author Cay Horstmann
 * @version 1.06 2018-05-01
 */
public class ProgressMonitorTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            var frame = new ProgressMonitorFrame();
            frame.setTitle("ProgressMonitorTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
