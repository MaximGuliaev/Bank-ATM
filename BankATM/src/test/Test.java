package test;
import java.io.IOException;

import data.DataSource;
import view.ATMView;

public class Test {

	public static void main(String[] args) {
		// Retrieve the dataFilePath command-line argument
		if ( args.length != 1 ) {
			System.out.println("No input file specified");
		} else {
			String dataFilePath = args[0];

			try {
				System.out.println("Reading data file: " + dataFilePath);
				// Create the data source and load the Bank data
				DataSource dataSource = new DataSource(dataFilePath);
				dataSource.loadData();

				// Run the ATM GUI
				ATMView view = new ATMView();
				view.launchFrame();

			} catch (IOException ioe) {
				System.out.println("Could not load the data file.");
				System.out.println(ioe.getMessage());
				ioe.printStackTrace(System.err);
			}
		}
	}
}