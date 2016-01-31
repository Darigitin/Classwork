import java.util.*;
import java.text.*;

public abstract class Order
{
	private int   orderNumber;
	private Date  orderDate;
	private int   orderAmount;
	private double   orderPrice;
	private Customer customer;
	
	private static final double PRICE = 20;


	public Order(int anOrderNumber, Date anOrderDate,
		int anAmount, double aPrice, Customer aCustomer) throws Exception
		{
			setOrderNumber(anOrderNumber);
			setOrderDate(anOrderDate);
			setOrderAmount(anAmount);
			setOrderPrice(aPrice);
			setCustomer(aCustomer);
			aCustomer.setOrder(this);		//add the order to the customer's account
		}
		
	public Order(int anOrderNumber, Date anOrderDate, int anAmount, Customer aCustomer)	throws Exception //overloaded Constructor	
	{
		this(anOrderNumber, anOrderDate, anAmount, PRICE, aCustomer);		//keyword - this refers to itself (this order)
	}
	
	public double calcOrderTotal()
	{
		
		return getOrderAmount() * getOrderPrice();
		//or could write:   return orderAmount * orderPrice;
	}
	
	public double calcOrderTotal(double discountRate)  //overloaded calcOrderTotal
	{
		double orderTotal, discountAmount=0;				//local variables
		orderTotal = this.calcOrderTotal();					//calculate the regular total first
		discountAmount = orderTotal * discountRate;		    //calculate the discount amount
		return orderTotal - discountAmount;					//apply discount to the order total
	}
	
		
	public void setOrderNumber(int anOrderNumber)
		{ orderNumber = anOrderNumber;	}
	
	public void setOrderDate(Date anOrderDate)
		{ orderDate = anOrderDate;	}
	
	public void setOrderAmount(int anAmount) throws AmountOrderedException
		{ 	if (anAmount > 0)
					orderAmount = anAmount;
		  	else
			{
				orderAmount = 0;
				AmountOrderedException ao = new AmountOrderedException();
				throw ao;
			}
		}

	public void setOrderPrice(double aPrice)
		{	orderPrice = aPrice;	}
	
	public void setCustomer(Customer aCustomer)
	{
		customer = aCustomer;
	}

		
	public int getOrderNumber()
		{	return orderNumber;	}
	
	public Date getOrderDate()
		{	return orderDate;	}

	public double getOrderAmount()
		{	return orderAmount;	}
	
	public double getOrderPrice()
		{ 	return orderPrice;	}
		
	public Customer getCustomer()
	{
		return customer;
	}
		
	public String toString()
		{
			DateFormat mediumFormat = 
				DateFormat.getDateInstance(DateFormat.MEDIUM);
				
			NumberFormat currencyFormat = 
				NumberFormat.getCurrencyInstance();
								

			String info;
				
			info = "\n" + "Order Number: " + getOrderNumber() + "\n" +
					"Order Date: " +   mediumFormat.format(getOrderDate())  + "\n" +
					"Order Amount: " + getOrderAmount() + "\n" +
					"Order Price: " + currencyFormat.format(getOrderPrice()) + "\n";
					
			return info;
		}
}																							