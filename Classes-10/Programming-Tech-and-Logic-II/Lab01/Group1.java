import java.util.*;

public class Group1
{
	private static Scanner keyboard = new Scanner(System.in);
	
	public static void main(String args[])
	{
		int input, year;
		
		
		
		System.out.println("How many years are you wanting to test?");
		input = keyboard.nextInt();
		System.out.println("Valid years are greater than or equal to 1582");
		
		int[] years = new int[input];
		
		for (int sub = 0; sub < years.length; sub++)
		{
			System.out.println("Please enter year number " + (sub + 1) + ":");
			years[sub] = keyboard.nextInt();
		}
		validtest(years);
		calcyear(years);
			
	}
	public static void validtest(int[] years)
	{
		int sub;
		char flag = 'n';
		for (sub = 0; sub < years.length; sub++)
		{
			while (flag == 'n')
			{
				if (years[sub] < 1582)
				{
					System.out.println("Number " + (sub + 1) + " is not a valid year. Please enter a valid year.");
					years[sub] = keyboard.nextInt();
				}
				else
				{
					flag = 'y';
				}
			}
			flag = 'n';
		}
	}
	public static void calcyear(int[] years)
	{
		int remainder, sub;
	
		for (sub = 0; sub < years.length; sub++)
		{
			remainder = years[sub] % 100;
		 	if (remainder == 0)
		 	{
		 	 	remainder = years[sub] % 400;
		 	 	if (remainder == 0)
		 	 	{
		 	 		System.out.println(years[sub] + " is a leap year!");
		 	 	}
		 	 	else
		 	 	{
		 	 		System.out.println(years[sub] + " is not a leap year.");
		 	 	}
		 	}
		 	else
		 	{
		 		remainder = years[sub] % 4;
		 		if (remainder == 0)
		 		{
		 			System.out.println(years[sub] + " is a leap year!");
		 		}
		 		else
		 		{
		 			System.out.println(years[sub] + " is not a leap year.");
		 		}
		 	}
		}
	}
}
		
