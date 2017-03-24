package action;

import static view.ATMView.entryField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class KeyPadHandler implements ActionListener {
    public void actionPerformed(ActionEvent event) {
        JButton b = (JButton) event.getSource();
        entryField.setText(entryField.getText() + b.getText());
    }
}
