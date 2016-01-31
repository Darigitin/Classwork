///Miles-per-Gallon

import javax.swing.JOptionPane;

public class Miles
{
	public static void main(String args[])
	{
		String inputString;
		double miles;
		double gallons;
		double mpg;
		
		inputString = JOptionPane.showInputDialog("How many miles have you driven?");
		
		miles = Double.parseDouble(inputString);
		
		inputString = JOptionPane.showInputDialog("How many gallons have you used?");
		
		gallons = Double.parseDouble(inputString); 
		
		mpg = miles / gallons;
		
		JOptionPane.showMessageDialog(null, "Your car's miles per gallon is " +mpg);
		
		System.exit(0);
	}
}
