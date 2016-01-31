// find all primes < 1M using BRUTE FORCE, checking
// ALL whole numbers less than square root as possible
// factors of 'n'

public class Main1
{

    public static boolean isPrime(int n)
    {
        for (int i=2; i<n; i++) {
            if ((n%i) == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[])
    {
        int c=0;
        long start, end, mstime;

        final int LIMIT=100000;  // 1M took ~800 secs.

        start = System.currentTimeMillis();

        for (int i=2; i<LIMIT; i++) {

            if (isPrime(i)) {
                System.out.println(i);
                c++;
            }
        }

        end = System.currentTimeMillis();

        mstime = end - start;

        System.out.println("#primes = " + c + ", mstime = " + mstime);
    }
}
