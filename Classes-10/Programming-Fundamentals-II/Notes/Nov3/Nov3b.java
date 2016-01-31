public class Nov3b
{
	public static int sum(int a, int b)
	{
		return (a + b);
	}
	public static double sum(double a, double b)
	{
		return (a + b);
	}
	public static int sum(int a, int b, int c)
	{
		return (a + b + c);
	}
	public static void main(String args[]
	{
		int isum = sum(1, 2);
		System.out.println("isum = " + isum);

		double dsum = sum(1.0, 2.0)
		System.out.println("dsum = " + dsum);

		isum = sum(1, 2, 3);
		System.out.println("isum = " + isum);
	}
}
