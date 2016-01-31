
import java.util.Scanner;

public class TimeCalculator
{
	public static void main (String args [])
	{
		int time;
		int minute;
		int hour;
		int day;
		int solutionDay;
		int remainderDay;
		int solutionHour;
		int remainderHour;
		int solutionMinute;
		int remainderMinute;
		
		Scanner console = new Scanner(System.in);
		
		System.out.print("How many seconds? ");
		time = console.nextInt();
		minute = 60;
		hour = 3600;
		day = 86400;
		
		if (time >= day)
		{
			solutionDay = time / day;
			remainderDay = time % day;
			solutionHour = remainderDay / hour;
			remainderHour = remainderDay % hour;
			solutionMinute = remainderHour / minute;
			remainderMinute = remainderHour % minute;
			
			System.out.println("There are " + solutionDay + " day(s), " + solutionHour + " hour(s), " + solutionMinute + " minute(s), " + remainderMinute + " second(s) in " + time + " seconds.");
		}
		else if (time >= hour)
			{
				solutionHour = time / hour;
				remainderHour = time % hour;
				solutionMinute = remainderHour / minute;
				remainderMinute = remainderHour % minute;
			
				System.out.println("There are " + solutionHour + " hour(s), " + solutionMinute + " minute(s), " + remainderMinute + " second(s) in " + time + " seconds.");
			}
			else if (time >= minute)
				{
					solutionMinute = time / minute;
					remainderMinute = time % minute;
					
					System.out.println("There are " + solutionMinute + " minute(s), " + remainderMinute + " second(s) in " + time + "seconds.");
				}
				else if (time < minute)
					{
						System.out.println("You must enter a number greater then 60");
					}	
			}
	
}