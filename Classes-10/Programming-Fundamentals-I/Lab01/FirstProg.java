import java.io.*;

public class FirstProg
{
	public static void main(String args[] ) throws IOException
	{

		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));
		String input_string;
		int grade;
		int count;
		int sum;
		double avg;

		count = 0;
		sum = 0;
		
		while (true)
		{
			System.out.println("enter a number (-1 to quit): ");
			input_string = input.readLine();
			grade = Integer.parseInt(input_string);

			if (grade == -1) break;

			count = count + 1;
			sum = sum + grade;
			
			System.out.println("count = " + count);
			System.out.println("sum = " + sum + "\n");
		}
		
		avg = (float) sum / count;
		System.out.println("Average = " + avg);
	}
}
