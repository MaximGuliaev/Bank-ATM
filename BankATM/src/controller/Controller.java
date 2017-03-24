package controller;

import action.EntryActionHandler;
import action.EntryActionHandler.ATMCycle;
import model.Account;
import model.Bank;
import model.Customer;
import model.OverdraftException;

public class Controller {
	private static Controller instance;
	
    private Customer customer;
    private Account account;
	
	public static Controller getInstance() {
		if ( instance == null ) {
			instance = new Controller();
		} 
		return instance;	
	}

	public String enterCustomerID(String custID) {
		String outputArea =  "";
        int customerID = -1;
        try {
            customerID = Integer.parseInt(custID) - 1;
            customer = Bank.getCustomer(customerID);
            if ( customer == null ) {
                outputArea += "Customer ID is not valid for this Bank: "
                        + custID + "\n";
                outputArea += "Enter your customer ID into the key pad and press the ENTER button.\n";
                EntryActionHandler.cycle = ATMCycle.ENTER_CUST_ID;
            } else {
                account = customer.getAccount(0);
                outputArea += "Welcome " + customer.getFirstName()
                + " " + customer.getLastName() + "\n\n";
            }
        } catch (NumberFormatException nfe) {
            outputArea += "Customer ID is not a number: "
                    + custID;
            EntryActionHandler.cycle = ATMCycle.ENTER_CUST_ID;
        }
		return outputArea;
	}

	public String getBalance() {
       return "Your account balance is: "
                + account.getBalance() + "\n";
		
	}

	public String deposit(String dep) {
		String outputArea = "";
		double amount = -1.0;
        try {
            amount = Double.parseDouble(dep);
            account.deposit(amount);
            outputArea += "Your deposit of " + amount + " was successful.\n";
            outputArea += getBalance();
        } catch (NumberFormatException nfe) {
            outputArea += "Deposit amount is not a number: "
                    + dep;
        }
		return outputArea;
	}

	public String withdraw(String withdr) {
		String outputArea = "";
		double amount = -1.0;
        try {
            amount = Double.parseDouble(withdr);
            account.withdraw(amount);
            outputArea += "Your withdrawal of " + amount + " was successful.\n";
            outputArea += getBalance();
        } catch (OverdraftException nfe) {
            outputArea += "Your withdrawal of "
                    + amount + " was unsuccessful.\n";
        } catch (NumberFormatException nfe) {
            outputArea += "Deposit amount is not a number: "
                    + withdr;
        }
		return outputArea;
	}
}
