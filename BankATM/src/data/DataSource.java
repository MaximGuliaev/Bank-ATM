package data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import model.Bank;
import model.CheckingAccount;
import model.Customer;
import model.SavingsAccount;

public class DataSource {
	private File dataFile;
	
	public DataSource(String dataFilePath) {
		dataFile = new File(dataFilePath);
	}
	
	public void loadData() throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(dataFile));
		String line = buffRead.readLine();
		while(line.isEmpty()) {
			line =  buffRead.readLine();
		}
		Integer numberOfCustomers = Integer.parseInt(line);
		for(int i= 0; i < numberOfCustomers; i++) {
			line = buffRead.readLine();
			while(line != null) {
				if(!line.isEmpty()) {
					int numberOfAccounts = 0;
					String[] splitted = line.split("\\s+");
					if (splitted[0].length() > 1 && isAlpha(splitted[0])) {
						Bank.addCustomer(splitted[0], splitted[1]);
						Customer customer = Bank.getCustomer(Bank.getNumOfCustomers() - 1);
						numberOfAccounts = Integer.parseInt(splitted[2]);
						for(int j = 0; j < numberOfAccounts; j ++) {
							line = buffRead.readLine();
						    splitted = line.split("\\s+");
						    if(splitted[0].equals("S")) {
						    	customer.addAccount(new SavingsAccount(Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2])));
						    } else if(splitted[0].equals("C")) {
						    	customer.addAccount(new CheckingAccount(Double.parseDouble(splitted[1]), Double.parseDouble(splitted[2])));
						    }
						}
					}

				}
				line = buffRead.readLine();
			}
		}
		buffRead.close();
	}
	
	public boolean isAlpha(String name) {
	    return name.matches("[a-zA-Z]+");
	}
}
