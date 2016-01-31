public class Hangman
{
	private String targetString;
	private String displayString;
	private final String STARS = "*************************************";
	
	public Hangman(String aTargetString)
	{
		setTargetString(aTargetString);
		setDisplayString(STARS.substring(0,aTargetString.length()));
	}
	
	public int searchTarget(char guess)
	{
	 int position;
     position = targetString.indexOf(guess); //sets position to first finding of letter entered
    
      // warns user that letter was not found and asks for another letter
      if (position == -1)  //not found -1 means that the guess was not found.
       {
       	return -1;	//-1 means that the guess was not found in the targetString 
       }
      else
      {
      	while(position != -1)  //while it found the guess
   		{
            	displayString = displayString.substring(0,position) +
             	guess +
             	displayString.substring(position+1,displayString.length());//creates substring with new letter
            	position = targetString.indexOf(guess,position+1); //finds next letter if used multiple times 
        }
	  }
   	return 0;		// 0 means that they made an accurate guess
	}
	
		
	public void setTargetString(String aTargetString)
	{
		targetString = aTargetString.toUpperCase();
	}
	
	public void setDisplayString(String aDisplayString)
	{
		displayString = aDisplayString;
	}
	
	
	public String getTargetString()
	{
		return targetString;
	}
	
	public String getDisplayString()
	{
		return displayString;
	}
	
}