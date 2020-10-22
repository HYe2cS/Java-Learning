package menu;

import java.awt.*;
import javax.swing.*;

/**
 * @author Cay Horstmann
 * @version 1.25 2018-04-10
 */
public class MenuTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new MenuFrame();
            frame.setTitle("MenuTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
