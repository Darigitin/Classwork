public class Sept20b
{
    public static void main(String args[])
    {
	final int DOZEN = 12;

	int numStudents = 14;

	int numDonuts = 3 * DOZEN;
	
	int numDonutsPerStudent = numDonuts / numStudents;

	System.out.println("numDonutsPerStudent = " + numDonutsPerStudent);
   	
	int remainderDonuts = numDonuts % numStudents;

	System.out.println("remainderDonuts = " + remainderDonuts);
     }
}
