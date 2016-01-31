class MyClass
{
	public static void hello()	
	{
		System.out.println("hello from MyClass");
	}
	
	public void non_static_hello()
	{
		System.out.println("hello from MyClass");
	}
public class Nov3c
{
	public static void hello()
	{
		System.out.println("hello");
	}	
	public static void main(String args[])
	{
		hello();

		MyClass.hello();

		MyClass myref = new MyClass();
	
		myref.non_sttaic_hello();
	}
}
