import.javax.swing.JOptionPane;

public class PigLatin
{
	public static void main(String args [])
	{
		String word;
		char letter;
		
		word = JOptionPane.showinputDialog("Give me a word");
		letter = word.chartAt(0);
		
	}
}
