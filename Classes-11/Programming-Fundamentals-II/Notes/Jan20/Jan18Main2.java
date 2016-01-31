// find all primes < 1M using BRUTE FORCE, checking
// ALL whole numbers less than square root as possible
// factors of 'n'

public class Jan18Main2
{
    public static int[] primeArray;

    public static boolean isPrime(int n)
    {
        int root;

        root = (int) Math.sqrt(n);
        for (int i=2; i<=root; i++) 
	{
	   if ((n%primeArray[i-2]) == 0) 
	   {
              return false;
           }
        }
        return true;
    }

    public static void main(String args[])
    {
        int c=0;
        long start, end, mstime;
	primeArray = new int[100000];
	primeArray[0] = 1;

        final int LIMIT=1000000;

        start = System.currentTimeMillis();

        for (int i=2; i<LIMIT; i++) 
	{

            if (isPrime(i)) 
	    {
                System.out.println(i);
		primeArray[c] = i;
                c++;
            }
        }

        end = System.currentTimeMillis();

        mstime = end - start;

        System.out.println("#primes = " + c + ", mstime = " + mstime);
    }
}
