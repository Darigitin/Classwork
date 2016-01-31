import java.text.*;

public class HourlyEmployee extends Employee
{
	private double payRate;
	private int hoursWorked;
	
	public HourlyEmployee(String aEmployeeSSN, String aEmployeeName, Department aDepartment, double aPayRate, int aHoursWorked)
	{
		super(aEmployeeSSN, aEmployeeName, aDepartment);
		setPayRate(aPayRate);
		setHoursWorked(aHoursWorked);
	}
	
	public double calcGrossPay()
	{
		return hoursWorked * payRate;
	}
	
	public void setPayRate(double aPayRate)
	{
		payRate = aPayRate;
	}
	
	public void setHoursWorked(int aHoursWorked)
	{
		hoursWorked = aHoursWorked;
	}
	
	public double getPayRate()
	{
		return payRate;
	}
	
	public int getHoursWorked()
	{
		return hoursWorked;
	}
	
	public String toString()
	{
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		String formattedData = "";
		
		formattedData += super.toString() +
				"\n" + super.getEmployeeName() + "'s Hours Worked: " +  getHoursWorked() +
				"\n" + super.getEmployeeName() + "'s Pay Rate: " + currencyFormat.format(getPayRate());
		return formattedData;
	}
}