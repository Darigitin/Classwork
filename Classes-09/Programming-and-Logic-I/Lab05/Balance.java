///Balance of a savings account

import java.util.Scanner;

public class Balance
{
	public static void main(String args [])
	{
		double startingBalance, totalDeposits, totalWithdrawals, interestRate, monthlyBalance, monthlyInterest, newBalance;
		
		Scanner console = new Scanner(System.in);
		
		System.out.print("What is your starting balance?");
		startingBalance = console.nextDouble();
		
		System.out.print("What is the total amount of your deposits?");
		totalDeposits = console.nextDouble();
		
		System.out.print("What is the total amount of your withdrawals?");
		totalWithdrawals = console.nextDouble();
		
		System.out.print("What is the monthly interest rate?");
		interestRate = console.nextDouble();
		
		monthlyBalance = startingBalance + totalDeposits - totalWithdrawals;
		monthlyInterest = monthlyBalance * interestRate;
		newBalance = monthlyBalance + monthlyInterest;
		
		System.out.println("Your monthly balance is $" + newBalance);
		
	}
}
