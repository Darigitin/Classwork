import java.io.*;

//13,0123456789

public class Lab8 
{
    public static void printPixels(boolean pixel[][])
    {
       System.out.println("Converted to 'pixels': =====================");
       for (int i = 0; i < pixel.length; i++)
       {
          for (int j = 0; j < pixel[i].length; j++)
	  {
	     if (pixel[i][j] == true)
	     {
	        System.out.print("X");
	     }
	     else
	     {
	        System.out.print(" ");
	     }
	  }
	  System.out.println("");
       }
    }
    public static void main(String args[]) throws IOException
    {
        InputStreamReader reader = new InputStreamReader(System.in);

        int cten, cone, c2ten, c2one;
        int  n, i, j;

        cten = reader.read() - 48;
        cone = reader.read() - 48;




        int number = 10*cten + cone;

        n = reader.read();  // skip over comma
        if (n != ',')
        {
            System.out.println("data error.  comma expected");
            System.exit(1);
        }
	c2ten = reader.read() - 48;
	c2one = reader.read() - 48;
	

	int number2 = 10*c2ten + c2one;

	int dataArray[][] = new int[number][number2];
	boolean pixelArray[][] = new boolean[number][number2];
	
	n = reader.read();
	if (n != ',')
	{
	   System.out.println("data error. comma expected");
	   System.exit(1);
	}
	System.out.println("Raw data in table format: ===================)");
	for (i = 0; i < number; i++)
	{
	   for (j = 0; j < number2; j++)
	   {
	      n = reader.read() - 48;
	      dataArray[i][j] = n;
              System.out.print(dataArray[i][j]);
              if (n >= 5)
              {
                 pixelArray[i][j] = true;
              }
	   }
           System.out.println("");
	}
        System.out.println("");
	printPixels(pixelArray);

	for (i = 1; i < number-1; i++)
	{
	   for (j = 1; j < number2-1; j++)
	   {
	      int count = 0;
	      for (int i2 = i-1; i2 <= i+1; i2++)
	      {
	         for (int j2 = j-1; j2 <= j+1; j2++)
		 {
		    if (pixelArray[i][j] != pixelArray[i2][j2])
		    {
		       count++;
		    }
		 }
	      }
	      if (count == 8)
	      {
	         pixelArray[i][j] = !pixelArray[i][j];
	      }
	   }
	}
        printPixels(pixelArray);
   }
}
