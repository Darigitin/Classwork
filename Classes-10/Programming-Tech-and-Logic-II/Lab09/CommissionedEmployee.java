import java.text.*;

public class CommissionedEmployee extends Employee
{
	private double commissionRate, salesAmount;
	
	public CommissionedEmployee(String aEmployeeSSN, String aEmployeeName, Department aDepartment, double aCommissionRate, double aSalesAmount)
	{
		super(aEmployeeSSN, aEmployeeName, aDepartment);
		setCommissionRate(aCommissionRate);
		setSalesAmount(aSalesAmount);
	}
	
	public double calcGrossPay()
	{
		return salesAmount * commissionRate;
	}
	
	public double getCommissionRate()
	{
		return commissionRate;
	}
	
	public double getSalesAmount()
	{
		return salesAmount;
	}
	
	public void setCommissionRate(double aCommissionRate)
	{
		commissionRate = aCommissionRate;
	}
	
	public void setSalesAmount(double aSalesAmount)
	{
		salesAmount = aSalesAmount;
	}
	
	public String toString()
	{
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		NumberFormat percentFormat = NumberFormat.getPercentInstance();
		String formattedData = "";
		formattedData = super.toString() +
			"\n" + super.getEmployeeName() + "'s Commission Rate: " + percentFormat.format(getCommissionRate()) +
			"\n" + super.getEmployeeName() + "'s Sales Amount: " + currencyFormat.format(getSalesAmount());
		return formattedData;
	}
}