class ST
{
   String star[];
   int numTokens;
   int index = 0;

   public ST(String s, String d)
   {
      star = new String[50];
      int tokenStart = 0, tokenEnd = 0;
      for (int i = 0; (i+1) < s.length(); i++)
      {
         if (isDelim(s.substring(i, i+1), d) && !isDelim(s.substring(i+1, i+2), d))
         {
            tokenStart = i+1;
         }
         if (!isDelim(s.substring(i, i+1), d) && isDelim(s.substring(i+1, i+2), d))
         {
            tokenEnd = i+1; 
         }
	 if (tokenStart < tokenEnd)
	 {
	   star[numTokens] = s.substring(tokenStart, tokenEnd);
	   numTokens++;
           tokenStart = 0;
           tokenEnd = 0;
	 }
      }         
      if (tokenStart > tokenEnd)
      {
      star[numTokens] = s.substring(tokenStart);
      numTokens++;
      tokenStart = 0;
      tokenEnd = 0;
      }
   }


   public ST(String s)
   {
      this(s, " ");
   }

   public boolean isDelim(String a, String b)
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
   public int countTokens()
   {
      return (numTokens - index);
   }

   public boolean hasMoreTokens()
   {
      return (numTokens > index);
   }
   
   public String nextToken()
   {
      return star[index++]; 
   }

}

public class Lab5
{

    public static void main(String argv[])
    {
        String str;

    //1)
        str = "Hello world";
        ST stok= new ST(str);
        
        System.out.println(str);

        while (stok.hasMoreTokens())
        {
            System.out.println("#tokens = " + stok.countTokens());
            System.out.println("token: " + stok.nextToken());
        }
        System.out.println("#tokens = " + stok.countTokens());
        System.out.println("\n\n");

    //2)
        str = "    Hello    world   ";
        stok= new ST(str);
        
        System.out.println(str);

        while (stok.hasMoreTokens())
        {
            System.out.println("#tokens = " + stok.countTokens());
            System.out.println("token: " + stok.nextToken());
        }
        System.out.println("#tokens = " + stok.countTokens());
        System.out.println("\n\n");

    //3)
        str = "root:x:0:0:root:/root:/bin/bash";
        stok = new ST(str, ":");

        System.out.println(str);

        System.out.println("username = " + stok.nextToken());
        System.out.println("password = " + stok.nextToken());
        System.out.println("userid   = " + stok.nextToken());
        System.out.println("groupid  = " + stok.nextToken());
        System.out.println("comment  = " + stok.nextToken());
        System.out.println("home dir = " + stok.nextToken());
        System.out.println("shell    = " + stok.nextToken());
        System.out.println("\n\n");

    //4)
        str = "Hello-world.It is!a nice day,today";
        stok= new ST(str,"-.!, ");
        
        System.out.println(str);

        while (stok.hasMoreTokens())
        {
            System.out.println("#tokens = " + stok.countTokens());
            System.out.println("token: " + stok.nextToken());
        }
        System.out.println("#tokens = " + stok.countTokens());

    }
}


