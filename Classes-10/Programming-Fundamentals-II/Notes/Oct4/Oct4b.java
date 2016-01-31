public class Oct4b
{
    public static void main(String args[])
    {
	int ar[] = (3, 7, 9, 2, 5, 1);

	int i;
	
	System.out.println("display all elements of the array:");
	for (i=0; i<ar.length; i++)
	{
		System.out.println("ar[" + i + "] = " + ar[i]);
	}
	
	System.out.println("display EVEN elements of the array:");
	for (i=0; i<ar.length; i++)
	{
		if ((ar[i] % 2) == 0)
		{
			System.out.println("ar[" + i + "] = " + ar[i]);
		}
	}
	System.out.println();	
	
	System.out.println("display elements of the array at EVEN INDEXS:");
	for (i=0; i<ar.length; i+=2)
	{
		System.out.println("ar[" + i + "] = " + ar[i]);
	}
	System.out.println();
	
	System.out.println("display elements of the array at EVEN INDEXES");
	for (

	
    }
}
