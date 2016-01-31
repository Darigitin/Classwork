public class Sept29d
{
    public static void main(String args[] )
    {
        int i=4;   // initializer

        if(i > 0)
        {
            System.out.println("if statement: i = " + i);
        }

        while(i > 0)   // LEC (loop entry condition)
        {
            System.out.println("while loop:  i = " + i);

            i=i-1;     // updater
        }

        System.out.println("after while loop:  i = " + i);
        System.out.println();

        // write a for loop that does the same thing as the above while loop:
        // put your code here:




        System.out.println();

        i=1;   // initializer

        while(i <= 10)   // LEC
        {
            System.out.println("while loop:  i = " + i);

            i=i+1;       // updater
        }

        System.out.println();
         // init;  LEC ; updater
        for (i=1; i<=10; i=i+1)
        {
            System.out.println("for loop:  i = " + i);
        }
	
	System.out.println();

	for (i = 4; i > 0; i--)
	{
		System.out.println("for statement i = " + i);
	}
    }
}
