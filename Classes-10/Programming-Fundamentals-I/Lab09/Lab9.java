class MoneyBag
{  
   int quarters, dimes, nickles, pennies, value;
   public MoneyBag()
   {
     quarters = 0;
     dimes = 0;
     nickles = 0;
     pennies = 0;
   }

   public MoneyBag(int q, int d, int n, int p)
   {
      quarters = q;
      dimes = d;
      nickles = n;
      pennies = p;
   }

   public void printContents()
   {
      System.out.println("quarters = " + quarters + ", dimes = " + dimes + ", nickles = " + nickles + ", pennies = " + pennies);
   }

   public int getValue()
   {
      value = (quarters * 25) + (dimes * 10) + (nickles * 5) + pennies;
      return value;
   }

   public void add(int q, int d, int n, int p)
   {
     quarters = quarters + q;
     dimes = dimes + d;
     nickles = nickles + n;
     pennies = pennies + p;
   }

   public void add(MoneyBag ref)
   {
      quarters = quarters + ref.quarters;
      ref.quarters = 0;
      dimes = dimes + ref.dimes;
      ref.dimes = 0;
      nickles = nickles + ref.nickles;
      ref.nickles = 0;
      pennies = pennies + ref.pennies;
      ref.pennies = 0;
   }

   public void compare(MoneyBag ref)
   {
      if (ref.value > value)
      {
         System.out.println("IS LESS THAN");
      }
      else if (ref.value < value)
      {
         System.out.println("IS GREATER THAN");
      }
      else
      {
         System.out.println("IS EQUAL TO");
      }
   }

   public MoneyBag subtract(int s)
   {
      if (value > s)
      {
         value = value - s;
	 quarters = 0;
	 dimes = 0;
	 nickles = 0;
	 pennies = 0;
	 while (value >= 25)
	 {
	    value = value - 25;
	    quarters++;
	 }
	 while (value >= 10)
	 {
	    value = value - 10;
	    dimes++;
	 }
	 while (value >= 5)
	 {
	    value = value - 5;
	    nickles++;
	 }
	 while (value >= 1)
	 {
	    value = value - 1;
	    pennies++;
	 }
	 
      }
      else
      {
         System.out.println("Insufficient funds - purchase denied.");
      }
      return new MoneyBag(quarters, dimes, nickles, pennies);
   }
}
public class Lab9
{
    public static void main(String args[])
    {
        MoneyBag mb0 = new MoneyBag();
        MoneyBag mb1 = new MoneyBag(1, 2, 3, 4);

        System.out.println("mb0:");
        mb0.printContents();
        System.out.println("value = " + mb0.getValue() + "\n");

        System.out.println("mb1:");
        mb1.printContents();
        System.out.println("value = " + mb1.getValue() + "\n");

        System.out.println("adding $0.50 to mb0");
        mb0.add(2, 0, 0, 0); 

        System.out.println("mb0:");
        mb0.printContents();
        System.out.println("value = " + mb0.getValue() + "\n");

        System.out.print("Comparing mb0 and mb1: ");
        mb0.compare(mb1);

        System.out.println("\nAdding $0.14 to mb0");
        mb0.add(0, 0, 2, 4); 

        System.out.println("mb0:");
        mb0.printContents();
        System.out.println("value = " + mb0.getValue() + "\n");

        System.out.print("Comparing mb0 and mb1: ");
        mb0.compare(mb1);

        System.out.println("\nAdding to mb0");
        mb0.add(0, 0, 0, 1); 

        System.out.println("mb0:");
        mb0.printContents();
        System.out.println("value = " + mb0.getValue() + "\n");

        System.out.print("Comparing mb0 and mb1: ");
        mb0.compare(mb1);

        System.out.println("\nAdding contents of mb1 into mb0");
        mb0.add(mb1); 
        System.out.println("mb0:");
        mb0.printContents();
        System.out.println("value = " + mb0.getValue() + "\n");
        System.out.println("mb1:");
        mb1.printContents();
        System.out.println("value = " + mb1.getValue() + "\n");

        System.out.println("Creating a new MoneyBag");
        MoneyBag mb2 = new MoneyBag(5, 4, 3, 2);
        System.out.println("mb2:");
        mb2.printContents();
        System.out.println("value = " + mb2.getValue() + "\n");

        System.out.println("Subtracting $5.00");
        mb2 = mb2.subtract(500);
        System.out.println("mb2:");
        mb2.printContents();
        System.out.println("value = " + mb2.getValue() + "\n");

        System.out.println("Oops, let's try $0.50");
        mb2 = mb2.subtract(50);
        System.out.println("Change due:");
        System.out.println("mb2:");
        mb2.printContents();
        System.out.println("value = " + mb2.getValue() + "\n");

        System.out.println("Subtracting $0.41");
        mb2 = mb2.subtract(41);
        System.out.println("Change due:");
        System.out.println("mb2:");
        mb2.printContents();
        System.out.println("value = " + mb2.getValue() + "\n");
    }
}

