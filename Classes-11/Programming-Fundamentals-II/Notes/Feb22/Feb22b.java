public class Feb22b
{
   public static void main(String args[])
   {
      //String str = "hello again hello just called to say hello";
      String str = " hello  world";
      char c = ' ';

      int start = 0, end;
      end = str.indexOf(c);
      while (end != -1)
      {
	 System.out.println("word = [" + str.substring(start, end) + "]");
         start = end + 1;
         end = str.indexOf(c, start); 
      }
      System.out.println("word = [" + str.substring(start) + "]");
   }
}
