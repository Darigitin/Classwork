import java.util.*;

public class EmployeeTester
{
	static Scanner console = new Scanner(System.in);
	
	public static void main(String args[])
	{
		Employee aEmployee = new Employee();  //instantiation -- testing Order

		String employeeSNN, employeeName;
		employeeSNN = getData("Enter Employee Social Security Number: ");
		employeeName = getData("Enter Name: ");
		
		//testing the setters
		aEmployee.setEmployeeSNN(employeeSNN);
		aEmployee.setEmployeeName(employeeName);
		
		//testing the getters
		System.out.println("Employee Info");
		System.out.println("Social Security Number: " + aEmployee.getEmployeeSNN());		
		System.out.println("Name: " + aEmployee.getEmployeeName());
		
	}

	public static String getData(String prompt)
	{	
		String data;
		System.out.print(prompt);
		data = console.nextLine();
		return data;
	}
}