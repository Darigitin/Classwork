import java.util.ArrayList;

public class TestDepartmentAssociations
{
	private static Department aDepartment;
	
	private static Employee aEmployee;
	
	public static void main(String args[])
	{
		setItUp();
		System.out.println(aDepartment);
	}
	public static void setItUp()
	{
		aDepartment = new Department("Amarillo", "1");
		aEmployee = new Employee("555-55-5555", "John Smith", aDepartment);
	}
	
}