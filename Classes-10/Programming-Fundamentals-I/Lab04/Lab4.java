public class Lab4
{
	public static void main(String args[])
	{
		
		int numbers[] = {11, 8, -7, 22, 3, 17, 6, -25, 10, 5, -12, -9, 14, 20, -13};
		int evens[] = new int[numbers.length];
		int indexLargestNum = 0;
		int largestNum = numbers[0];
		int sum = 0;
		int i = 0;
		int count = 0;
		int countEvens = 0;
		for (i = 1; i <= 10; i++)
		{
			System.out.println("counting up from 1 in a for loop " + i);
		}
		
		System.out.println();
	
		for (i = 10; i > 0; i--)
		{
			System.out.println("counting down from 10 in a for loop " + i + "!");
		}
		System.out.println("Blastoff!!!");
		
		System.out.println();
	
		for (count = 0; numbers.length > count; count++)
		{
			System.out.println("numbers array index number " + count + " is " + numbers[count]);
		}

		System.out.println();

		for (i = 1; i <= 10; i++)
		{
			i++;
			System.out.println("for loop counting by twos; " + i);
		}

		System.out.println();

		for (i = 0; numbers.length > i; i++)
		{
			if ((i % 2) == 0)
			{
 				System.out.println("numbers array index " + i + " is " + numbers[i]);
			}
		}
		
		System.out.println();

		for (count = 0; numbers.length > count; count++)
		{
			if ((numbers[count] % 2) == 0)
			{
				evens[countEvens] = numbers[count];
				countEvens++;
			}
		}
		
		for (i = 0; i < countEvens; i++)
		{
			System.out.println("evens[" + i + "] = " + evens[i]);
		}
	
		System.out.println();

		for (i = 0; numbers.length > i; i++)
		{
			sum = numbers[i] + sum;
		}
		System.out.println("The sum of all the numbers in the numbers array is " + sum);
		
		System.out.println();
		
		for (i = 1; numbers.length > i; i++)
		{
			if (largestNum < numbers[i])
			{
				largestNum = numbers[i];
				indexLargestNum = i;
			}
		}
		System.out.println("The largest number in the numbers array is " + largestNum + ". " + "The index of the largest number is " + indexLargestNum + ".");

		System.out.println();
		
		for (i = 0; numbers.length > i; i++)
		{
			if (numbers[i] < -15)
			{
				System.out.println(numbers[i] + " is less then -15.");
			}
			else if ((numbers[i] >= -15) && (numbers[i] <= 15))
			{
				System.out.println(numbers[i] + " is between -15 and 15.");
			}
			else if (numbers[i] > 15)
			{
				System.out.println(numbers[i] + " is greater then 15.");
			}
		}
		i = 50;

		System.out.println();

		while (i > 25)
		{
			System.out.println("i = " + i);
			i-=5;
		}
	}
}
