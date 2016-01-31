// CustomerGUI 
// GUI that enables users to input customer information
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class CustomerGUI extends JFrame 
{
 	//needed instance variables
 	private Customer customer;

 	//instance variables for formatting
 	DecimalFormat dollars = new DecimalFormat("$0.00");
 
	
   // JLabel and JTextField for customer name
   private JLabel nameJLabel;
   private JTextField nameJTextField;

      // JLabel and JTextField for address
   private JLabel addressJLabel;
   private JTextField addressJTextField;

      
   // JLabel and JTextField for phone number
   private JLabel phoneJLabel;
   private JTextField phoneJTextField;
   
   // JLabel and JTextField for Customer Balance
   private JLabel balanceJLabel;
   private JTextField balanceJTextField;
   
   //JLabel and JTextField for Credit Limit
   private JLabel creditLimitJLabel;
   private JTextField creditLimitJTextField;
   
   //JScrollPane to have the text area scroll
   private JScrollPane ordersJScrollPane;
      
   //JLabel and JTextArea for Customer Orders
   private JLabel ordersJLabel;
   private JTextArea ordersJTextArea;
   
   // JButtons to save user input and clear all JTextFields
   private JButton saveJButton;
   private JButton clearJButton;
   
   //JButtons to make an order and make a payment
   private JButton internetOrderJButton;
   private JButton phoneOrderJButton;
   
   
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


	  // set up balanceJLabel
      balanceJLabel = new JLabel();
      balanceJLabel.setBounds( 16, 156, 80, 21 );
      balanceJLabel.setText( "Balance:" );
      container.add( balanceJLabel );

      // set up balanceJTextField
      balanceJTextField = new JTextField();
      balanceJTextField.setBounds( 88, 156, 80, 21 );
      balanceJTextField.setText("10");
      balanceJTextField.setEditable(false);
      container.add( balanceJTextField );
      
	  // set up creditLimitJLabel
      creditLimitJLabel = new JLabel();
      creditLimitJLabel.setBounds( 200, 156, 80, 21 );
      creditLimitJLabel.setText( "Credit Limit:" );
      container.add( creditLimitJLabel );

      // set up creditLimitJTextField
      creditLimitJTextField = new JTextField();
      creditLimitJTextField.setBounds( 280, 156, 80, 21 );
      creditLimitJTextField.setText("50");
      container.add( creditLimitJTextField );

	  //set up ordersJLabel
	  ordersJLabel = new JLabel();
	  ordersJLabel.setBounds(16,186, 80, 21);
	  ordersJLabel.setText("Orders:");
	  container.add(ordersJLabel);
	  
	  //set up ordersJTextArea
	  ordersJTextArea = new JTextArea();
	  ordersJTextArea.setEditable(false);
	  
	  //set up the ordersJScrollPane
	  ordersJScrollPane = new JScrollPane(ordersJTextArea);
	  ordersJScrollPane.setBounds(16,210,420,200);
	  container.add(ordersJScrollPane);
	  
	  //set up internetOrderJButton
	  internetOrderJButton = new JButton();
	  internetOrderJButton.setBounds(15, 425, 75,23);
	  internetOrderJButton.setText("Online");
	  internetOrderJButton.setEnabled(false);
	  container.add(internetOrderJButton);
	  internetOrderJButton.addActionListener(
	  	new ActionListener()
	  	{
	  		public void actionPerformed(ActionEvent event)
	  		{
	  			internetOrderJButtonActionPerformed(event);
			}
		}
	   );
	  //set up phoneOrderJButton
	  phoneOrderJButton = new JButton();
	  phoneOrderJButton.setBounds(90, 425, 75,23);
	  phoneOrderJButton.setText("Phone");
	  phoneOrderJButton.setEnabled(false);
	  container.add(phoneOrderJButton);
	  phoneOrderJButton.addActionListener(
	  	new ActionListener()
	  	{
	  		public void actionPerformed(ActionEvent event)
	  		{
	  			phoneOrderJButtonActionPerformed(event);
			}
		}
	   );
	  
 
      // set up saveJButton
      saveJButton = new JButton();
      saveJButton.setBounds( 298, 425, 75, 23 );
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
      clearJButton.setBounds( 373, 425, 75, 23 );
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
      setTitle( "Customer" ); 		// set title bar text
      setSize( 500,500 );        // set window size
      setVisible( true );         // display window

   } // end method createUserInterface

	public void internetOrderJButtonActionPerformed(ActionEvent event)
	{
		InternetGUI internetGUIFrame = new InternetGUI(this, customer);
		internetGUIFrame.setSize(500,300);
		internetGUIFrame.setTitle("Internet Order for " + customer.getName());
		internetGUIFrame.setVisible(true);
	}
	public void phoneOrderJButtonActionPerformed(ActionEvent event)
	{  
		PhoneGUI phoneGUIFrame = new PhoneGUI(this, customer);
		phoneGUIFrame.setSize(500,300);
		phoneGUIFrame.setTitle("Phone Order for " + customer.getName());
		phoneGUIFrame.setVisible(true);
	}

	public void saveJButtonActionPerformed(ActionEvent event) 
	{	if (nameJTextField.getText().equals("") || addressJTextField.getText().equals("") 
			|| phoneJTextField.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Please enter all data for Customer",
			"Missing Information", JOptionPane.ERROR_MESSAGE);
			nameJTextField.requestFocusInWindow();
		}
		else
		{  String custName = nameJTextField.getText();
		   String address = addressJTextField.getText();
		   String phone = phoneJTextField.getText();
		   double creditLimit = Double.parseDouble(creditLimitJTextField.getText());
		   double balance = Double.parseDouble(balanceJTextField.getText());
		   
		   customer = new Customer(custName, address,phone, creditLimit, balance);
		   balanceJTextField.setText(String.valueOf((customer.getBalance())));
		   writeCustomertoFile();
		   phoneOrderJButton.setEnabled(true);
		   internetOrderJButton.setEnabled(true);
		   saveJButton.setEnabled(false);

		 }
	}
	
	public void writeCustomertoFile()
	{
				try{
		     	   	CustomerDA myFile = new CustomerDA(customer);
		   			myFile.writeData();
		   		}  
	 		
		   		catch(IOException e) {
				JOptionPane.showMessageDialog(null, e,
				"File Error", JOptionPane.ERROR_MESSAGE);
				}	

	}
	
	public void clearJButtonActionPerformed(ActionEvent event)
	{
		nameJTextField.setText("");
		addressJTextField.setText("");
		phoneJTextField.setText("");
		creditLimitJTextField.setText("");
		balanceJTextField.setText("");
		ordersJTextArea.setText("");
		saveJButton.setEnabled(true);
		internetOrderJButton.setEnabled(false);
		phoneOrderJButton.setEnabled(false);
	}		
	

	public void setBalanceJTextField()
	{
		balanceJTextField.setText(dollars.format(customer.getBalance()));
	}	
	public void setOrderJTextArea(String stuff)
	{
		ordersJTextArea.append("\n" + stuff);
	}		
	// main method
	
   public static void main( String[] args )
   {
      CustomerGUI application = new CustomerGUI();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   } // end method main

} 

