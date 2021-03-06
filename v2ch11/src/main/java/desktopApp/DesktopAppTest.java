package desktopApp;

import java.awt.*;
import javax.swing.*;

/**
 * This program demonstrates the desktop app API.
 *
 * @author Cay Horstmann
 * @version 1.01 2016-05-10
 */
public class DesktopAppTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new DesktopAppFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}