import java.util.*;

public class UpperName
{
	public static void main(String args[])
	{
		String name;
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What is your name?");
		name = keyboard.nextLine();
		convert(name);
	}
	public static void convert(String n)
	{
		String N;
		N = n.toUpperCase();
		System.out.println("Your name in uppercase is " + N);
	}
}