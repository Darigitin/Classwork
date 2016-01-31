import java.text.NumberFormat;

public class Account
{
	private final double RATE = 0.035;
	private final int FEE = 10;
	private long acctNumber;
	private double balance;
	private String name;

   public Account (String owner, long account, double initial)
   {
      setName(owner);
      setAccount(account);
      setBalance(initial);
      serviceFee();
   }

   public double deposit (double amount)
   {
      balance = balance + amount;

      return balance;
   }

   public double withdraw (double amount, double fee)
   {
   		if (amount < balance)
   		{
   			balance = balance - amount;
   		}
   		else
   		{
   			System.out.println("Insufficient Funds!");
   		}
      return balance;
   }

   public double addInterest ()
   {
      balance += (balance * RATE);
      return balance;
   }
   
   public double serviceFee()
   {
   		balance = balance - FEE;
   		return balance;
   }
   
   public void setName(String aName)
   {
   		name = aName;
   }
   
   public void setAccount(long aAccount)
   {
   		acctNumber = aAccount;
   }
   
   public void setBalance(double aInitial)
   {
   		balance = aInitial;
   }
   
   public long getAcctNumber()
   {
   		return acctNumber;
   }

   public double getBalance()
   {
   		return balance;
   }
   
   public String getName()
   {
   		return name;
   }

   public String toString ()
   {
      NumberFormat fmt = NumberFormat.getCurrencyInstance();

      return (acctNumber + "\t" + name + "\t" + fmt.format(balance));
   }
}
