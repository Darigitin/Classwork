public class HangmanUser 
{

	String user;
	char level;
	int score;
	
	public HangmanUser(String aUser, char aLevel)
	{
		setUser(aUser);
		setLevel(aLevel);
	}
	
	public void setUser(String aUser)
	{
		user = aUser;
	}

	public void setScore(int aScore)
	{   score = aScore;
	}

	public void setLevel(char aLevel)
	{
		level = aLevel;
	}
	
	public String getUser()
	{
		return user;	
	}
	
	public int getScore()
	{
		return score;
	}
	
	public char getLevel()
	{
		return level;
	}
	
	public String toString()
	{
		String info = getUser() + " " +  getLevel() + " " + getScore();
		return info;
	}
}

	
		
