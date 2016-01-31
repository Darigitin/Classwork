import java.io.*;

public class VPCrte
{
    static final int MEMSIZ = 100;

    static final int HALT  = 0;
    static final int ADD   = 1;
    static final int SUB   = 2;
    static final int MLT   = 3;
    static final int DIV   = 4;
    static final int ILOAD = 5;
    static final int LOAD  = 6;
    static final int STOR  = 7;
    static final int READ  = 8;
    static final int WRITE = 9;
    static final int BR    = 10;
    static final int BZ    = 11;
    static final int BN    = 12;
    static final int DUMP  = 13;
 
    static int MEMORY[] = new int[MEMSIZ];
    static int PCREG;
    static int IRREG;
    static int GPREG;
    
    static boolean debug = false;

    static void readToMemory(String fname) throws IOException
    {
        FileReader fr = new FileReader(fname);
	BufferedReader br = new BufferedReader(fr);
        String buffer = "";
        // for each line of "machine code":
	for (int i = 0;(buffer = br.readLine()) != null; i++)
        {
            if (debug)
            {      
                // display info about code as it is loaded into memory
		System.out.println("readToMemory: " + "[" + i + "]" + " = (" + buffer + ")");
            }
            
            // copy machine code instruction into memory
	    MEMORY[i] = Integer.parseInt(buffer);

        }
    }

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
    
    public static void dumpMemory()
    {
        System.out.println("===================================================================");
        int c=0;

        System.out.println("PCREG = " + pad(PCREG, 4));
        System.out.println("IRREG = " + pad(IRREG,4));
        System.out.println("GPREG = " + pad(GPREG, 4) + "\n");
         
        System.out.println("MEMORY:     0     1     2     3     4     5     6     7     8     9");
        System.out.println("    ---------------------------------------------------------------");
        
        for (int i=0; i<MEMSIZ; i++)
        {
            if ((i%10) == 0)
            {
                System.out.print("     " + c + "|");
                c++;
            }
            
            System.out.print("  " + pad(MEMORY[i], 4));
            
            if (((i+1)%10) == 0)
                System.out.println();
        }
        System.out.println();
        System.out.println("===================================================================");
    }
       
    public static void runProg() throws IOException
    {
        // initialize PCREG to zero
	PCREG = 0;
	String opcodear[] = {"HALT", "ADD", "SUB", "MLT", "DIV", "ILOAD", "LOAD", "STOR", "READ", "WRITE", "BR", "BZ", "BN", "DUMP"};
        
        while(true)
        {
            // fetch current instruction from memory and copy to IRREG
	    IRREG = MEMORY[PCREG];
        
            // extract opcode and operand from IRREG
            int opcode = IRREG / 100;
            int operand = IRREG % 100;
         
            if (debug)   
            {
                // display info about code as it is executed
		System.out.println("runProg: MEMORY [" + PCREG + "] = " + pad(MEMORY[PCREG], 4) + ", opcode = " + pad(opcode, 2) + ", operand = " + pad(operand, 2) + ", GPREG = " + pad(GPREG, 4) + " (" + opcodear[opcode] + ")");
            }

            // handle all of the opcodes with a large if/else if/else if/...
            // or switch statement.
	    switch(opcode)
	    {
	       case 0:
	       {
	          System.exit(0);
		  break;
	       }
	       case 1:
	       {
	          GPREG = GPREG + MEMORY[operand];
		  break;
	       }
	       case 2:
	       {
	          GPREG = GPREG - MEMORY[operand];
		  break;
	       }
	       case 3:
	       {
	          GPREG = GPREG * MEMORY[operand];
		  break;
	       }
	       case 4:
	       {
	          GPREG = GPREG / MEMORY[operand];
		  break;
	       }
	       case 5:
	       {
	          GPREG = operand;
		  break;
	       }
	       case 6:
	       {
	          GPREG = MEMORY[operand];
		  break;
	       }
	       case 7:
	       {
	          MEMORY[operand] = GPREG;
		  break;
	       }
	       case 8:
	       {
	          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  System.out.print("[" + operand + "]" + "? ");
		  MEMORY[operand] = Integer.parseInt(br.readLine());
		  break;
	       }
	       case 9:
	       {
	          System.out.println("[" + operand + "]" + " -> " + MEMORY[operand]);
		  break;
	       }
	       case 10:
	       {
	          PCREG = operand;
		  continue;
	       }
	       case 11:
	       {
	          if (GPREG == 0)
		  {
		     PCREG = operand;
		     continue;
		  }
		  break;
	       }
	       case 12:
	       {
	          if(GPREG != 0)
		  {
		     PCREG = operand;
		     continue;
		  }
		  break;
	       }
	       case 13:
	       {
	          dumpMemory(); 
	       }

	    }
            // increment PCREG to prepare for next instruction
	    PCREG++;
        }
    }
    
    public static void main(String argv[]) throws IOException
    {
        if (argv.length == 0) 
        {
            System.out.println("You must supply a file name!");
            System.exit(0);
        } 
        
        if ((argv.length == 2) && (argv[1].equals("debug"))) debug = true;

        readToMemory(argv[0]);

        if (debug) dumpMemory();
        
        runProg();
    }
}
