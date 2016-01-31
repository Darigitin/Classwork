public class Oct25
{
	public static void printBiggest(int a, int b)
	{
		// int a, b:
		System.out.println("printBiggest: a = " + a);
		System.out.println("printBiggest: b = " + b);

		if (a > b)
		{
			System.out.println("printBiggest: " + a + " is Biggest!");
		}
		else if (b > a)
		{
			System.out.println("printBiggest: " + b + " is Biggest!");
		}
		else // if (a == b)
		{
			System.out.println("pringBiggest:  doh! they are equal!");
		}
	}
	public static int findBiggest(int a, int b)
	{
		int rc = -1;
		
		if (a > b)
		{
			rc = a;
		}
		else if (b > a)
		{
			rc = b;
		}
		
		return rc;
	}
	public static void main(String args[])
	{
		int biggest;
	
		printBiggest(6, 3);		

		printBiggest(2, 9);

		printBiggest(5, 5);

		biggest = findBiggest(6, 3);
		System.out.println("biggest = " + biggest);

		biggest = findBiggest(1, 4);
		System.out.println("biggest = " + biggest);

		biggest = findBiggest(8, 8);
		System.out.println("biggest = " + biggest);

	}
}
