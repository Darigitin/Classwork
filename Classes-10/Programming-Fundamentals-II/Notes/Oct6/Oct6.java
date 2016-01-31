public class Oct6
{
    public static void main(String args[])
    {	
	int i = 0;
	int ar[] = {2, 7, 6, 4, 3, 9};
	int lt5[] = new int[ar.length];
	
	for (i = 0; i < ar.length; i++)
	{
		if (ar[i] < 5)
		{
			lt5[i] = ar[i];
		//	System.out.println(lt5[i]);
		}
		System.out.println("lt5[" + i + "] = " + lt5[i]);
	}
	
	System.out.println();
	
	for (i = 0; i < ar.length; i++)
	{
		System.out.println("ar[" + i + "] = " + ar[i]);
	}
	
    }
}
