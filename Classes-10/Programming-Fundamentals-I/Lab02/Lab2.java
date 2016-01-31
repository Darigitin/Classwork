import java.io.*;
public class Lab2
{
	public static void main(String args[]) throws IOException
	{
		BufferedReader input = new BufferedReader (new InputStreamReader (System.in));

		String input_string;
		int r;
		int num1;
		int num2;
		int indic;
		final double PI = 3.14;
		double result;

		while(true)
		{
			System.out.println("Max of two number calculations. Enter a 1 for addition, a 2 for subtraction, a 3 for division, a 4 for multiplication, and a 5 to find the area of a circle. Enter a -1 to end.");
			input_string = input.readLine();
			indic = Integer.parseInt(input_string);
			
			if (indic == -1) break;
			
			if (indic == 1)
			{
				System.out.println("Enter your first number for addition.");
				input_string = input.readLine();
				num1 = Integer.parseInt(input_string);
				System.out.println("Enter your second number for addition.");
				input_string = input.readLine();
				num2 = Integer.parseInt(input_string);
				result = num1 + num2;
				System.out.println("The sum of " + num1 + " and " + num2 + " is " + result);
			}
			if (indic == 2)
			{	
				System.out.println("Enter your first number for subtraction.");
				input_string = input.readLine();
				num1 = Integer.parseInt(input_string);
				System.out.println("Enter your second number for subtraction.");
				input_string = input.readLine();
				num2 = Integer.parseInt(input_string);
				result = num1 - num2;
				System.out.println("The difference of " + num1 + " and " + num2 + " is " + result);
			}
			if (indic == 3)
			{
				System.out.println("Enter your first number for division.");
				input_string = input.readLine();
				num1 = Integer.parseInt(input_string);
				System.out.println("Enter your second number for division.");
				input_string = input.readLine();
				num2 = Integer.parseInt(input_string);
				result = (double) num1 / num2;
				System.out.println("The quotient of " + num1 + " and " + num2 + " is " + result);
			}
			if (indic == 4)
			{
				System.out.println("Enter your first number for multiplication.");
				input_string = input.readLine();
				num1 = Integer.parseInt(input_string);
				System.out.println("Enter your second number for multiplication.");
				input_string = input.readLine();
				num2 = Integer.parseInt(input_string);
				result = num1 * num2;
				System.out.println("The product of " + num1 + " and " + num2 + " is " + result);
			}
			if (indic == 5)
			{
				System.out.println("Enter the radius of the circle.");
				input_string = input.readLine();
				r = Integer.parseInt(input_string);
				result = r * r * PI;
				System.out.println("The area of the cirlce is " + result);
			}
		}
	}
}
