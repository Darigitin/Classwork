class Burrito
{
	private int beans, beef, cheese, salsa;
	private String name;
	public Burrito()
	{
		beans = 2;
		beef = 1;
		cheese = 1;
		salsa = 1;
		name = "No Name";
	}
	public Burrito(int b, int b2, int c, int s, String n)
	{
		beans = b;
		beef = b2;
		cheese = c;
		salsa = s;
		name = n;
	}
	public void print_order()
	{
		System.out.println("The ingredients in this burrito are: ");
		System.out.println(beans + " unit(s) of beans.");
		System.out.println(beef + " unit(s) of beef.");
		System.out.println(cheese + " unit(s) of cheese.");
		System.out.println(salsa + " unit(s) of salsa.");
		System.out.println("This burrito belongs to " + name);
	}
	public int weight()
	{
		return beans + beef + cheese + salsa;
	}
	public void gutBuster()
	{
		beans = beans * 2;
		beef = beef * 2;
		cheese = cheese * 2;
		salsa = salsa * 2;
	}
}
public class Lab7
{
	public static void main(String args[])
	{
		Burrito b1 = new Burrito();
		
		b1.print_order();
		System.out.println("The burrito weighs " + b1.weight() + " ounces.");
		b1.gutBuster();
		System.out.println(" ");
		b1.print_order();
		System.out.println("The burrito weighs " + b1.weight() + " ounces.");
		System.out.println(" ");
		Burrito b2 = new Burrito(8, 2, 3, 1, "Big Al");
		b2.print_order();
		System.out.println("The burrito weighs " + b2.weight() + " ounces.");
		System.out.println(" ");
		b2.gutBuster();
		b2.print_order();
		System.out.println("The burrito weighs " + b2.weight() + " ounces.");
	}
}
