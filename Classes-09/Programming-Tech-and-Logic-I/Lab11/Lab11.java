import java.util.*;

public class Lab11
{
	public static void main(String args[])
	{
		double test1, test2, test3, test4, test5, avg;
		int count = 1;
		String grade1, grade2, grade3, grade4, grade5;
		
		test1 = getGrade(count);
		count++;
		test2 = getGrade(count);
		count++;
		test3 = getGrade(count);
		count++;
		test4 = getGrade(count);
		count++;
		test5 = getGrade(count);
		
		avg = calcAverage(test1, test2, test3, test4, test5);
		
		grade1 = determineGrade(test1);
		grade2 = determineGrade(test2);
		grade3 = determineGrade(test3);
		grade4 = determineGrade(test4);
		grade5 = determineGrade(test5);
		
		System.out.println("For test number 1 you recieved a " + grade1);
		System.out.println("For test number 2 you recieved a " + grade2);
		System.out.println("For test number 3 you recieved a " + grade3);
		System.out.println("For test number 4 you recieved a " + grade4);
		System.out.println("For test number 5 you recieved a " + grade5);
		System.out.println("Your avergage test score was " + avg);
		
	}
	public static double getGrade(int counter)
	{
		double test;
		Scanner keyboard = new Scanner(System.in);
		
		if (counter == 1)
		{
			System.out.println("Please enter your first test score.");
		}
		else if (counter == 2)
		{
			System.out.println("Please enter your second test score.");
		}
		else if (counter == 3)
		{
			System.out.println("Please enter your third test score.");
		}
		else if (counter == 4)
		{
			System.out.println("Please enter your fourth test score.");
		}
		else if (counter == 5)
		{
			System.out.println("Please enter your fifth test score.");
		}
		test = keyboard.nextDouble();
		return test;
	}
	public static double calcAverage(double t1, double t2, double t3, double t4, double t5)
	{
		double average;
		average = (t1 + t2 + t3 +t4 + t5) / 5;
		return average;
	}
	public static String determineGrade(double test)
	{
		String letterGrade = "No grade";
		if (test < 60)
		{
			letterGrade = "F";
		}
		else if (test < 70)
		{
			letterGrade = "D";
		}
		else if (test < 80)
		{
			letterGrade = "C";
		}
		else if (test < 90)
		{
			letterGrade = "B";
		}
		else
		{
			letterGrade = "A";
		}
		return letterGrade;
	}
}