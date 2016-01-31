public class Sept22b
{
    public static void main(String args[])
    {
	int myArray[];

	myArray = new int[10];

	myArray[0] = 5;

	int i = 3;
	myArray[i] = 8;

	myArray[i+4] = 9;

	int j = myArray[i+4] - myArray[i];

	System.out.println("the answer is: " + myArray[j-1]);	
    }
}
