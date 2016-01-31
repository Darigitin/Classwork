import java.util.*;

public class SumofNumbers
{
	public static void main(String args[])
	{
		int number = 1, usernumber, sum = 0;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Please enter a nonzero integer number: ");
		usernumber = keyboard.nextInt();
		
		while (usernumber < 0)
		{
			System.out.println("That is not a valid number");
			System.out.println("Please enter a nonzero integer number: ");
			usernumber = keyboard.nextInt();
		}
		while (number < usernumber)
		{
			System.out.println(sum);
			sum = number + sum;
			number ++;
		}
		System.out.println("The sum of all the integers from 1 to " + usernumber + " is " + sum + ".");
	}
}