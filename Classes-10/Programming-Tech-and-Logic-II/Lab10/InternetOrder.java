import java.util.*;

public class InternetOrder extends Order implements ThankYouMsg 
{
	private String custEmail;
	
	public InternetOrder (int anOrderNumber, Date anOrderDate,
		int anAmount, double aPrice, Customer aCustomer, String aCustEmail) throws Exception
		
	{ 
		super(anOrderNumber, anOrderDate, anAmount, aPrice, aCustomer);
		setCustEmail(aCustEmail);
	}		  
	
	public InternetOrder(int anOrderNumber, Date anOrderDate, 
	 	int anAmount,Customer aCustomer,String aCustEmail) throws Exception
	{ 
		super(anOrderNumber, anOrderDate, anAmount, aCustomer);
		setCustEmail(aCustEmail);
	}		  

	public String thanksMsg()
	{
		String thanks;
		thanks = "\nThank you for placing your order through our Internet Site\n";
		return thanks;
	}
	
	public void setCustEmail(String aCustEmail)	
	{	custEmail = aCustEmail; 	}
	
	public String getCustEmail()
	{	return custEmail;		}
	
	public String toString()
	{	
		
		String info;
		
		info = 	super.toString() + "\n" +
				"Customer email: " + getCustEmail() +
				"\nTotal Due: " + super.calcOrderTotal() +
				"\n" +  thanksMsg();
		
		return info;
	}
	
			
}		