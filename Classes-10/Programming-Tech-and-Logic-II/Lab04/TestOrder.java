import java.util.*;

public class TestOrder
{
	static Scanner keyboard = new Scanner (System.in);
	
	public static void main(String args[])
	{
		Order aOrder;
		Order bOrder;
		
		String ordernumber;
		Date orderdate;
		int orderamount;
		double orderprice;
			
		
		ordernumber = getData("Enter Your Order Number: ");
		orderdate = new Date();  //instantiates Date and returns today's date??????
		orderprice = Double.parseDouble(getData("Enter the Order Price: "));
		orderamount = Integer.parseInt(getData("Enter the Order Amount: "));
			
		aOrder = new Order(ordernumber, orderdate, orderprice, orderamount);

		System.out.println("A Order's Data");
		
		System.out.println(aOrder);
		
		bOrder = new Order("12", orderdate, 23.32, 2); //correct
		
		System.out.println(bOrder);
	
	//	bOrder = new Order(orderdate, "12", 2, 23.32); //error
				
	
		
		
	
	
	
	}
	public static String getData(String prompt)
	{	
		String data;
		System.out.print(prompt);
		data = keyboard.nextLine();
		return data;
	}
}