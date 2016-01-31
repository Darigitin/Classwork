import java.util.*;

public class Lab8
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		int length, width, x, y;
		System.out.println("Enter length: ");
		length = keyboard.nextInt();
		System.out.println("Using a while loop");
		
		x = 1;
		width = 1;
		
		while (x <= length)
		{
			y = 1;
			while(y <= width)
			{
				System.out.print("*");
				y++;
			}
			System.out.println();
			width++;
			x++;
		}
		System.out.println("Using a for loops");
		width = 1;
		for (x = 1; x <= length; x++)
		{
			for (y = 1; y <= width; y++)
			{
				System.out.print("*");
			}
			width++;
			System.out.println();
		}
		width = 0;
		System.out.println("Using a do loop");
		
		x = 1;
		do 
		{
			width++;
			y = 1;
			do
			{
				System.out.print("*");
				y++;
			}
				while ( y <= width);
				System.out.println();
				x++;
		}
			while (x <= length);
	}
}