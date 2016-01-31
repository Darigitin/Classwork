class Person
{
	public String name;
	public int age;

	public void hello()
	{
		System.out.print("hello from " + name);
		System.out.println(", my age is: " +age);
	}

	public void birthday()
	{
		System.out.println(name + " is having a birthday!");
		age++
	}
}

public class Oct27
{
    public static void main(String args[])
    {
	Person bob;

	bob = new Person();

	bob.name = "bob";
	bob.age = 25;
	
	bob.hello();

	Person mary = new Person();

	mary.name = "mary";
	mary.age = 21;

	marry.hello();

	bob.birthday();
	bob.hello();

	mary.birthday();
	mary.hello();
    }
}
