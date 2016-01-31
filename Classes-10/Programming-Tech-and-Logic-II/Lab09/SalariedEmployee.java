import java.text.*;
public class SalariedEmployee extends Employee
{
	private double salary;
	
	public SalariedEmployee(String aEmployeeSSN, String aEmployeeName, Department aDepartment, double aSalary)
	{
		super(aEmployeeSSN, aEmployeeName, aDepartment);
		setSalary(aSalary);
	}
	
	public double calcGrossPay()
	{
		return salary / 12;
	}
	
	public void setSalary(double aSalary)
	{
		salary = aSalary;
	}
	
	public double getSalary()
	{
		return salary;
	}
	
	public String toString()
	{
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		String formattedData = "";
		
		formattedData = super.toString() +
			"\n" + super.getEmployeeName() + "'s Salary: " + currencyFormat.format(getSalary());
		return formattedData;
	}
}

