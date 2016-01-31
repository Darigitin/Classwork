import java.io.*;
public class Apr21
{
   public static void main(String args[])
   {
      InputStreamReader reader = new InputStreamReader(System.in);
      
      String s;
      int ten, one;
      char ch;
      int intCh;
 
      ten = reader.read();
      one = reader.read();
      System.out.println("ten = " ten);
      System.out.println("(char) ten = " + (char) ten);

      System.out.println("one = " one);
      System.out.println("(char) one = " + (char) one);
      
      System.out.println("ten * 10 = " + ten * 10);
   }
}
