import java.util.ArrayList;

public class Customer {

		// attribute definitions
	 	private String name;
	 	private String address;
	 	private String phoneNo;
	 	private double creditLimit;
	 	private double balance;
	 	private ArrayList<Order> custOrders;  
	 	
	 	private static int totalCustomers = 0;   //add a static variable to count the number of Customers.
			
		// constructor with parameters
		public Customer(String aName, String anAddress, String aPhoneNo, double aCreditLimit, double aBalance)
		{
			// invoke setters to populate attributes
			setName(aName);
			setAddress(anAddress);
			setPhoneNo(aPhoneNo);
			setCreditLimit(aCreditLimit);
			setBalance(aBalance);
			totalCustomers++;
			custOrders = new ArrayList<Order>();  
		}
		
		public double totalOrders()			
		{
			double total = 0;
			for (Order o: custOrders)			
			{
				total += (o.calcOrderTotal());
												  
			}
			return total;
		}
		
		public void removeOrders()
		{
			custOrders.clear();
		
		}

		public void updateBalance(double anAmount)
		{	balance += anAmount;		}
		
		
		
		public boolean checkLimit(double amount)
		{
			if (creditLimit < amount)
				return false;
			else
				return true;
		}
		
		// getters
	 	public String getName()
	 		{ return name;}
		public String getAddress()
	 		{ return address;}
		public String getPhoneNo()
	 		{ return phoneNo;}
	 	public double getCreditLimit() 
	 	{	return creditLimit;	}
	 	
	 	public double getBalance()
	 	{	return balance;	 	}
		
		public ArrayList<Order> getOrder()   
		{
			return custOrders;
		}
		public static int getTotalCustomers()
 		{	return totalCustomers;   	}		//code to retrieve the value of totalCustomers
		
		// setters
		public void setName(String newName)
			{ name = newName;}
		public void setAddress(String newAddress)
			{ address = newAddress;}
		public void setPhoneNo(String newPhoneNo)
			{ phoneNo = newPhoneNo;}
		public void setCreditLimit(double aCreditLimit)
			{		creditLimit = aCreditLimit;		}
		public void setBalance(double aBalance)
		{	balance = aBalance;		}
		
		public void setOrder(Order anOrder) 
		{

			custOrders.add(anOrder);
			anOrder.setCustomer(this);		//putting this customer in the Order.  

		}
		
		

		public String toString()
			{
				String info;
				info = "Customer name = "
						+ getName() + "\nAddress = "
						+ getAddress() + "\nPhone Number = "
						+ getPhoneNo()+ "\nCredit Limit= " 
						+ getCreditLimit() + "\nBalance= "
						+ getBalance() + "\nOrders " 
						+ getOrder();
				return info;
			}
 


}
