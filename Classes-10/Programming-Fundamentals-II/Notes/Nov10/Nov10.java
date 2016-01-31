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
}
class Student extends Person
{
   private int studentID;

   private String advisor;

   public Student(String n, int a, int id, String adv)
   {
     super(n, a);

     studentID = id;

     advisor = adv;

     System.out.println("creating a custom Student!");
   }

   public void printStudent()
   {
     super.hello();
     System.out.println("My student ID is : " + studentID);
     System.out.println("My advisor is : " + advisor);
   }
}

public class Nov10
{
    public static void main(String args[])
    {
       Student bob = new Student("bob", 21, 12345, "JudyJ");
       bob.printStudent();
    }
}
