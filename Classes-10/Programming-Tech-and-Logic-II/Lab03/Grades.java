import java.util.*;

public class Grades
{
	static Scanner console = new Scanner(System.in);
	
	public static void main(String args[])
	{
		int numberOfGrades;
		double classAverage;
		
		numberOfGrades = getInput("Please enter the number of grades.");
		classAverage = calcAverage(numberOfGrades);
		
		System.out.println("The class average is " + classAverage);
	}
	public static double calcAverage(int number)
	{
		double total = 0.0;
		for (int x = 0; x < number; x++)
		{
			total += getInput("Please enter a grade.");
		}
		return total / number;
	}
	public static int getInput(String prompt)
	{
		System.out.print(prompt + ' ');
		return console.nextInt();
	}
}