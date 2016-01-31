import java.io.*;
import java.util.*; 

public class Assemble2
{
    public static String pad(int n, int w)
    {
        // determine length of 'n'
	int nLength;

        // calculate number of leading 0's to pad with
	String s = String.valueOf(n);
        nLength = s.length();
	while(nLength < w)
	{
           nLength++;
	   s = "0" + s;
	}

        // create and return string of leading 0's, and 'n'
	return s;
    }


    static void readSrc(String fname) throws IOException
    {
        String opcodear[] = {"HALT", "ADD", "SUB", "MLT", "DIV", "ILOAD", "LOAD", "STOR", "READ", "WRITE", "BR", "BZ", "BN", "DUMP"};
        FileReader fr = new FileReader(fname);
        BufferedReader br = new BufferedReader(fr);
	String buffer = null;
	String opcode, operand;

        while ((buffer = br.readLine()) != null)
        {
	    int i = 0;
            // skip any lines of length zero or starting with '#'
	    if((buffer.indexOf("#") == 0) || (buffer.length() == 0))
	    {
	       continue;
	    }
            // tokenize string.  1st token is opcode, 2nd is operand
	    // and determines if the opcode is valid
	    StringTokenizer stok = new StringTokenizer(buffer);
	    opcode = stok.nextToken();
	    operand = stok.nextToken();
	    while(!opcode.equals(opcodear[i]))
	    {
	       i++;
	       if(i == opcodear.length)
	       {
	          System.out.println("unknown opcode: " + opcode);
	          System.exit(0); 
	       }
            // convert string operand to an integer.
	    // calls the pad method and prints the combined strings
            }
            int operandInt = Integer.parseInt(operand);
	    System.out.println(pad(i, 2) + pad(operandInt, 2));

        }
    }

    public static void main(String argv[]) throws IOException
    {
        if (argv.length != 1)
        {
            System.out.println("usage:  java Assemble INPUTFILE");
            System.exit(0);
        }

        readSrc(argv[0]);
    }
}
