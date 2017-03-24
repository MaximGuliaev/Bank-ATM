package model;

public class SavingsAccount extends Account{
	private double interestRate;
	
	public SavingsAccount(double initBalance, double interestRate) {
		super(initBalance);
		this.interestRate = interestRate;
		//balance = initBalance + interestRate * balance;
	}
	
	public void accumulateInterest() {
		balance = balance + balance*(interestRate/12);
	}
}
