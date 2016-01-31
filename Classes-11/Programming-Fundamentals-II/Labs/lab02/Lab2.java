public class Lab2
{
   public static boolean[] numArray;
   public static void main(String args[])
   {
      long start, end, mstime;
      
      start = System.currentTimeMillis();
      numArray = new boolean[1000000];
      int root = (int) Math.sqrt(numArray.length);
      for (int i = 2; i < root; i++)
      {
         if(numArray[i] == false)
	 {

            for (int j = i+i; j < numArray.length; j = j+i)
	    {
	       if (numArray[j] == false)
	       {
	          numArray[j] = true;
	       }
	    }
	 }
      }
      int c = 0;
      for (int i = 2; i < numArray.length; i++)
      {
         if (numArray[i] == false)
	 {
	    System.out.println(i);
	    c++;
	 }
      }

      end = System.currentTimeMillis();
      mstime = end - start;
      System.out.println("#primes = " + c + " mstime = " + mstime);
   }
}
