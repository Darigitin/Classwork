class Person
{
    private String name;
    private int    age;

    public void setName(String n)
    {
        name = n;
    }

    public void setAge(int a)
    {
        age = a;
    }

    public void hello()
    {
        System.out.print("hello from " + name);
        System.out.println(", my age is: " + age);
    }

    public void birthday()
    {
        System.out.println(name + " is having a birthday!");
        age = age + 1;
    }
}

public class Nov3
{
    public static void main(String args[])
    {
        Person bob;  // bob is a reference variable that CAN be used
                     // to store the address of a Person object

        bob = new Person();  //TADA!  bob is now refering to a Person object
                             // the object is created with "new"

        //bob.name = "bob";
        bob.setName("bob");
        //bob.age  = 25;
        bob.setAge(25);

        //System.out.println("Bob's name is: " + bob.name);
        //System.out.println("Bob's age is: " + bob.age);

        bob.hello();

        Person mary = new Person();

        //mary.name = "mary";
        mary.setName("mary");
        //mary.age  = 21;
        mary.setAge(21);

        mary.hello();

        bob.birthday();
        bob.hello();

        mary.birthday();
        mary.hello();

	Person theBoss
    }
}
