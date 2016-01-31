public class Lab6
{
	public static void main(String args[])
	{
		int ar[] = new int[10];
		for (int i = 0; i < 100; i++)
		{
			int number = (int) (10 * Math.random());
			ar[number]++;
			System.out.println(number);
		}
		for (int i = 0; i < ar.length; i++)
		{
			System.out.println("There were " + ar[i] + " " + i + "'s generated");
		}
	}
}
			
