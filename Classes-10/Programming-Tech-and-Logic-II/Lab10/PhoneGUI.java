import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PhoneGUI extends orderGUI 
{
   private JLabel callRepJLabel;
   private JTextField callRepJTextField;
   private JLabel callDurationJLabel;
   private JTextField callDurationJTextField;
   
   
   
   private PhoneOrder morder;
   
   public PhoneGUI(CustomerGUI returnWindow, Customer aCustomer)
   {
	  super(returnWindow, aCustomer);

      createPhoneUserInterface();
   }

   // create and position GUI components
   public void createPhoneUserInterface()
   {
  
      callRepJLabel= new JLabel();
      callRepJLabel.setBounds(300, 36, 80,21);
      callRepJLabel.setText("Call Rep:");
      container.add(callRepJLabel);
		
	  callRepJTextField = new JTextField();
	  callRepJTextField.setBounds(350,36, 120,21);
	  container.add(callRepJTextField);
	  
	  callDurationJLabel = new JLabel();
	  callDurationJLabel.setBounds(275, 80, 80, 21);
	  callDurationJLabel.setText("Call Duration:");
	  container.add(callDurationJLabel);
	  
	  callDurationJTextField = new JTextField();
	  callDurationJTextField.setBounds(350, 80, 120, 21);
	  container.add(callDurationJTextField);
     
  
   } // end method createUserInterface */
   

	public void saveJButtonActionPerformed(ActionEvent event) 
	{  if (orderNumberJTextField.getText().equals("") || 
		   orderDateJTextField.getText().equals("") ||
		   callRepJTextField.getText().equals("") ||		   
	       orderAmountJTextField.getText().equals("") ||
	       orderPriceJTextField.getText().equals(""))
	    {
	        JOptionPane.showMessageDialog(null, "Please enter all data for Order",
			"Missing Information", JOptionPane.ERROR_MESSAGE);
			orderNumberJTextField.requestFocusInWindow();
		}
		else 
		{
			double orderTotal = 0;
			int orderNumber = Integer.parseInt(orderNumberJTextField.getText());
			Date orderDate = today;
			int orderAmount = Integer.parseInt(orderAmountJTextField.getText());
			double orderPrice = Double.parseDouble(orderPriceJTextField.getText());
			String callRep = callRepJTextField.getText();
			int callDuration = Integer.parseInt(callDurationJTextField.getText());
			try {
				morder = new PhoneOrder(orderNumber, orderDate, orderAmount, orderPrice, customer, callRep, callDuration);
			
				orderTotal = morder.calcOrderTotal();
				orderTotalJTextField.setText(dollars.format(orderTotal));
				boolean ok = customer.checkLimit(orderTotal + customer.getBalance());
				if (!ok)
				{
					 JOptionPane.showMessageDialog(null, "Credit Limit Exceeded - cannot process order",
					"CreditLimitExceeded", JOptionPane.ERROR_MESSAGE);
					int orderSize = customer.getOrder().size();
					
					customer.getOrder().remove(orderSize-1);
				} else
				{
				
				customer.updateBalance(orderTotal);
				customerWindow.setBalanceJTextField();
				customerWindow.setOrderJTextArea(morder + "Order Total:" + dollars.format(orderTotal));
				super.writeOrderstoFile();
				}
			}
			catch(AmountOrderedException e)
			{
				JOptionPane.showMessageDialog(null, e,
				"AmountOrderedException", JOptionPane.ERROR_MESSAGE);
			}	
			catch(Exception e)	
			{
				JOptionPane.showMessageDialog(null, e,
				"AmountOrderedException", JOptionPane.ERROR_MESSAGE);

			}		
	    }												
			
	}

} 

