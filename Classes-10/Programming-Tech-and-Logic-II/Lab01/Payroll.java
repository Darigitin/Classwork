import java.util.*;
import java.text.NumberFormat;

public class Payroll
{
	private static Scanner console = new Scanner(System.in);
	public static void main(String args[])
	{
		//determine variables needed for program based on the code below
		int employeeID, hw, ow, numberOfWeeks;
		String employeeName;
		double pr, monthlyPay, pay, totalPay, overTimePay;
		char moreEmployees;
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
	
	
		totalPay = 0;
		hw = 0;
		overTimePay = 0;
		
		System.out.println("Please enter number of weeks to process: ");
		numberOfWeeks = console.nextInt();
		
		do 
		{
				
			System.out.println("Please enter employeeID: ");
			employeeID = console.nextInt();
			System.out.println("Please enter employeeName: ");
			employeeName = console.next();
			System.out.println("Please enter pay rate: ");
			pr = console.nextDouble();
			monthlyPay = 0;
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
			System.out.println("--------------------------------------------");
			System.out.println("Employee: " + employeeName);
			System.out.println("Pay: " + fmt.format(monthlyPay));
			System.out.println("--------------------------------------------");
			totalPay = totalPay + monthlyPay + overTimePay;
			System.out.println("More employees? y/n");
			moreEmployees = console.next().charAt(0);
		}while (moreEmployees == 'Y' || moreEmployees == 'y');
		
		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");
		System.out.println("Total Monthly Payroll: " + fmt.format(totalPay));
		System.out.println("--------------------------------------------");
		System.out.println("--------------------------------------------");

	
	}
}