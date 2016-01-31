class MyClass
{
    public int x;

    public void doubler()
    {
       x = x*2;
    }

    public void doubler(MyClass ref)
    {
       ref.x = ref.x * 2;
    }

    public void addToMe(MyClass ref)
    {
       x = x + ref.x;
    }
}

public class Nov17
{
    public static void main(String args[])
    {
        int i=10;

        MyClass myrefvar = new MyClass();

        myrefvar.x = i;

        System.out.println("myrefvar.x = " + myrefvar.x);

	myrefvar.doubler();

	System.out.println("myrefvar.x = " + myrefvar.x);

	MyClass myrefvar2 = new MyClass();

	myrefvar2.x = 5;

	myrefvar2.doubler(myrefvar);

	System.out.println("myrefvar.x = " + myrefvar.x);

	myrefvar.addToMe(myrefvar2);

	System.out.println("myrefvar.x = " + myrefvar.x);
    }
}
