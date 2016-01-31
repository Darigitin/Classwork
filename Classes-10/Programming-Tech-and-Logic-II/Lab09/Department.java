import java.util.ArrayList;

public class Department
{
	private String location;
	private String departmentNumber;
	private ArrayList<Employee> employees;
	
	public Department(String aLocation, String aDepartmentNumber)
	{
		setDepartmentNumber(aDepartmentNumber);
		setLocation(aLocation);
		employees = new ArrayList<Employee>();
	}
		
	//getter or accessor methods
	public String getDepartmentNumber()
	{		return departmentNumber; }
	
	public String getLocation()
	{		return location; }
	
	public ArrayList<Employee> getEmployee()
	{
		return employees;
	}

	
	//setter or mutator methods
	
	public void setDepartmentNumber(String aDepartmentNumber)
	{	departmentNumber = aDepartmentNumber;	}

	public void setLocation(String aLocation)
	{	location = aLocation;	} 				//attribute = passed argument
	
	public void setEmployee (Employee aEmployee)
	{
		employees.add(aEmployee);
		aEmployee.setDepartment(this);
	}
	
	public String toString()
	{
		String formattedData = "";
		
		formattedData += "Department Number: " +getDepartmentNumber() +
						 "\nLocation: " + getLocation() +
						 "\nNumber of Employees: " + getEmployee().size() +
						 "\nEmployees: " + getEmployee();
		return formattedData;
	}
	
}