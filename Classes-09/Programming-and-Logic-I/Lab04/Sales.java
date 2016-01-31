// East Cost annual sale income

public class Sales
{
	public static void main(String[]args)
	{
		double companyPercent = 0.62;
		double companySales = 4600000;
		double divisionSales;
		
		divisionSales = companySales * companyPercent;
		
		System.out.println("East Coast Division generated $" + divisionSales + " this year");
	}
}
