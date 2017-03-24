package action;

import static view.ATMView.entryField;
import static view.ATMView.outputArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;
import enums.ATMOperation;

public class ActListener implements ActionListener {

	private ATMOperation operation;

	public ActListener(ATMOperation op) {
		operation = op;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		entryField.setText("");
		switch(operation) {
		case GET_BALANCE:
			outputArea.append(Controller.getInstance().getBalance());
			break;
		case DEPOSIT:
			outputArea.append("Enter the amount to deposit into the"
					+ " key pad and press the ENTER button.\n");
			EntryActionHandler.operation = ATMOperation.DEPOSIT;
			break;
		case WITHDRAW:
			outputArea.append("Enter the amount to withdraw into the"
					+ " key pad and press the ENTER button.\n");
			EntryActionHandler.operation = ATMOperation.WITHDRAW;
			break;
		default: 
			//TODO
		}

	}

}
