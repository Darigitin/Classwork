import java.io.*;
import java.util.*;

public class arrayReview
{
	public static void main(String args[]) throws FileNotFoundException
	{
		int number;
		
		String[] predictions = new String[25];
		loadArray(predictions);
		number = randomNumber();
		System.out.println(predictions[number]);
	}
	public static void loadArray(String[] predictions) throws FileNotFoundException
	{
		Scanner inFile = new Scanner(new File("predictions.txt"));
		
		for(int sub = 0; (inFile.hasNextLine() || sub < predictions.length); sub++)
		{
			predictions[sub] = inFile.nextLine();
		}
	}
	public static Integer randomNumber()
	{
		int number;
		
		Random randomObject = new Random();
		number = 1 + randomObject.nextInt(25);
		return number;
	}	
}