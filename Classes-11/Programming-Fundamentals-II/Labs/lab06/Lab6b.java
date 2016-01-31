import java.io.*;

public class Lab6b
{
    public static void main(String argv[]) throws IOException
    {
        String buffer = null;
	String sar[] = new String [1000000];
        int numTokens = 0, i;

        if (argv.length != 1) {
            System.out.println("You must supply a file name!");
            System.exit(0);
        }

        FileReader fr     = new FileReader(argv[0]);
        BufferedReader br = new BufferedReader(fr);

        while ((buffer = br.readLine()) != null) 
	{
	    int tokenStart = 0, tokenEnd = 0;
	    char fDelim = 'N', sDelim = 'N';

	    String d = ".";
            System.out.println("[" + buffer + "]");
	    for (i = 0; (i+1) < buffer.length(); i++)
	    {
               System.out.println("First character is " + buffer.charAt(0));
               if(buffer.charAt(i) == ' ')
               {
                  System.out.println("The character at position " + i + " of [" + buffer + "] is a [" + buffer.charAt(i) + "]");
                  i++;
               }
	       if(isDelim(buffer.substring(i, i+1), d) && !isDelim(buffer.substring(i+1, i+2), d))
	       {
	          fDelim = 'Y';
	          tokenStart = i+1;
		  System.out.println("Storing " + tokenStart + " in tokenStart.");
	       }
	       if (!isDelim(buffer.substring(i, i+1), d) && isDelim(buffer.substring(i+1, i+2), d))
	       {
	          sDelim = 'Y';
	          tokenEnd = i+2;
	       }
	       if (tokenStart < tokenEnd && (tokenEnd - tokenStart ) <= 3)
	       {
	          System.out.println("Putting " + buffer.substring(tokenStart, tokenEnd) + " into " + sar[numTokens]);
	          sar[numTokens] = buffer.substring(tokenStart, tokenEnd);
		  System.out.println(buffer.substring(tokenEnd) + " remains. Storing it in buffer.");
		  buffer = buffer.substring(tokenEnd);
		  i = 0;
		  tokenStart = 0;
		  tokenEnd = 0;
	       }
	       if (sar[numTokens] != null)
	       {
	          if (tokenStart < tokenEnd && (tokenEnd - tokenStart) > 3)
		  {
		     System.out.println("Putting " + buffer.substring(tokenStart, tokenEnd) + " into " + sar[numTokens]);
		     sar[numTokens] = sar[numTokens] + buffer.substring(tokenStart, tokenEnd);
		     numTokens++;
		     tokenStart = 0;
		     tokenEnd = 0;
		  }
	       else if (tokenStart < tokenEnd)
	       {
	          System.out.println("Putting " + buffer.substring(tokenStart, tokenEnd) + " into " + sar[numTokens]);
	          sar[numTokens] = buffer.substring(tokenStart, tokenEnd);
		  System.out.println(buffer.substring(tokenEnd) + " remains. Storing it in buffer.");
		  buffer = buffer.substring(tokenEnd);
                  i = 0;
		  numTokens++;
		  tokenStart = 0;
		  tokenEnd = 0 ;
	       }
	       }
               if (tokenStart < tokenEnd)
               {
	          System.out.println("Putting " + buffer.substring(tokenStart, tokenEnd) + " into " + sar[numTokens]);
	          sar[numTokens] = buffer.substring(tokenStart, tokenEnd);
		  System.out.println(buffer.substring(tokenEnd) + " remains. Storing it in buffer.");
		  buffer = buffer.substring(tokenEnd);
		  i = 0;
		  numTokens++;
		  tokenStart = 0;
		  tokenEnd = 0;
               }
	    }
	       if (sDelim == 'N')
	       {
	          sar[numTokens] = buffer.substring(0) + " ";
	       }
        }
	for (i = 0; i < numTokens; i++)
	{
	   System.out.println(i + ". [" + sar[i] + "]");
	}
	
    }
	public static boolean isDelim(String a, String b)
	{
	   if(b.indexOf(a) != -1)
	   {
	      return true;
	   }
	   else
	   {
	      return false;
	   }
	}
}

