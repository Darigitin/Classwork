class Rectangle
{
	private int length;
	private int width;

	public Rectangle()
	{
		System.out.println("Constructing a default Rectangle");
		length = 3;
		width = 2;
	}
	
	public Rectangle(int l, int w)
	{
		System.out.println("Constructing a custom Rectangle");
		length = l;
		width = w;
	}

	public int perimeter()
	{
		return ( 2 * length + 2 * width );
	}
	public int area()
	{
		return (length * width);
	}

	public void printRect()
	{
		System.out.println("printing the dims of a rectangle...");
		System.out.println("length = " + length);
		System.out.println("width = " + width);
	}
}

class Square extends Rectangle
{
	String color;
	
	public Square()
	{
	    super(3,3);
	    System.out.println("Constructing a default Square");

	    color = "orange";
	}

	public Square(int l, String c)
	{
	    super(l, l);

	    color = c;
	    System.out.println("Constructing a custom Rectangle");
	}
	
	public void printRect()
	{
	    System.out.println("Square printRect: color = " + color);

	    super.printRect();
	}

	
}

public class Nov8
{
	public static void main(String args[])
	{
		Square mysquare = new Square();
		
		mysquare.printRect();

		int a = mysquare.area();
		int p = mysquare.perimeter();

		System.out.println("area = " + a);
		System.out.println("perimeter = " + p);

		Square mysquare2 = new Square(5, "red");
		
		mysquare2.printRect();

		a = mysquare2.area();
		p = mysquare2.perimeter();

		System.out.println("area = " + a);
	}
}
