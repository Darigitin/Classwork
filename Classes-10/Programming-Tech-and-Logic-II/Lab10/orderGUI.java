// orderGUI
// standard order GUI that enables users to input order information - use to inherit from 
import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public abstract class orderGUI extends JFrame 
{
 	//instance variables
 	protected Customer customer;
 	protected CustomerGUI customerWindow;
 	
 	//instance variables for dates
 	protected Calendar aCalendar = Calendar.getInstance();
 	protected Date today = aCalendar.getTime();

 	 	
 	// instance variables for formatting
 	protected DecimalFormat dollars = new DecimalFormat("$0.00");
	protected DecimalFormat percent = new DecimalFormat("#0%");
  	protected DateFormat shortFormat = DateFormat.getDateInstance(DateFormat.SHORT);
  	
  	 // get content pane and set its layout
     protected Container container = getContentPane();
    

   // JLabel and JTextField for order number
   protected JLabel orderNumberJLabel;
   protected JTextField orderNumberJTextField;

      // JLabel and JTextField for order date
   protected JLabel orderDateJLabel;
   protected JTextField orderDateJTextField;

  
   // JLabel and JTextField for order amount
   protected JLabel orderAmountJLabel;
   protected JTextField orderAmountJTextField;
   
   // JLabel and JTextField for order price
   protected JLabel orderPriceJLabel;
   protected JTextField orderPriceJTextField;
   
   
   //JLabel and JTextField for orderTotal
   protected JLabel orderTotalJLabel;
   protected JTextField orderTotalJTextField;
   
   
    
   // JButtons to save user input and clear all JTextFields
   protected JButton saveJButton;
   protected JButton clearJButton;
   
  
   
   // no-argument constructor
   public orderGUI(CustomerGUI returnWindow, Customer aCustomer)
   {
      customer = aCustomer;
      customerWindow = returnWindow;
      createUserInterface();
   }

   // create and position GUI components
   public void createUserInterface()
   {
 
	 container.setLayout( null );
  	  
      // set up orderNumberJLabel
      orderNumberJLabel = new JLabel();
      orderNumberJLabel.setBounds( 16, 36, 64, 21 );
      orderNumberJLabel.setText( "Number:" );
      container.add( orderNumberJLabel );

      // set up orderNumberJTextField
      orderNumberJTextField = new JTextField();
      orderNumberJTextField.setBounds( 88, 36, 50, 21 );
      orderNumberJTextField.setText("");
      container.add( orderNumberJTextField );

      // set up orderDateJLabel
      orderDateJLabel = new JLabel();
      orderDateJLabel.setBounds( 150, 36, 64, 21 );
      orderDateJLabel.setText( "Date:" );
      container.add( orderDateJLabel );

      // set up orderDateJTextField
      orderDateJTextField = new JTextField();
      orderDateJTextField.setBounds( 200, 36, 80, 21 );
      orderDateJTextField.setEnabled(false);
      orderDateJTextField.setText(shortFormat.format(today));
      container.add( orderDateJTextField );


     
      
      // set up orderAmountJLabel
      orderAmountJLabel = new JLabel();
      orderAmountJLabel.setBounds( 16, 116, 64, 21 );
      orderAmountJLabel.setText( "Amount:" );
      container.add( orderAmountJLabel );

      // set up orderAmountJTextField
      orderAmountJTextField = new JTextField();
      orderAmountJTextField.setBounds( 88, 116, 50, 21 );
      orderAmountJTextField.setText( "" );
      container.add( orderAmountJTextField );


	  // set up orderPriceJLabel
      orderPriceJLabel = new JLabel();
      orderPriceJLabel.setBounds( 176, 116, 80, 21 );
      orderPriceJLabel.setText( "Price:" );
      container.add( orderPriceJLabel );

      // set up orderPriceJTextField
      orderPriceJTextField = new JTextField();
      orderPriceJTextField.setBounds( 250, 116, 50, 21 );

      container.add( orderPriceJTextField );
      
      //set up orderTotalJLabel
      orderTotalJLabel = new JLabel();
      orderTotalJLabel.setBounds(16, 216, 80, 21);
      orderTotalJLabel.setText("Total:");
      container.add(orderTotalJLabel);
      
      //set up orderTotalJTextField
      orderTotalJTextField = new JTextField();
      orderTotalJTextField.setBounds(88,216, 50, 21);
      orderTotalJTextField.setEditable(false);
      container.add(orderTotalJTextField);
      
	   
      // set up saveJButton
      saveJButton = new JButton();
      saveJButton.setBounds( 298, 216, 75, 23 );
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
      clearJButton.setBounds( 373, 216, 75, 23 );
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
 
   } // end method createUserInterface

	public abstract void saveJButtonActionPerformed(ActionEvent event);
	
	public void writeOrderstoFile()
	{	  try{
		  	   	CustomerDA myFile = new CustomerDA(customer);
		  		myFile.writeOrders();
		  }  
	   		
		   		catch(IOException e) {
				JOptionPane.showMessageDialog(null, e,
				"File Error", JOptionPane.ERROR_MESSAGE);
		 }	

	}
	
	public void clearJButtonActionPerformed(ActionEvent event)
	{
		orderNumberJTextField.setText("");
		orderAmountJTextField.setText("");
		orderPriceJTextField.setText("");
	}		
	public void shutDown()
	{
		customerWindow.setVisible(true);
		this.dispose();		
	}

} 

