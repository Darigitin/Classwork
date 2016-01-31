import java.text.*;
import java.util.ArrayList;

public class Tester
{
	private Department aDepartment;
	private SalariedEmployee firstEmployee;
	private HourlyEmployee secondEmployee;
	private CommissionedEmployee thirdEmployee;
	
	public static void main(String args[])
	{
		int sum = 0;
		Department aDepartment = new Department("Amarillo", "1");
		SalariedEmployee firstEmployee = new SalariedEmployee("555-55-5555", "Bob", aDepartment, 60000);
		HourlyEmployee secondEmployee = new HourlyEmployee("444-44-4444", "Joe", aDepartment, 20, 160);
		CommissionedEmployee thirdEmployee = new CommissionedEmployee("333-33-3333", "Bill", aDepartment, .10, 50000);
		System.out.println(aDepartment);
		
		for(Employee o: aDepartment.getEmployee())
		{
			sum += o.calcGrossPay();
		}
		System.out.println("The total pay for this Department is " + sum);
	}
}