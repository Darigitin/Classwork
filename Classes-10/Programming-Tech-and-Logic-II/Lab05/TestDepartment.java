import java.util.*;

public class TestDepartment
{
	static Scanner console = new Scanner (System.in);
	
	public static void main(String args[])
	{
		Department aDepartment;
		
		String department, city;
		
		department = getData("Please enter the Department: ");
		city = getData("Please enter the City: ");
		
		aDepartment = new Department(department, city);
		
		System.out.println("A Departments Data.");
		System.out.println(aDepartment);
	}
	public static String getData(String prompt)
	{
		String data;
		System.out.println(prompt);
		data = console.nextLine();
		return data;
	}
}