import java.util.Scanner;

public class StockTransaction
{

	public static void main(String args[])
	{
		int purchased;
		double buy, firstCommission, sell, secondCommission, cost, recieved, profit, finalCost;
		final double COMMISSION;
		
		Scanner keyboard = new Scanner (System.in);
		
		System.out.print("How many shares have you bought? ");
		purchased = keyboard.nextInt();
		buy = 32.87;
		COMMISSION = .02;
		sell = 33.92;
		
		cost = purchased * buy;
		firstCommission = cost * COMMISSION;
		finalCost = cost + firstCommission;
		recieved = purchased * sell;
		secondCommission = recieved * COMMISSION;
		profit = (recieved - secondCommission) - finalCost;
		
		System.out.println("Joe spent $" + cost + " for his shares.");
		System.out.println("He paided $" + firstCommission + " to his broker for buying the stock.");
		System.out.println("He sold the stock for $" + recieved + ".");
		System.out.println("He paid his broker $" + secondCommission + ", for selling the stock.");
		System.out.println("After selling the stock, Joe made $" + profit + ".");
	}
}
