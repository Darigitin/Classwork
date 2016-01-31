// find all primes < 1M using BRUTE FORCE, checking
// ALL whole numbers less than square root as possible
// factors of 'n'

public class Lab1
{
    public static int[] primeArray;
    public static int numprime;

    public static boolean isPrime(int n)
    {
       int root = (int) Math.sqrt(n);


        for (int i=0; primeArray[i]<=root; i++) 
	{
	   if ((n%primeArray[i]) == 0) 
	   {
              return false;
           }
        }
	primeArray[numprime] = n;
	numprime++;
        return true;
    }

    public static void main(String args[])
    {
        int c=0;
        long start, end, mstime;

        final int LIMIT=1000000;

        start = System.currentTimeMillis();

	primeArray = new int[100000];
	primeArray[0] = 2;
	numprime = 0;
        for (int i=2; i<LIMIT; i++) 
	{

            if (isPrime(i)) 
	    {
                System.out.println(i);
                c++;
            }
        }

        end = System.currentTimeMillis();

        mstime = end - start;

        System.out.println("#primes = " + c + ", mstime = " + mstime);
    }
}
