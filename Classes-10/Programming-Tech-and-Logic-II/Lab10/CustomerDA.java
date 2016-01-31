import java.io.*;

public class CustomerDA
{
	private Customer customer;
	
	
	public CustomerDA(Customer aCustomer) throws IOException
	{
		customer = aCustomer;

	}
	
	public void writeData() throws IOException
	{		
		FileWriter outData = new FileWriter("Customer.dat", false);
	
		PrintWriter outFile = new PrintWriter(outData);

		
		outFile.println(customer);
		
		outFile.close();
	}
	
	public void writeOrders() throws IOException
	{
		FileWriter outData = new FileWriter("Orders.dat", false);
		PrintWriter outFile = new PrintWriter(outData);
		outFile.println(customer);
		outFile.close();
	}
	
}			
		
	