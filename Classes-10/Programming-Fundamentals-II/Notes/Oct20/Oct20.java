public class Oct20
{   
    public static int greeting(int n)
    {
	for (int i = 0; i < n; i++)
	{
		System.out.println("hello world from Oct20 Java Program!");
	}
    }
    public static void main(String args[])
    {
	System.out.println("calling greeting 1 time...");
	gretting(1);
	
	System.out.println("calling greeting 3 times...");
	greeting(3);
	
	int i = 4;
	System.out.println("calling greeting i times...");
	greeting(i);

	System.out.println("calling greeting 2*1 times...");
	greeting(2*1);
    }
}
