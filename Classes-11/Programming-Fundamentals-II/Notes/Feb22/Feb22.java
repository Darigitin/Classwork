/*
    # public int indexOf(int character)
    # public int indexOf(int character, int starting-index)
    # public int indexOf(String s)
    # public int indexOf(String s, int starting-index)
    # public int lastIndexOf(int character)
    # public int lastIndexOf(int character, int starting-index)
    # ...

    # public char charAt(int index)
    # public String substring(int startindex)
    # public String substring(int startindex, int endIndex)

*/

public class Feb22
{
    public static void main(String args[])
    {
       String str = "hello world goodbye";

       int index = str.indexOf(' ');

       System.out.println("index = " + index);

       String firstWord = str.substring(0, index);

       System.out.println("first word = [" + firstWord + "]");

       int index2 = str.indexOf(' ', index + 1);

       System.out.println("index2 = " + index2);

       String secondWord = str.substring(index + 1, index2);

       System.out.println("second word = [" + secondWord + "]");

       String thirdWord = str.substring(index2 + 1);

       System.out.println("third word = [" + thirdWord + "]");

    }
}
