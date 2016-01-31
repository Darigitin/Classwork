import java.io.*;
public class Lab4
{
   public static void main(String args[]) throws IOException
   {
      BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
      System.out.print("input: ");
      String str = input.readLine();
      String star[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

      for (int i = 0; i < str.length(); i++)
      {
          if((str.charAt(i) - 48) <= 9 && str.charAt(i) >= 48)
	  {
	     str = str.substring(0,i) + star[str.charAt(i) - 48] + str.substring(i + 1);
	  }
      }
      System.out.println(str);




   }
}
