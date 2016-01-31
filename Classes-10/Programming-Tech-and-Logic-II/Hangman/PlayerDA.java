import java.io.*;

public class PlayerDA
{
	private HangmanUser player;
	
	
	public PlayerDA(HangmanUser aPlayer) throws IOException
	{
		player = aPlayer;
		writeData();

	}
	
	public void writeData() throws IOException
	{		
		FileWriter outData = new FileWriter("Player.txt", true);
	
		PrintWriter outFile = new PrintWriter(outData);

		
		outFile.println(player);
		
		outFile.close();
	}
	
	
}			
		
	