package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import action.ActListener;
import action.CloseHandler;
import action.EntryActionHandler;
import action.KeyPadHandler;
import enums.ATMOperation;

public class ATMView {
    
    // GUI component instance variables
    protected static JFrame frame;
    private static JPanel pLeftHalf;
    private static JPanel pRightHalf;
    public static JButton[] actionButtons;
    public static JTextField entryField;
    private static JTextField messageField;
    public static JTextArea outputArea;
    
    public ATMView() {
        frame = new JFrame("The First Java Bank ATM");
        frame.addWindowListener(new CloseHandler());
        initializeFrameComponents();
    }
    
    public void launchFrame() {
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
        outputArea.setText("Enter your customer ID into the key pad and press the ENTER button.\n");
    }
    
    private void initializeFrameComponents() {
        initLeftHalf();
        initRightHalf();
    }
    
    private void initLeftHalf() {
        pLeftHalf = new JPanel();
        pLeftHalf.setLayout(new GridLayout(2, 1));
        initTopLeft();
        initBottomLeft();
        frame.add(pLeftHalf, BorderLayout.WEST);
    }
    
    private void initTopLeft() {
        JButton b;
        JPanel topLeftPanel = new JPanel();
        topLeftPanel.setLayout(new GridLayout(3, 1));
        actionButtons = new JButton[3];
        b = new JButton("Display account balance");
        actionButtons[0] = b;
        b.addActionListener(new ActListener(ATMOperation.GET_BALANCE)); 
        b.setEnabled(false);
        topLeftPanel.add(b);
        b = new JButton("Make a deposit");
        actionButtons[1] = b;
        b.addActionListener(new ActListener(ATMOperation.DEPOSIT)); 
        b.setEnabled(false);
        topLeftPanel.add(b);
        b = new JButton("Make a withdrawal");
        b.setEnabled(false);
        actionButtons[2] = b;
        b.addActionListener(new ActListener(ATMOperation.WITHDRAW)); 
        topLeftPanel.add(b);
        pLeftHalf.add(topLeftPanel);
    }
    
    private void initBottomLeft() {
        // Initialize entry text field and keypad grid panel
        JPanel entryKeyPadPanel = new JPanel();
        entryKeyPadPanel.setLayout(new BorderLayout());
        // Create and add entry text field
        entryField = new JTextField(10);
        entryKeyPadPanel.add(entryField, BorderLayout.NORTH);
        // Create keypad grid and buttons
        JPanel keyPadGrid = new JPanel();
        keyPadGrid.setLayout(new GridLayout(4, 3));
        KeyPadHandler keyPadHandler = new KeyPadHandler();
        JButton[] keyPadButtons = new JButton[]
        {new JButton("1"),
                 new JButton("2"),
                 new JButton("3"),
                 new JButton("4"),
                 new JButton("5"),
                 new JButton("6"),
                 new JButton("7"),
                 new JButton("8"),
                 new JButton("9"),
                 new JButton("0"),
                 new JButton(".")};
                 for ( JButton b : keyPadButtons ) {
                     b.addActionListener(keyPadHandler);
                     keyPadGrid.add(b);
                 }
                 JButton enterButton = new JButton("ENTER");
                 enterButton.addActionListener(new EntryActionHandler());
                 keyPadGrid.add(enterButton);
                 entryKeyPadPanel.add(keyPadGrid, BorderLayout.SOUTH);
                 // Add entry/keypad panel to left-half panel
                 pLeftHalf.add(entryKeyPadPanel);
    }
    
    private void initRightHalf() {
        pRightHalf = new JPanel();
        pRightHalf.setLayout(new BorderLayout());
        outputArea = new JTextArea(10, 75);
        pRightHalf.add(outputArea, BorderLayout.CENTER);
        messageField = new JTextField(75);
        pRightHalf.add(messageField, BorderLayout.SOUTH);
        //pRightHalf.setEnabled(false);
        frame.add(pRightHalf, BorderLayout.EAST);
    }
}
