// internetGUI
// GUI that enables users to input internet order information
import java.util.*;
import java.text.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InternetGUI extends orderGUI 
{
   //JLabel and JTextField for customer email
   private JLabel emailJLabel;
   private JTextField emailJTextField;
   
   
   
   private InternetOrder morder;
   
   public InternetGUI(CustomerGUI returnWindow, Customer aCustomer)
   {
	  super(returnWindow, aCustomer);

      createInternetUserInterface();
   }

   // create and position GUI components
   public void createInternetUserInterface()
   {
  
       
       //set up emailJLabel
      emailJLabel = new JLabel();
      emailJLabel.setBounds(300, 36, 80,21);
      emailJLabel.setText("email:");
      container.add(emailJLabel);
		
	  //set up postMarkDateJTextField
	  emailJTextField = new JTextField();
	  emailJTextField.setBounds(350,36, 120,21);
	  container.add(emailJTextField);
     
  
   } // end method createUserInterface */
   

	public void saveJButtonActionPerformed(ActionEvent event) 
	{  if (orderNumberJTextField.getText().equals("") || 
		   orderDateJTextField.getText().equals("") ||
		   emailJTextField.getText().equals("") ||		   
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
			String custEmail = emailJTextField.getText();
			try {
				morder = new InternetOrder(orderNumber, orderDate,orderAmount, orderPrice, customer, custEmail);
			
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

