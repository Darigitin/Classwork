class Person
{
    private String name;
    private int    age;

    public Person()
    {
        name = "confidential";
        age  = -1;
    }

    public Person(String n, int a)
    {
        name = n;
        age  = a;
    }

    public void hello()
    {
        System.out.print("hello from " + name);
        System.out.println(", my age is: " + age);
    }

    public void birthday()
    {
        System.out.println(name + " is having a birthday!");

        if (age != -1)
        {
            age = age + 1;
        }
    }

    public void marries(Person ref)
    {
        System.out.println("I " + name + ", take " + ref.name + " to be my lawfully wedded spouse.");
    }
}


public class Nov24
{
    public static void main(String args[])
    {
        Person bob  = new Person("Bob", 24);
        Person mary = new Person("Mary", 23);

        bob.hello();
        mary.hello();

        bob.marries(mary);

    }
}
