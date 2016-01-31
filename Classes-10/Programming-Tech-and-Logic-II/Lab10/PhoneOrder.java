import java.util.*;
import java.text.*;

public class PhoneOrder extends Order implements ThankYouMsg
{
	private String callRep;
	private int callDuration;
	private final double PHONEFEE = 5.00;
	
	
	public PhoneOrder(int anOrderNumber, 
		Date anOrderDate, int anAmount, double aPrice,Customer aCustomer, String aCallRep, int aCallDuration) 
			throws Exception
	
		
	{ 
		super(anOrderNumber, anOrderDate, anAmount, aPrice, aCustomer);
		setCallRep(aCallRep);
		setCallDuration(aCallDuration);
	}		  
	
	public PhoneOrder(int anOrderNumber, Date anOrderDate, 
	 	int anAmount,Customer aCustomer, String aCallRep, int aCallDuration) throws Exception
	{ 
		super(anOrderNumber, anOrderDate, anAmount, 20.00, aCustomer);
		setCallRep(aCallRep);
		setCallDuration(aCallDuration);

	}		  
	
	public String thanksMsg()
	{
		String thanks;
		thanks = "\nThank you for placing your order through the phone\n";
		return thanks;
	}
	public double calcOrderTotal()
	{
		double amtDue = super.calcOrderTotal();
		amtDue = amtDue + PHONEFEE;
		return amtDue;
	}
	
	public double calcOrderTotal(double discount)
	{
		double amtDue = super.calcOrderTotal(discount);
		amtDue = amtDue + PHONEFEE;
		return amtDue;
	}
	

	public void setCallRep(String aCallRep)
	{	callRep = aCallRep;
	}
	
	public String getCallRep()
	{	return callRep;
	}
	
	public void setCallDuration(int aCallDuration) 
	{ 
		if (aCallDuration > 0)
			callDuration = aCallDuration;
		else{
		
			callDuration = 0;
		}
	}
	
	public int getCallDuration()
	{	return callDuration;
	}
	public String toString()
	{	
		String info;
		
		info = 	super.toString() + "\n" +
				"Call Rep " + 
				getCallRep() + "\n" +
				"Call Duration in minutes " + 
				getCallDuration() + 
				"\nTotal Due: " + calcOrderTotal() +
				"\n" + thanksMsg();
		
		return info;
	}
	

			
}		