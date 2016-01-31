public class Oct4
{
    public static void main(String args[])
    {
	// int squares[] = {1, 4, 9, 16, 25};
	
	int squares[] = new int[50];
	
	int i;

	for (i = 0; i<squares.length; i++)
	{
		System.out.println("i = " + i);
		squares[i] = (i + 1) * (i + 1);
		System.out.println("squares[" + i + "] =" + squares[i]);
	}
    }
}
