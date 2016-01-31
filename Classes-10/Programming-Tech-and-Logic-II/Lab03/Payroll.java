import java.util.*;
import java.text.NumberFormat;

public class Payroll
{
	static int employeeID, hw, ow, numberOfWeeks;
	static String employeeName;
	static double pr, monthlyPay, pay, totalPay, overTimePay;
	static char moreEmployees;
	static NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	private static Scanner console = new Scanner(System.in);
	
	public static void main(String args[])
	{
		totalPay = 0;
		hw = 0;
		overTimePay = 0;
		
		getWeeks("Please enter the number of weeks to process: ");
		
		do 
		{
				
			System.out.println("Please enter employeeID: ");
			employeeID = console.nextInt();
			System.out.println("Please enter employeeName: ");
			employeeName = console.next();
			System.out.println("Please enter pay rate: ");
			pr = console.nextDouble();
			monthlyPay = 0;
			calcPay();
			employeePay();
			totalPay = totalPay + monthlyPay + overTimePay;
			System.out.println("More employees? y/n");
			moreEmployees = console.next().charAt(0);
		}while (moreEmployees == 'Y' || moreEmployees == 'y');
		displayTotalPay();

	
	}
	public static void getWeeks(String prompt)
	{
		System.out.println(prompt + ' ');
		numberOfWeeks = console.nextInt();
	}
	public static void calcPay()
	{
		for (int x = 1; x <= numberOfWeeks; x++)
		{
			System.out.println("Please enter hours worked for week " + x + ": ");
			hw = console.nextInt();
			pay = hw * pr;
			monthlyPay = monthlyPay + pay;
		}
		if (hw > 40)
		{
			ow = hw - 40;
			overTimePay = 1.5 * (pr * ow);
		}
	}
	public static void employeePay()
	{
		System.out.println("--------------------------------------------");
		System.out.println("Employee: " + employeeName);
		System.out.println("Pay: " + fmt.format(monthlyPay));
		System.out.println("--------------------------------------------");
	}
	public static void displayTotalPay()
	{
		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");
		System.out.println("Total Monthly Payroll: " + fmt.format(totalPay));
		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");
	}
}