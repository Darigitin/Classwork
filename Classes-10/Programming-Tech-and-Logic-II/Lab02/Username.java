import java.util.*;
import java.io.*;


public class Username
{
	public static void main(String args[]) throws IOException
	{
		String firstName,lastName;
		char firstLetter, menuExit;
		int random;
		
		menuExit = 'y';
		Scanner console = new Scanner (System.in);
		Random randomObject = new Random();
		random = 10 + randomObject.nextInt(90);
		while (menuExit == 'y')
		{
			System.out.println("What is your first name: ");
			firstName = console.nextLine();
			while (firstName.length() == 0)
			{
				System.out.println("There was no entry for your first name, please enter your first name");
				firstName = console.nextLine();
			}
			System.out.println("What is your last name: ");
			lastName = console.nextLine();
			while (lastName.length() == 0)
			{
				System.out.println("There was no entry for your last name, please enter your last name");
				lastName = console.nextLine();
			}
			while (lastName.length() < 5)
			{
				int z = 5 - lastName.length();
				for (int i = 1; i <= z; i++)
				{
					lastName = lastName + 'z';
				}
			}
			firstName = firstName.toLowerCase();
			lastName = lastName.toLowerCase();
			firstLetter = firstName.charAt(0);
			System.out.println(firstLetter + lastName.substring(0,5) + random);
			System.out.println("Do you want to make another username? y/n");
			menuExit = console.nextLine().charAt(0);
		}
	}
}