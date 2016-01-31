import java.io.*;
import java.util.*;
import java.util.Random;

public class Game
{
	public static void main(String args[]) throws IOException
	{
		int guesses, number, answer;
		String name;
		
		Scanner keyboard = new Scanner(System.in);
		Random randomObject = new Random();
		number = 1 + randomObject.nextInt(100);
		PrintWriter outputFile = new PrintWriter("Score.txt");
		
		System.out.println("Please enter your name: ");
		name = keyboard.nextLine();
		
		System.out.println("Please enter your guess: ");
		answer = keyboard.nextInt();
		
		guesses = 1;
		
		while (guesses < 4)
		{
			
			if (answer == number)
			{
				System.out.println("You guessed the number correctly in " + guesses + " try(s). You are an Expert.");
				outputFile.println(name + " took " + guesses + " try(s) to guess the number");
				break;
			}
			else if (answer < number)
			{
				System.out.println("Too low, try again");
				guesses++;
				System.out.println("Please enter your next guess: ");
				answer = keyboard.nextInt();
			}
			else if (answer > number)
			{
				System.out.println("Too high, try again");
				guesses++;
				System.out.println("Please enter your next guess: ");
				answer = keyboard.nextInt();
			}
		}
		while (guesses <= 6 && guesses >= 4)
		{
			if (answer == number)
			{
				System.out.println("You guessed the number correctly in " + guesses + " try(s). You are Above Average.");
				outputFile.println(name + " took " + guesses + " try(s) to guess the number");
				break;
			}
			else if (answer < number)
			{
				System.out.println("Too low, try again");
				guesses++;
				System.out.println("Please enter your next guess: ");
				answer = keyboard.nextInt();
			}
			else if (answer > number)
			{
				System.out.println("Too high, try again");
				guesses++;
				System.out.println("Please enter your next guess: ");
				answer = keyboard.nextInt();
			}
		}
		while (guesses <= 9 && guesses >= 7)
		{
			if (answer == number)
			{
				System.out.println("You guessed the number correctly in " + guesses + " trys(s). You are Below Average.");
				outputFile.println(name + " took " + guesses + " try(s) to guess the number");
				break;
			}
			else if (answer < number)
			{
				System.out.println("Too low, try again");
				guesses++;
				System.out.println("Please enter your next guess: ");
				answer = keyboard.nextInt();
			}
			else if (answer > number)
			{
				System.out.println("Too high, try again");
				guesses++;
				System.out.println("Please enter your next guess: ");
				answer = keyboard.nextInt();
			}
		}
		if (guesses >= 10)
		{
			System.out.println("You have run out of guesses. You are the LOSER!");
			outputFile.println(name + " tried " + guesses + " times and failed to guess the number!");
		}
		outputFile.close();
	}
}