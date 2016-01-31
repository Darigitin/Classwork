import java.io.*;
import java.util.*;

public class Grades
{
	public static void main(String args[]) throws FileNotFoundException
	{
		int[] studId = new int[15];
		String[] studName = new String[15];
		int[] numGrade = new int[15];
		String[] letterGrade = new String[15];
		
		loadArray(studId, studName, numGrade);
		calcLetterGrade(numGrade, letterGrade);
		menu(studId, studName, numGrade, letterGrade);
		
	}
	public static void loadArray(int[] studId, String[] studName, int[] numGrade) throws FileNotFoundException
	{
		
		Scanner inFile = new Scanner(new File("Grades.txt"));
		
		for(int sub = 0; (inFile.hasNextLine() || sub < studId.length); sub++)
		{
			studId[sub] = inFile.nextInt();
			studName[sub] = inFile.next();
			numGrade[sub] = inFile.nextInt();
		}
		inFile.close();
	}
	public static void calcLetterGrade(int[] numGrade, String[] letterGrade)
	{
		for (int sub = 0; sub < numGrade.length; sub++)
		{
			if (numGrade[sub] <= 59)
			{
				letterGrade[sub] = "F";
			}
			else if (numGrade[sub] < 70)
			{
				letterGrade[sub] = "D";
			}
			else if (numGrade[sub] < 80)
			{
				letterGrade[sub] = "C";
			}
			else if (numGrade[sub] < 90)
			{
				letterGrade[sub] = "B";
			}
			else
			{
				letterGrade[sub] = "A";
			}
		}
	}
	public static void menu(int[] studId, String[] studName, int[] numGrade, String[] letterGrade)
	{
		char correct = 'N';
		String answer1 = "ID";
		String answer2 = "letter grade";
		String answer;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Do you want to search via ID or letter grade?");
	 	answer = keyboard.nextLine();
		
		while (correct == 'N')
		{
			if (answer.equalsIgnoreCase(answer1))
			{
				idSearch(studId, studName, numGrade, letterGrade);
				correct = 'Y';
			}
			else if (answer.equalsIgnoreCase(answer2))
			{
				letterGradeSearch(studId, studName, numGrade, letterGrade);
				correct = 'Y';
			}
			else
			{
				System.out.println("That option is not available, please enter either ID or letter grade.");
				answer = keyboard.nextLine();
			}
		}	
	}
	public static void idSearch(int[] studId, String[] studName, int[]numGrade, String[] letterGrade)
	{
		char found = 'N';
		int searchId;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter an ID");
		searchId = keyboard.nextInt();
	
		while (found == 'N')
		{
			for (int sub = 0; sub < studId.length; sub++)
			{
				if (searchId == studId[sub])
				{
					System.out.println(studId[sub] + " " + studName[sub] + " " + numGrade[sub] + " " + letterGrade[sub]);
					found = 'Y';
				}
			}
			if (found == 'N')
			{
				System.out.println("That ID is invalid, please enter a valid ID.");
				searchId = keyboard.nextInt();
			}
		}
	}
	public static void letterGradeSearch(int[] studId, String[] studName, int[] numGrade, String[] letterGrade)
	{
		char found = 'N';
		String searchLetter;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter the letter grade you wish to search for.");
		searchLetter = keyboard.nextLine();
		searchLetter = letterTest(searchLetter);
		while (found == 'N')
		{
			for (int sub = 0; sub < letterGrade.length; sub++)
			{
				if (searchLetter.equalsIgnoreCase(letterGrade[sub]))
				{
					System.out.println(studId[sub] + " " + studName[sub] + " " + numGrade[sub] + " " + letterGrade[sub]);
					found = 'Y';
				}
			}
			if (found == 'N')
			{
				System.out.println("No student made that grade.");
				found = 'Y';
			}
		}
	}
	public static String letterTest(String searchLetter)
	{
		String[] answers = {"A","B","C","D","F"};
		Scanner keyboard = new Scanner(System.in);
		char flag = 'N';
		
		while (flag == 'N')
		{
			for (int sub = 0; sub < answers.length; sub++)
			{
				if (searchLetter.equalsIgnoreCase(answers[sub]))
				{	
					flag = 'Y';
				}
			}
			if (flag == 'N')
			{
				System.out.println("That letter grade is incorrect, please enter a valid letter grade.");
				searchLetter = keyboard.nextLine();
			}
		}
		return searchLetter;
	}
}
