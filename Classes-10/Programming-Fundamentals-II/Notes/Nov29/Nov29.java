abstract class A
{
   public void method1()
   {
      System.out.println("hello from method1!");
   }

   public abstract void method2();


}
class B extends A
{
   public void method2()
   {
      System.out.println("hello from method2!");
   }
}
public class Nov29
{
    public static void main(String args[])
    {
       B b = new B();

       b.method1();
    }
}
