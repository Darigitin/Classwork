import java.util.*;

public class Miles
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		double miles;
		System.out.println("How many miles?");
		miles = keyboard.nextDouble();
		calc(miles);
		
	}
	
	public static void calc(double m)
	{
		double k;
		k = m * 1.61;
		System.out.println(m + " miles is " + k + " kilometers.");
	}
}