import java.util.Scanner;

public class Race
{
	public static void main(String args [])
	{
		String name1, name2, name3;
		double time1, time2, time3;
		
		Scanner console = new Scanner (System.in);
		
		System.out.print("What is the first runner's name? ");
		name1 = console.nextLine();
		System.out.print("What is the second runner's name? ");
		name2 = console.nextLine();
		System.out.print("What is the third runner's name? ");
		name3 = console.nextLine();
		System.out.print("What is the first runner's time? ");
		time1 = console.nextDouble();
		System.out.print("What is the second runner's time? ");
		time2 = console.nextDouble();
		System.out.print("what is the third runner's time? ");
		time3 = console.nextDouble();
					
		if (time1 < time2 && time2 < time3)
		{
			
			System.out.println("First place is: " + name1);
			System.out.println("Second place is: " + name2);
			System.out.println("Third place is: " + name3);
		}	
			else if (time2 < time3 && time3 < time1)
			{
				
				System.out.println("First place is: " + name2);
				System.out.println("Second place is: " + name3);
				System.out.println("Third place is: " + name1);
			}
				else if (time3 < time1 && time1 < time2)
				{
					System.out.println("First place is: " + name3);
					System.out.println("Second place is: " + name1);
					System.out.println("Third place is: " + name2);
				}
					else if (time2 < time1 && time1 < time3)
					{
						System.out.println("First place is: " + name2);
						System.out.println("Second place is: " + name1);
						System.out.println("Third place is: " + name3);
					}
						else if (time3 < time2 && time2 < time1)
						{
							System.out.println("First place is: " + name3);
							System.out.println("Second place is: " + name2);
							System.out.println("Third place is: " +name1);
						}
							else if (time1 < time3 && time3 < time2)
							{
								System.out.println("First place is: " + name1);
								System.out.println("Second place is: " + name3);
								System.out.println("Third place is: " + name2);
							}
								else if (time1 = time2 && time1 > time3)
								{
									System.out.println("First place is: " + name3);
									System.out.println("Second place is: " + name1 + "," + name2);
								}
	}
}