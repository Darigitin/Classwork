import java.util.*;

public class DepartmentTester
{
	static Scanner console = new Scanner(System.in);
	
	public static void main(String args[])
	{
		Department aDepartment = new Department();  //instantiation -- testing Order

		String location, departmentNumber;
		departmentNumber = getData("Enter Department Number: ");
		location = getData("Enter Location: ");
		
		//testing the setters
		aDepartment.setDepartmentNumber(departmentNumber);
		aDepartment.setLocation(location);
		
		//testing the getters
		System.out.println("The Department Info");
		System.out.println("Department: " + aDepartment.getDepartmentNumber());		
		System.out.println("Location: " + aDepartment.getLocation());
		
	}

	public static String getData(String prompt)
	{	
		String data;
		System.out.print(prompt);
		data = console.nextLine();
		return data;
	}
}