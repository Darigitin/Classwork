import java.io.*;
class BurritoSupreme extends Burrito
{
   private int sour_cream;
   private int black_olives;

   public BurritoSupreme()
   {
      super(2, 1, 1, 1, "No Name");
      sour_cream = 1;
      black_olives = 1;
   }

   public BurritoSupreme(int b, int b2, int c, int s, String n, int sc, int bo)
   {
      super(b, b2, c, s, n);
      sour_cream = sc;
      black_olives = bo;
   }
   public void gutBuster()
   {
     super.gutBuster();
     sour_cream = sour_cream * 2;
     black_olives = black_olives * 2;
   }
   public void print_order()
   {
      super.print_order();
      System.out.println(sour_cream + " unit(s) of sour cream.");
      System.out.println(black_olives + " unit(s) of black olives");
   }
   public int weight()
   {
      return  super.weight() + sour_cream + black_olives;
   }
}
public class Lab8
{
   public static void main(String args[]) throws IOException
   {
        BufferedReader input = new BufferedReader ( new InputStreamReader (System.in));
	String input_string;
        int beans, beef, cheese, salsa, sour_cream, black_olives;
	String name;
	BurritoSupreme bs1 = new BurritoSupreme();

	bs1.print_order();
	System.out.println("The BurritoSupreme weighs " + bs1.weight() + " ounces.");
	bs1.gutBuster();
	bs1.print_order();
	System.out.println("The BurritoSupreme weighs " + bs1.weight() + " ounces.");
	
	System.out.println("Hello Burrito Lover, what is your name?");
	name = input.readLine();
	System.out.println("How many ounces of beans?");
	input_string = input.readLine();
	beans = Integer.parseInt(input_string);
	System.out.println("How many ounces of beef?");
	input_string = input.readLine();
	beef = Integer.parseInt(input_string);
	System.out.println("How many ounces of cheese?");
	input_string = input.readLine();
	cheese = Integer.parseInt(input_string);
	System.out.println("How many ounces of salsa?");
	input_string = input.readLine();
	salsa = Integer.parseInt(input_string);
	System.out.println("How many ounces of sour cream?");
	input_string = input.readLine();
	sour_cream = Integer.parseInt(input_string);
	System.out.println("How many ounces of black olives?");
	input_string = input.readLine();
	black_olives = Integer.parseInt(input_string);

	BurritoSupreme bs2 = new BurritoSupreme(beans, beef, cheese, salsa, name, sour_cream, black_olives);

	bs2.print_order();
	System.out.println("The BurritoSupreme weighs " + bs2.weight() + " ounces.");
	bs2.gutBuster();
	bs2.print_order();
	System.out.println("The BurritoSupreme weighs " + bs2.weight() + " ounces.");
   }
}
