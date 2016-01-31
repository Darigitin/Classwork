import java.io.*;
public class Lab3
{
    public static void main(String argv[]) throws IOException
    {
        BigInteger b1,b2,b3;

        b1 = new BigInteger();
        b2 = new BigInteger();

        System.out.println("input the first BigInteger:");
        b1.inputBigInteger();
        System.out.println("input the second BigInteger:");
        b2.inputBigInteger();

        System.out.print("BigInt #1:  ");
        b1.printBigInteger();
        System.out.print("BigInt #2:  ");
	b2.printBigInteger();
        System.out.println("            =========================");
        b3 = b1.add(b2);
        System.out.print("SUM:        ");
	b3.printBigInteger();
        System.out.println();

        System.out.print("BigInt #1:  ");
	b1.printBigInteger();
        System.out.print("BigInt #2:  ");
	b2.printBigInteger();
        System.out.println("            =========================");
        b3 = b1.subtract(b2);
        System.out.print("DIFFERENCE: ");
	b3.printBigInteger();
        System.out.println();

        System.out.print("BigInt #1:  ");
	b1.printBigInteger();
        System.out.print("BigInt #2:  ");
	b2.printBigInteger();
        System.out.println("            =========================");
        b3 = b1.multiply(b2);
        System.out.print("PRODUCT:    ");
	b3.printBigInteger();
        System.out.println();
    }
}

