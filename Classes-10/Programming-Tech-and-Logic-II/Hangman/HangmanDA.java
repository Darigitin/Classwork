import java.io.*;
import java.util.*;  //needed for files
public class HangmanDA
{
	String[] phrase = new String[100];
	String targetPhrase;
	
	
	public HangmanDA(String filename) throws FileNotFoundException
	{	int size;
		size = loadPhrases(filename);
		setTargetPhrase(size);
	}
	
	public int loadPhrases(String filename) throws FileNotFoundException
	{
		 Scanner inFile = new Scanner(new FileReader(filename));
		 
		 int sub = 0;

	
  	     while(inFile.hasNext())
		 {
			
			phrase[sub] = inFile.next(); 
			sub++;
		  
		 }		  
		  
		 inFile.close();
		 return sub;
	
	}
	
	public void setTargetPhrase(int size)
	{
		Random randomObject = new Random();              
		int randomNumber = randomObject.nextInt(size);
		targetPhrase = phrase[randomNumber];
		
	}
	
	public String getTargetPhrase()
	{
		return targetPhrase;
	}

	
		
}