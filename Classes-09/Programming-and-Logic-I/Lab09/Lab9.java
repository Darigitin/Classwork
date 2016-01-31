import java.io.*;
import java.util.*;

public class Lab9
{
	public static void main(String args[]) throws IOException
	{
		String words, upper;
		
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the first filename: ");
		String filename1 = keyboard.nextLine();
		File file1 = new File(filename1);
		Scanner inputFile = new Scanner(file1);
		System.out.print("Enter the second filename: ");
		String filename2 = keyboard.nextLine();
		PrintWriter outputFile = new PrintWriter(filename2);
		
		
		while (inputFile.hasNext())
		{
			words = inputFile.nextLine();
			upper = words.toUpperCase();
			outputFile.println(upper);
		}
		inputFile.close();
		outputFile.close();
	}
}