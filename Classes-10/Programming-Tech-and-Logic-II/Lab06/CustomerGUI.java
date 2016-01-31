// CustomerGUI 
// GUI that enables users to input customer information
//*****Your assignment is to add the customer balance and credit limit to the gui
//*****And to write the code for the Save button.
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CustomerGUI extends JFrame 
{
 	//needed instance variables
 	Customer customer;
 	
  
	
   // JLabel and JTextField for customer name
   private JLabel nameJLabel;
   private JTextField nameJTextField;

      // JLabel and JTextField for address
   private JLabel addressJLabel;
   private JTextField addressJTextField;

      
   // JLabel and JTextField for phone number
   private JLabel phoneJLabel;
   private JTextField phoneJTextField;
   
   private JLabel creditLimitJLabel;
   private JTextField creditLimitJTextField;
   
   private JLabel custBalanceJLabel;
   private JTextField custBalanceJTextField;
   
   //JLabel and JTextArea for Customer Orders
   private JLabel customerJLabel;
   private JTextArea customerJTextArea;
   
   // JButtons to save user input and clear all JTextFields
   private JButton saveJButton;
   private JButton clearJButton;
   
     
   // no-argument constructor
   public CustomerGUI()
   {
      createUserInterface();
   }

   // create and position GUI components
   public void createUserInterface()
   {
      // get content pane and set its layout
      Container container = getContentPane();
      container.setLayout( null );

      // set up nameJLabel
      nameJLabel = new JLabel();
      nameJLabel.setBounds( 16, 36, 64, 21 );
      nameJLabel.setText( "Name:" );
      container.add( nameJLabel );

      // set up nameJTextField
      nameJTextField = new JTextField();
      nameJTextField.setBounds( 88, 36, 134, 21 );
      nameJTextField.setText( "John" );
      container.add( nameJTextField );

      // set up addressJLabel
      addressJLabel = new JLabel();
      addressJLabel.setBounds( 16, 76, 64, 21 );
      addressJLabel.setText( "Address:" );
      container.add( addressJLabel );

      // set up addressJTextField
      addressJTextField = new JTextField();
      addressJTextField.setBounds( 88, 76, 360, 21 );
      addressJTextField.setText( "123 Main Street" );
      container.add( addressJTextField );

      
      // set up phoneJLabel
      phoneJLabel = new JLabel();
      phoneJLabel.setBounds( 16, 116, 40, 21 );
      phoneJLabel.setText( "Phone:" );
      container.add( phoneJLabel );

      // set up phoneJTextField
      phoneJTextField = new JTextField();
      phoneJTextField.setBounds( 88, 116, 112, 21 );
      phoneJTextField.setText( "781-555-4567" );
      container.add( phoneJTextField );
      
      creditLimitJLabel = new JLabel();
      creditLimitJLabel.setBounds( 16, 156, 74, 21 );
      creditLimitJLabel.setText( "Credit Limit:" );
      container.add( creditLimitJLabel );
      
      creditLimitJTextField = new JTextField();
      creditLimitJTextField.setBounds ( 92, 156, 112, 21 );
      creditLimitJTextField.setText ( "100000" );
      container.add( creditLimitJTextField );
      
      custBalanceJLabel = new JLabel ();
      custBalanceJLabel.setBounds( 16, 196, 124, 21 );
      custBalanceJLabel.setText( "Customer Balance:" );
      container.add( custBalanceJLabel );
      
      custBalanceJTextField = new JTextField();
      custBalanceJTextField.setBounds ( 130, 196, 112, 21);
      custBalanceJTextField.setText ( "50000" );
      container.add( custBalanceJTextField );


	  //set up customerJLabel
	  customerJLabel = new JLabel();
	  customerJLabel.setBounds(16,236, 80, 21);
	  customerJLabel.setText("Customer:");
	  container.add(customerJLabel);
	  
	  //set up customerJTextArea
	  customerJTextArea = new JTextArea();
	  customerJTextArea.setBounds(88,236,300,80);
	  customerJTextArea.setEditable(false);
	  container.add(customerJTextArea);
	  

      // set up saveJButton
      saveJButton = new JButton();
      saveJButton.setBounds( 298, 330, 75, 23 );
      saveJButton.setText( "Save" );
      container.add( saveJButton );
	  saveJButton.addActionListener(
	  	new ActionListener()
	  	{
	  		public void actionPerformed(ActionEvent event)
	  		{
	  			saveJButtonActionPerformed(event);
			}
		}
	   );

      // set up clearJButton
      clearJButton = new JButton();
      clearJButton.setBounds( 373, 330, 75, 23 );
      clearJButton.setText( "Clear" );
      container.add( clearJButton );
   	  clearJButton.addActionListener(
	  	new ActionListener()
	  	{
	  		public void actionPerformed(ActionEvent event)
	  		{
	  			clearJButtonActionPerformed(event);
			}
		}
	   );


      // set properties of application’s window
      setTitle( "Customer ");
      setSize( 500,400 );        // set window size
      setVisible( true );         // display window

   } // end method createUserInterface

	public void saveJButtonActionPerformed(ActionEvent event)
	{
		customer = new Customer(nameJTextField.getText(), addressJTextField.getText(), phoneJTextField.getText(), Double.parseDouble( custBalanceJTextField.getText()), Double.parseDouble ( creditLimitJTextField.getText()));
		customerJTextArea.setText(customer.toString());
		saveJButton.setEnabled(false);
	}
	public void clearJButtonActionPerformed(ActionEvent event)
	{
		nameJTextField.setText("");
		addressJTextField.setText("");
		phoneJTextField.setText("");
		creditLimitJTextField.setText("");
		custBalanceJTextField.setText("");
		customerJTextArea.setText("");
		saveJButton.setEnabled(true);
	}		
	

	
   public static void main( String[] args )
   {
      CustomerGUI application = new CustomerGUI();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} 

