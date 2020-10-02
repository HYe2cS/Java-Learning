package fileChooser;

import java.awt.*;
import javax.swing.*;

/**
 * @author Cay Horstmann
 * @version 1.26 2018-04-10
 */
public class FileChooserTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new ImageViewerFrame();
            frame.setTitle("FileChooserTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
