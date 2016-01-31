import java.util.*;    //import to use the Date object
public class Order
{
	
		private String orderNumber;
		private Date orderDate;
		private double orderPrice;
		private int orderAmount;
		
		//Constructor - it is executed upon instantiation (with the new keyword)
		public Order(String anorderNumber, Date anorderDate, 
					 double aorderPrice, int aorderAmount)
		{
			setOrderNumber(anorderNumber);
			setOrderDate(anorderDate);
			setOrderPrice(aorderPrice);
			setOrderAmount(aorderAmount);
		}
		
			
		public String getOrderNumber()
		{	return orderNumber; }
		
		public Date getOrderDate()
		{	return orderDate; }
		
		public double getOrderPrice()
		{	return orderPrice; }
		
		public int getOrderAmount()
		{	return orderAmount; }

		public void setOrderNumber(String anorderNumber)
		{	orderNumber = anorderNumber; }
		
		public void setOrderDate(Date anorderDate)
		{	orderDate = anorderDate; }
		
		public void setOrderPrice(double aorderPrice)
		{	orderPrice = aorderPrice; }
		
		public void setOrderAmount(int anorderAmount)
		{	orderAmount = anorderAmount; }
		
		public String toString()  //override the toString method
		{
			String formattedData = " ";
			formattedData += "Order Number: " + getOrderNumber() +
							 "\nOrder Date: " + getOrderDate() +
							 "\nOrder Price: " + getOrderPrice() + 
							 "\nOrder Amount: " + getOrderAmount();
			return formattedData;
		}
									 	
}