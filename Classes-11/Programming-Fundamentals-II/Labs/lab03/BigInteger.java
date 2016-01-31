import java.io.*;
class BigInteger
{
   private final int INTSIZ = 25;
   private int intArray[] = new int[INTSIZ];

   public void printBigInteger()
   {
      for (int i = 0; i < INTSIZ; i++)
      {
         System.out.print(intArray[i]);
      }
      System.out.println();

}
   
   public void inputBigInteger() throws IOException
   {
      BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
      System.out.print("enter the BigInteger: (do not pad with zeros); ");
      String str = input.readLine();
      if (str.length() > INTSIZ) throw new ArithmeticException("OVERFLOW!");
      for (int i = 0; i < str.length(); i++)
      {
         intArray[INTSIZ - str.length() + i] = Integer.parseInt(str.substring(i, i+1));
      }
   }
   public BigInteger add(BigInteger biref)
   {
      BigInteger bsum = new BigInteger();

      int carry = 0;


      for (int i = INTSIZ - 1; i >= 0; i--)
      {
         int tmp = intArray[i] + biref.intArray[i] + carry;

	 bsum.intArray[i] = tmp % 10;

	 carry = tmp/10;
      }
      return bsum;
   }
   public BigInteger subtract(BigInteger biref)
   {
      BigInteger bdifference = new BigInteger();
      int num1, num2;
      boolean borrow = false;

      for (int i = INTSIZ - 1; i >= 0; i--)
      {
         num1 = intArray[i];
	 num2 = biref.intArray[i];
	 if (borrow == true)
	 {
	    num1 = num1 - 1;
            borrow = false;
	 }
         if (num2 > num1)
	 {
	    borrow = true; 
	    num1 = num1 + 10;
	 }
	 bdifference.intArray[i] = num1 - num2;
      }
      return bdifference;
   }
   public BigInteger multiply(BigInteger biref)
   {
      BigInteger bproduct = new BigInteger();
      BigInteger badd = new BigInteger();

      int carry = 0, j, tmp = 0;

      for (int i = INTSIZ - 1; i >=0; i--)
      {
         for (j = INTSIZ - 1; j >=0; j--)
	 {
	    tmp = intArray[j] * biref.intArray[i] + carry;

	    badd.intArray[j] = tmp % 10;

	    carry = tmp/10;
	 }
         badd.shift(INTSIZ-1-i);
	 bproduct = bproduct.add(badd);
      }
      return bproduct;
   }
   public void shift(int n)
   {
      for (int j = 0; j < n; j++)
      {
         for (int i = 1; i < INTSIZ; i++)
	 {
	    intArray[i-1] = intArray[i];
	 }
	 intArray[INTSIZ - 1] = 0;
      }
   }
}
