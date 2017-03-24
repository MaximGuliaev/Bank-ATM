package model;

public class CheckingAccount extends Account {
	private double overdraftAmount;
	
	public CheckingAccount(double initBalance, double overdraft) {
		super(initBalance);
		overdraftAmount = overdraft;
	}
	
	public CheckingAccount(double initBalance) {
		super(initBalance);
	}
	
	public void withdraw(double amt) throws OverdraftException {
		if (balance + overdraftAmount < amt) {
			throw new OverdraftException("Exception: Insufficient funds for overdraft protection. Deficit: ", amt - balance - overdraftAmount);
		}
		if (balance <= amt) {
			overdraftAmount = overdraftAmount + balance - amt;
			balance = 0;
		} else {
			balance = balance - amt;
		}
	}	
}
