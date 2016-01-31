public class Sept15b
{
    public static void main(String args[])
    {
        int i, j;

        i=6;
        j=10;

        int sum;

        sum = i + j;

        System.out.println("sum = " + sum);

        int diff;

        diff = i - j;

        System.out.println("diff = " + diff);
	
	int product = i*j;

	System.out.println("Product = " + product);

	double quotient = (double) i/j;
	
	System.out.println("Quotient = " + quotient);

	final double PI=3.1415;

	double area;

	int r = 5;
	area = r * r * PI;

	System.out.println("The area is " + area);
    }
}
