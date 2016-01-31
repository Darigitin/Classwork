import java.io.*;

public class Lab6
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
	   String remain = "";
           String line = remain + buffer;
	   int end = line.indexOf(".  ");
	   if (line.charAt(line.length()-1) == '.' && end == -1)
	   {
	      System.out.println("[" + line.substring(0) + "]");
	   }
           else if(end == -1)
           {
	      System.out.println("[" + line.substring(0) + " " + br.readLine() + "]");
           }
	   else if(end != -1)
	   {
	      System.out.println("[" + line.substring(0, end + 1) + "]");
              remain = line.substring(end);
              System.out.println("[" + remain.substring(3) + "]");
	   }
           

	}
     }
}

