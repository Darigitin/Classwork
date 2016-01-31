import java.util.*;

public class Department
{
	private String department, city;
	
	public Department(String aDepartment, String aCity)
	{
		setDepartment(aDepartment);
		setCity(aCity);
	}
	
	public String getDepartment()
	{	return department;	}
	
	public String getCity()
	{	return city;	}
	
	public void setDepartment(String aDepartment)
	{	department = aDepartment;	}
	
	public void setCity(String aCity)
	{	city = aCity;	}
	
	public String toString()
	{
		String formattedData = "";
		formattedData += "Department: " + getDepartment() +
							"\nCity: " + getCity();
		return formattedData;
	}
}