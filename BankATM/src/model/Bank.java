package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bank implements Serializable {
	private static List<Customer> customers;
	private static int numberOfCustomers;
	
//	public Bank() {
//	}
	
	static {
		customers = new ArrayList<>();
		numberOfCustomers = 0;
	}
	
	public static void addCustomer(String f, String l) {
		customers.add(new Customer(f,l));
		numberOfCustomers = numberOfCustomers + 1;
	}
	
	public static int getNumOfCustomers() {
		return numberOfCustomers;
	}
	
	public static Customer getCustomer(int index) {
		if (index > numberOfCustomers || index < 0)
			return null;
		return customers.get(index);
	}
}
