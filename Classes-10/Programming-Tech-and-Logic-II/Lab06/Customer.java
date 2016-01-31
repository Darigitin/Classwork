import java.text.NumberFormat;

public class Customer
{
	private String name;
	private String address;
	private String phone;
	private double custBalance;
	private double creditLimit;
	private NumberFormat fmt = NumberFormat.getCurrencyInstance();
		
	public Customer(String aName, String anAddress, String aPhone, 
					double aCustBalance, double aCreditLimit)
	{
		setName(aName);
		setAddress(anAddress);
		setPhone(aPhone);
		setCreditLimit(aCreditLimit);
		setCustBalance(aCustBalance);
	}
	
	//overloaded constructor
		
	public Customer(String aName, String anAddress, String aPhone, double aCreditLimit)
	{
		this(aName, anAddress, aPhone, 0.00, aCreditLimit);
	}
	
	public Customer(String aName, double aCreditLimit)
	{
		setName(aName);
		setCreditLimit(aCreditLimit);
		
	}
	
	//getter or accessor methods
	public String getName()
	{		return name; }
	
	public String getAddress()
	{	return address;	}
	
	public String getPhone()
	{	return phone;	}
	
	public double getCustBalance()
	{	return custBalance;	}			//return attribute
	
	public double getCreditLimit()
	{	return creditLimit;	}
	
	//setter or mutator methods
	
	public void setName(String aName)
	{	name = aName;	}					//attribute = passed argument
	
	public void setAddress(String anAddress)
	{	address = anAddress;	}
	
	public void setPhone(String aPhone)
	{	phone = aPhone;	}
	
	public void setCustBalance(double aCustBalance)
	{
		if (aCustBalance <= getCreditLimit())
			{custBalance = aCustBalance;}
		else
			{custBalance = 0;}
	}
	
	public void setCreditLimit(double aCreditLimit)
	{	creditLimit = aCreditLimit;	}
	
	public String toString()
	{
		String formattedData = "";
		formattedData += "Customer Name: " + getName() +
						 "\nPhone: " + getPhone() +
						 "\nAddress: " + getAddress() +
						 "\nBalance: " + fmt.format(getCustBalance()) +
						 "\nCredit limit: " + fmt.format(getCreditLimit());
		return formattedData;
	}

}
	
	
	
	