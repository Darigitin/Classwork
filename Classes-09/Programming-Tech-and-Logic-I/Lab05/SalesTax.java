///Computing Sales Tax

import java.util.Scanner;
public class SalesTax
{
	public static void main(String[] args)
	{
		double purchase;
		double stateTax;
		double countyTax;
		double totalTax;
		double saleTotal;
		
		Scanner console = new Scanner(System.in);
		System.out.println("Enter purchase cost: ");
		purchase = console.nextDouble();
		
		stateTax = purchase * .04;
		countyTax = purchase * .02;
		totalTax = countyTax + stateTax;
		saleTotal = purchase + totalTax;
		
		System.out.println("Purchase: $" + purchase);
		System.out.println("County Tax: $" + countyTax);
		System.out.println("State Tax: $" + stateTax);
		System.out.println("Total Tax: $" + totalTax);
		System.out.println("Sale Total: $" + saleTotal);
	
	}
}
