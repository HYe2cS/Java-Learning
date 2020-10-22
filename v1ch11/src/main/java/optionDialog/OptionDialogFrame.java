package optionDialog;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

/**
 * A frame that contains settings for selecting various option dialogs.
 */
public class OptionDialogFrame extends JFrame {
    private final ButtonPanel typePanel;
    private final ButtonPanel messagePanel;
    private final ButtonPanel messageTypePanel;
    private final ButtonPanel optionTypePanel;
    private final ButtonPanel optionsPanel;
    private final ButtonPanel inputPanel;
    private final String messageString = "Message";
    private final Icon messageIcon = new ImageIcon("blue-ball.gif");
    private final Object messageObject = new Date();
    private final Component messageComponent = new SampleComponent();
    
    public OptionDialogFrame() {
        var gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(2, 3));
        
        typePanel = new ButtonPanel("Type", "Message", "Confirm", "Option", "Input");
        messageTypePanel = new ButtonPanel("Message Type", "ERROR_MESSAGE", "INFORMATION_MESSAGE",
                "WARNING_MESSAGE", "QUESTION_MESSAGE", "PLAIN_MESSAGE");
        messagePanel = new ButtonPanel("Message", "String", "Icon", "Component", "Other",
                "Object[]");
        optionTypePanel = new ButtonPanel("Confirm", "DEFAULT_OPTION", "YES_NO_OPTION",
                "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION");
        optionsPanel = new ButtonPanel("Option", "String[]", "Icon[]", "Object[]");
        inputPanel = new ButtonPanel("Input", "Text field", "Combo box");
        
        gridPanel.add(typePanel);
        gridPanel.add(messageTypePanel);
        gridPanel.add(messagePanel);
        gridPanel.add(optionTypePanel);
        gridPanel.add(optionsPanel);
        gridPanel.add(inputPanel);
        
        // add a panel with a Show button
        
        var showPanel = new JPanel();
        var showButton = new JButton("Show");
        showButton.addActionListener(new ShowAction());
        showPanel.add(showButton);
        
        add(gridPanel, BorderLayout.CENTER);
        add(showPanel, BorderLayout.SOUTH);
        pack();
    }
    
    /**
     * Gets the currently selected message.
     *
     * @return a string, icon, component, or object array, depending on the Message panel selection
     */
    public Object getMessage() {
        String s = messagePanel.getSelection();
        if ("String".equals(s)) {
            return messageString;
        } else if ("Icon".equals(s)) {
            return messageIcon;
        } else if ("Component".equals(s)) {
            return messageComponent;
        } else if ("Object[]".equals(s)) {
            return new Object[]{messageString, messageIcon,
                    messageComponent, messageObject};
        } else if ("Other".equals(s)) {
            return messageObject;
        } else {
            return null;
        }
    }
    
    /**
     * Gets the currently selected options.
     *
     * @return an array of strings, icons, or objects, depending on the Option panel selection
     */
    public Object[] getOptions() {
        String s = optionsPanel.getSelection();
        if ("String[]".equals(s)) {
            return new String[]{"Yellow", "Blue", "Red"};
        } else if ("Icon[]".equals(s)) {
            return new Icon[]{new ImageIcon("yellow-ball.gif"),
                    new ImageIcon("blue-ball.gif"), new ImageIcon("red-ball.gif")};
        } else if ("Object[]".equals(s)) {
            return new Object[]{messageString, messageIcon,
                    messageComponent, messageObject};
        } else {
            return null;
        }
    }
    
    /**
     * Gets the selected message or option type
     *
     * @param panel the Message Type or Confirm panel
     * @return the selected XXX_MESSAGE or XXX_OPTION constant from the JOptionPane class
     */
    public int getType(ButtonPanel panel) {
        String s = panel.getSelection();
        try {
            return JOptionPane.class.getField(s).getInt(null);
        } catch (Exception e) {
            return -1;
        }
    }
    
    /**
     * The action listener for the Show button shows a Confirm, Input, Message, or Option dialog
     * depending on the Type panel selection.
     */
    private class ShowAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            if ("Confirm".equals(typePanel.getSelection())) {
                JOptionPane.showConfirmDialog(
                        OptionDialogFrame.this, getMessage(), "Title", getType(optionTypePanel),
                        getType(messageTypePanel));
            } else if ("Input".equals(typePanel.getSelection())) {
                if ("Text field".equals(inputPanel.getSelection())) {
                    JOptionPane.showInputDialog(
                            OptionDialogFrame.this, getMessage(), "Title", getType(messageTypePanel));
                } else {
                    JOptionPane.showInputDialog(OptionDialogFrame.this, getMessage(), "Title",
                            getType(messageTypePanel), null, new String[]{"Yellow", "Blue", "Red"},
                            "Blue");
                }
            } else if ("Message".equals(typePanel.getSelection())) {
                JOptionPane.showMessageDialog(
                        OptionDialogFrame.this, getMessage(), "Title", getType(messageTypePanel));
            } else if ("Option".equals(typePanel.getSelection())) {
                JOptionPane.showOptionDialog(
                        OptionDialogFrame.this, getMessage(), "Title", getType(optionTypePanel),
                        getType(messageTypePanel), null, getOptions(), getOptions()[0]);
            }
        }
    }
}

/**
 * A component with a painted surface
 */

class SampleComponent extends JComponent {
    @Override
    public void paintComponent(Graphics g) {
        var g2 = (Graphics2D) g;
        var rect = new Rectangle2D.Double(0, 0, getWidth() - 1, getHeight() - 1);
        g2.setPaint(Color.YELLOW);
        g2.fill(rect);
        g2.setPaint(Color.BLUE);
        g2.draw(rect);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(10, 10);
    }
}
