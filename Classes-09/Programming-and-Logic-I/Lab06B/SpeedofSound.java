import java.util.Scanner;

public class SpeedofSound
{
	public static void main(String arg[])
	{
		double time, distance;
		char character;
		String medium;
		
		Scanner console = new Scanner (System.in);
		
		System.out.print("Please enter the distance.");
		distance = console.nextDouble();
		
		System.out.print("Please enter either air, water, or steel.");
		medium = console.nextLine();	
		character = medium.charAt(0);
		
			
		switch (character)
		{
			case 'a':
				time = distance / 1100;
				System.out.println("Sound will travel through " + distance + " feet of air in " + time + " seconds.");
				break;
			case 'w':
				time = distance / 4900;
				System.out.println("Sound will travel through " + distance + " feet of water in " + time + " seconds.");
				break;
			case 's':
				time = distance / 16400;
				System.out.println("Sound will travel through " + distance + " feet of steel in " + time + " seconds.");
				break;
			default:
				System.out.println("You need to enter either air, water, or steel.");
		}
	}
}