public class Lab3
{
	public static void main(String args[])
	{
		int i, j, h;
		double a, b;
		boolean tonsils = false;
		String fname = "Matt";
		String lname = "Vertefeuille";
		int myArray[] = new int[10];
		int myOtherArray[] = {4, 7, 5, 2, 9};
		a = 20.0;
		b = 7.0;
		i = 20;
		j = 7;
		h = 5 * 12 + 6;
		myArray[0] = 4;
		myArray[1] = 7;
		myArray[2] = 5;
		myArray[3] = 2;
		myArray[4] = 9;
		System.out.println("The sum of a and b is " + (a + b));
		System.out.println("The difference of a and b is " + (a - b));
		System.out.println("The product of a and b is " + (a * b));
		System.out.println("The quotient of a and b is " + (a / b));
		System.out.println("The sum of i and j is " + (i + j));
		System.out.println("The difference of i and j is " + (i - j));
		System.out.println("The product of i and j is " + (i * j));
		System.out.println("The quotient of i and j is " + (i / j));
		System.out.println("The remainder of i and j is " + (i % j));
		System.out.println("Have I had my tonsils removed: " + tonsils);
		System.out.println("Hello, my name is " + fname + " " + lname + ".");
		System.out.println(lname + ", " + fname + " is my name.");
		System.out.println("The BMI of a person who is 5'6 and 140lbs is " + ((140.0 * 703) / (h * h)));
	}
}
