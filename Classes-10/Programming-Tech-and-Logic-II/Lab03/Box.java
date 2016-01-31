import java.util.*;

public class Box
{
	static Scanner console = new Scanner (System.in);
	
	public static void main(String args[])
	{
			int length;
			int width;
			length = getInput("Please enter the length.");
			width = getInput("Please enter the width.");
			displayBox(length,width);
			
	}
		
	public static void displayBox(int width,int length)
	{
			for (int i = 0; i < length; i++)
			{ 
				for (int j = 0; j < width; j++)
				{
					System.out.print("*");
				}
				System.out.println();
			}
	}
		
	public static int getInput(String prompt)
	{
			System.out.print(prompt + ' ');
			return console.nextInt();
	}

}
