public class Oct25b
{
	public static String concat(String a, String b)
	{
		return (a + " " + b);
	}
	public static void main(String args[])
	{
		String fname = "BoB";
		String lname = "Barker";

		String fullname;

		fullname = concat(fname, lname);
		System.out.println("fullname = " + fullname);
	}
}
