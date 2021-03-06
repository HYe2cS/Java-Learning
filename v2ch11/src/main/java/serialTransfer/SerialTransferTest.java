package serialTransfer;

import java.awt.*;
import javax.swing.*;

/**
 * This program demonstrates the transfer of serialized objects between virtual machines.
 *
 * @author Cay Horstmann
 * @version 1.04 2018-05-01
 */
public class SerialTransferTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            var frame = new SerialTransferFrame();
            frame.setTitle("SerialTransferTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
