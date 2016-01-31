// AmountOrderedException a custom Exception
public class AmountOrderedException extends Exception
{	
		private String exceptionMessage;	//text of the message;
		
		//constructor
		public AmountOrderedException()
		{
			super("This is a custom AmountOrderedException \n");
			exceptionMessage = "The Order Amount must be greater than 0";
		}
		
		public String toString()
		{
			return super.toString() + exceptionMessage;
		}
}								