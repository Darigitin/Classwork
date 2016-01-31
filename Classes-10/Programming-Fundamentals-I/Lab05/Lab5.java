import java.io.*;
public class Lab5
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader input = new BufferedReader ( new InputStreamReader (System.in));

		int guess;
		int  secretValue = (int) (10 * Math.random()) + 1;
		int guesses[] = new int[5];
		String input_string;
		int i = 0;

		while (i < 5)
		{
			System.out.println("enter a number between 1 and 10:");
			input_string = input.readLine();
			guess = Integer.parseInt(input_string);
			
			if (guess > secretValue)
			{
				System.out.println("Your guess of " + guess + " is too high.");
				guesses[i] = guess;
			}
			else if (guess < secretValue)
			{
				System.out.println("Your guess of " + guess + " is too low.");
				guesses[i] = guess;
			}
			else if (guess == secretValue)
			{
				System.out.println("Your guess of " + guess + " is CORRECT!");
				guesses[i] = guess;
				break;
			}
			i++;
		}
		if (i == 5)
		{
			System.out.println("Better luck next time!");
		}
		if (i == 0)
		{
			System.out.println("Your guesse(s) were: " + guesses[0]);
		}
		else if (i == 1)
		{
			System.out.println("Your guesse(s) were: " + guesses[0] + " " + guesses[1]);
		}
		else if (i == 2)
		{
			System.out.println("Your guesse(s) were: " + guesses[0] + " " + guesses[1] + " " + guesses[2]);
		}
		else if (i == 3)
		{
			System.out.println("Your guesse(s) were: " + guesses[0] + " " + guesses[1] + " " + guesses[2] + " " + guesses[3]);
		}
		else if (i == 4)
		{
			System.out.println("Your guesse(s) were: " + guesses[0] + " " + guesses[1] + " " + guesses[2] + " " + guesses[3] + " " + guesses[4]);
		}
		else
		{
			System.out.println("Your guesse(s) were: " + guesses[0] + " " + guesses[1] + " " + guesses[2] + " " + guesses[3] + " " + guesses[4]);
		}
	}
}	
