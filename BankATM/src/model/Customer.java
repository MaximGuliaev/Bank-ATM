package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String firstName;
	private String lastName;
	private List<Account> account;
	private int numberOfAccounts;
	
    public Customer(String f, String l) {
    	firstName = f;
    	lastName = l;
    	account = new ArrayList<Account>();
    	numberOfAccounts = 0;
    }
    
    public String getFirstName() {
    	return firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
//    public Account getAccount() {
//    	return account;
//    }
    
//    public void setAccount( Account acct) {
//    	account = acct;
//    }
    
    public void addAccount(Account acc) {
    	account.add(acc);
    	numberOfAccounts = numberOfAccounts + 1;
    }
    
    public Account getAccount(int index) {
    	return account.get(index);
    }
    
    public int getNumOfAccounts() {
    	return numberOfAccounts;
    }
    
}
