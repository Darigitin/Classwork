abstract class GeoFigure
{
   protected int d1;
   protected int d2;

   public GeoFigure(int a, int b)
   {
      d1 = a;
      d2 = b;
      System.out.println("constructing a GeoFigure");
   }
   public abstract int area();
}

class Rectangle extends GeoFigure
{
   public Rectangle(int a, int b)
   {
      super(a, b);
      System.out.println("constructing a rectangle");
   }
   public int area()
   {
      return d1 * d2;
   }
}
class Square extends Rectangle
{
   public Square(int a)
   {
      super (a, a);
      System.out.println("constructing a squre");
   }
}
class Triangle extends GeoFigure
{
   public Triangle(int a, int b)
   {
      super(a, b);
   }
   public int area()
   {
      return (int) (.5*(d1*d2));
   }
}
public class Nov29b
{
    public static void main(String args[])
    {
      Rectangle myrect = new Rectangle(3, 4);
      int a = myrect.area();

      System.out.println("area of rectangle is " + a);

      Triangle mytri = new Triangle(3, 4);
      a = mytri.area();

      System.out.println("area of triangle is " + a);

      System.out.println("===========================");

      Square mysq = new Square(4);
      a = mysq.area();

      System.out.println("area of a square is " + a);
    }
}
