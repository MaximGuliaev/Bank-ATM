package action;

import static view.ATMView.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import controller.Controller;
import enums.ATMOperation;


public class EntryActionHandler implements ActionListener {

	public enum ATMCycle { ENTER_CUST_ID, PERFORM_OPERATION }
	public static ATMCycle cycle;
	public static ATMOperation operation;

	public EntryActionHandler() {
		cycle = ATMCycle.ENTER_CUST_ID;
		operation = ATMOperation.UNKNOWN;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch ( cycle ) {
		case ENTER_CUST_ID:
			cycle = ATMCycle.PERFORM_OPERATION;
			outputArea.append(Controller.getInstance().enterCustomerID(entryField.getText()));
			if (cycle == ATMCycle.PERFORM_OPERATION) {
				enableActionButtons(true);
			}
			break;
		case PERFORM_OPERATION: 
			switch (operation) {
			case DEPOSIT:
				outputArea.append(Controller.getInstance().deposit(entryField.getText()));
				break;
			case WITHDRAW:	
				outputArea.append(Controller.getInstance().withdraw(entryField.getText()));
			default:
				outputArea.append("Please choose any action. \n");
				break;
			}
			entryField.setText("");
		}	
	}
	
    private void enableActionButtons(boolean enableFlag) {
        for ( JButton b : actionButtons ) {
            b.setEnabled(enableFlag);
        }
    }
}

