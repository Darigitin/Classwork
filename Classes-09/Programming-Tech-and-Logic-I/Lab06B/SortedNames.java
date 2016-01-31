import java.util.Scanner;

public class SortedNames
{
	public static void main(String args[])
	{
		String name1, name2, name3, first, second, third;
		
		Scanner console = new Scanner (System.in);
		
		System.out.println("Please enter name 1.");
		name1 = console.nextLine();
		System.out.println("Please enter name 2.");
		name2 = console.nextLine();
		System.out.println("Please enter name 3.");
		name3 = console.nextLine();
		
		if (name1.compareToIgnoreCase(name2) < 0)
		{
			if (name1.compareToIgnoreCase(name3) < 0)
			{
				if (name2.compareToIgnoreCase(name3) < 0)
				{
					System.out.println("First name is: " + name1);
					System.out.println("Second name is: " + name2);
					System.out.println("Third name is: " + name3);
				}
				else
				{
					System.out.println("First name is: " + name1);
					System.out.println("Second name is: " + name3);
					System.out.println("Third name is: " +name2);
				}
			}
			else
			{
				System.out.println("First name is: " + name3);
				System.out.println("Second name is: " + name1);
				System.out.println("Third name is: " + name2);
			}
		}
		else if (name2.compareToIgnoreCase(name3) < 0)
		{
			if (name1.compareToIgnoreCase(name3) < 0)
			{
				System.out.println("First name is: " + name2);
				System.out.println("Second name is: " + name1);
				System.out.println("Third name is: " + name3);
			}
			else
			{
				System.out.println("First name is: " + name2);
				System.out.println("Second name is: " + name3);
				System.out.println("Third name is: " + name1);
			}
		}
		else
		{
			System.out.println("First name is: " + name3);
			System.out.println("Second name is: " + name2);
			System.out.println("Third name is: " + name1);
		}
	}
	
}