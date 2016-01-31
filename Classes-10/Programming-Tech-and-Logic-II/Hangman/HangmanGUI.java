import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;

public class HangmanGUI extends JFrame 
{	
	private HangmanDA hangDa;
	private HangmanUser hangUser;
	private Hangman hang;
	private PlayerDA playerDa;
	private char level;
	private Integer score;
	private int rightGuesses;
	private	int wrongGuesses;
	private	int guesses = 500;
	private String player;
	private JLabel userJLabel;
	private JTextField userJTextField;
   
	private ButtonGroup levelButtonGroup;
	private JRadioButton easyJRadioButton;
	private JRadioButton mediumJRadioButton;
	private JRadioButton hardJRadioButton;
   
   
    private JLabel levelJLabel;
    private JTextField levelJTextField;
    private JLabel scoreJLabel;
    private JTextField scoreJTextField;
   
	private JLabel targetJLabel;
	private JTextField targetJTextField;
	private JLabel imageJLabel;
	private JLabel messageJLabel;
	private JTextField messageJTextField;
	private JTextField statusJTextField;
	private JButton newGameJButton;
	private JButton guessJButton;
	private JButton saveJButton;
	private JButton resetJButton;
	
	public HangmanGUI() 
    {
      createUserInterface();
    }
	
	public void createUserInterface()
    {
   	  // get content pane for attaching GUI components
   	  Container contentPane = getContentPane();
   	  
   	  // enable explicit positioning of GUI components
      contentPane.setLayout( null ); 
      	
      userJLabel = new JLabel("Enter Name:");
      userJLabel.setBounds(100, 30, 80,21);
      contentPane.add(userJLabel);
		  
	  userJTextField = new JTextField("Player 1");
	  userJTextField.setBounds(200,30, 120,21);
	  userJTextField.requestFocusInWindow();
	  contentPane.add(userJTextField);
	  
      levelJLabel = new JLabel("Select Level:");
      levelJLabel.setBounds(100, 60, 80,21);
      contentPane.add(levelJLabel);		
      	
      levelButtonGroup = new ButtonGroup();
	  
	  easyJRadioButton = new JRadioButton("Easy"); 
      easyJRadioButton.setBounds( 200,60, 100,21);
      easyJRadioButton.setSelected( true );
      levelButtonGroup.add(easyJRadioButton);
      contentPane.add(easyJRadioButton);
      easyJRadioButton.setActionCommand("easy.txt");
      
      mediumJRadioButton = new JRadioButton("Medium"); 
      mediumJRadioButton.setBounds( 300,60, 100,21);
      levelButtonGroup.add(mediumJRadioButton);
      contentPane.add(mediumJRadioButton);
      mediumJRadioButton.setActionCommand("medium.txt");
      
      hardJRadioButton = new JRadioButton("Hard"); 
      hardJRadioButton.setBounds( 400,60, 100,21);
      levelButtonGroup.add(hardJRadioButton);
      contentPane.add(hardJRadioButton);
      hardJRadioButton.setActionCommand("hard.txt");
      

   
	  
	  
	  scoreJLabel = new JLabel("Score");
      scoreJLabel.setBounds(100, 90, 80,21);
      contentPane.add(scoreJLabel);		
	  
	  scoreJTextField = new JTextField(null);
	  scoreJTextField.setBounds(200,90, 120,21);
	  scoreJTextField.setEnabled(false);
	  contentPane.add(scoreJTextField);
 	
          
      targetJLabel = new JLabel("Word");
      targetJLabel.setBounds( 600, 150, 200, 20);
      contentPane.add( targetJLabel);
      
      targetJTextField = new JTextField();
      targetJTextField.setBounds(600, 175, 50, 25);
      targetJTextField.setEnabled(false);
      contentPane.add( targetJTextField);
       	        
	  messageJLabel = new JLabel("Enter a Letter.");
	  messageJLabel.setBounds(600,200, 100, 25);
	  contentPane.add(messageJLabel);
	  
	  messageJTextField = new JTextField();
	  messageJTextField.setBounds(600, 230, 70, 25);
	  contentPane.add(messageJTextField);
	  
	  statusJTextField = new JTextField("Please enter a name and select a level, or leave the defaults.");
	  statusJTextField.setBounds(100, 140, 350, 25);
	  statusJTextField.setEnabled(false);
	  contentPane.add(statusJTextField);
	  
      //set up imageJLabel
      imageJLabel = new JLabel();
      imageJLabel.setBounds( 25, 90, 480, 600);
      imageJLabel.setIcon(new ImageIcon("Hangman01.gif"));
      contentPane.add( imageJLabel );
      
      newGameJButton = new JButton("New Game");
      newGameJButton.setBounds( 600, 50, 100, 24 );
      contentPane.add( newGameJButton );
      
      newGameJButton.addActionListener(
      new ActionListener() // anonymous inner class
      {
         public void actionPerformed( ActionEvent event )
         {
		 	  newGameJButtonActionPerformed( event );
         }
       } // end anonymous inner class
      ); // end call to addActionListener
      
      guessJButton = new JButton("Guess");
      guessJButton.setBounds(600, 75, 100, 24);
      guessJButton.setEnabled(false);
      contentPane.add(guessJButton);
      
      saveJButton = new JButton("Save");
      saveJButton.setBounds(600, 100, 100, 24);
      saveJButton.setEnabled(false);
      contentPane.add(saveJButton);
      
      resetJButton = new JButton("Reset");
      resetJButton.setBounds(600, 125, 100, 24);
      contentPane.add(resetJButton);
      
      guessJButton.addActionListener(
      new ActionListener()
      {
      		public void actionPerformed( ActionEvent event )
      		{
      			guessJButtonActionPerformed( event );
      		}
      }
     );
      saveJButton.addActionListener(
      new ActionListener()
      {
      		public void actionPerformed(ActionEvent event)
			{
				saveJButtonActionPerformed(event);
			}
	  }
 	 );
 	 resetJButton.addActionListener(
 	 new ActionListener()
 	 {
 	 	public void actionPerformed( ActionEvent event)
 	 	{
 	 		resetJButtonActionPerformed( event );
 	 	}
 	 }
 	);
      
      
      
      // set properties of application’s window
      setTitle( "Hangman" ); 		// set title bar text
      setSize( 800,600 );          // set window size
      setVisible( true );         // display window
   }
	
	private void newGameJButtonActionPerformed( ActionEvent event ) 
	{
		userJTextField.setEnabled(false);
		
		player = getPlayerName();
		level = setLevel();
		newGameJButton.setEnabled(false);
		guessJButton.setEnabled(true);
		hangUser = new HangmanUser(player, level);
		hang = new Hangman(hangDa.getTargetPhrase());
		targetJTextField.setText(hang.getDisplayString());
		messageJTextField.requestFocusInWindow();
		messageJTextField.setEnabled(true);
		
	}
	
	private void guessJButtonActionPerformed( ActionEvent event)
	{
		messageJTextField.requestFocusInWindow();
		if (messageJTextField.getText().length() == 1)
		{
			guesses = hang.searchTarget(messageJTextField.getText().charAt(0));
			if (guesses == 0)
			{
				rightGuesses++;
				targetJTextField.setText(hang.getDisplayString());
				statusJTextField.setText("You guessed right. Wrong Guesses: " + wrongGuesses);
				messageJTextField.setText(null);
				
				if (hang.getTargetString().length() == rightGuesses)
				{
					statusJTextField.setText("You have won!!! Hit save to save your score.");
					messageJTextField.setEnabled(false);
					guessJButton.setEnabled(false);
					saveJButton.setEnabled(true);
					
					if (wrongGuesses > 0)
					{	
						score = new Integer(100/wrongGuesses);
					}
					else
					{
						wrongGuesses = 1;
						score = new Integer(100/wrongGuesses);
					}
					scoreJTextField.setText(score.toString());
				}
			}
			else if (guesses == -1)
			{
				 if (wrongGuesses == 0)
				 {
					wrongGuesses++;
					statusJTextField.setText("You have guessed wrong. Wrong Guesses: " + wrongGuesses);
					imageJLabel.setIcon(new ImageIcon("Hangman02.gif"));
					messageJTextField.setText(null);
				}
				else if (wrongGuesses == 1)
				{
					wrongGuesses++;
					statusJTextField.setText("You have guessed wrong. Wrong Guesses: " + wrongGuesses);
					imageJLabel.setIcon(new ImageIcon("Hangman03.gif"));
					messageJTextField.setText(null);
				}
				else if (wrongGuesses == 2)
				{
					wrongGuesses++;
					statusJTextField.setText("You have guessed wrong. Wrong Guesses: " + wrongGuesses);
					imageJLabel.setIcon(new ImageIcon("Hangman04.gif"));
					messageJTextField.setText(null);
				}
				else if (wrongGuesses == 3)
				{
					wrongGuesses++;
					statusJTextField.setText("You have guessed wrong. Wrong Guesses: " + wrongGuesses);
					imageJLabel.setIcon(new ImageIcon("Hangman05.gif"));
					messageJTextField.setText(null);
				}
				else if (wrongGuesses == 4)
				{
					wrongGuesses++;
					statusJTextField.setText("YOU LOSE!! Hit save if you want to save your score");
					imageJLabel.setIcon(new ImageIcon("Hangman06.gif"));
					messageJTextField.setEnabled(false);
					guessJButton.setEnabled(false);
					saveJButton.setEnabled(true);
				}
			}
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Enter a Guess",
			"Missing Information", JOptionPane.ERROR_MESSAGE);
		}	
	}
	
	private void saveJButtonActionPerformed(ActionEvent event)
	{
		hangUser.setScore(score);
		try{
		       playerDa = new PlayerDA(hangUser);
		   }
		   		catch(IOException e) {
				JOptionPane.showMessageDialog(null, e,
				"File Error", JOptionPane.ERROR_MESSAGE);
				}
		userJTextField.setEnabled(true);
		newGameJButton.setEnabled(true);
		userJTextField.setText("Player 1");
		easyJRadioButton.setSelected(true);
		guessJButton.setEnabled(false);
		targetJTextField.setText(null);
		messageJTextField.setText(null);
		statusJTextField.setText("Please enter a name and select a level, or leave the defaults.");
	}
	private void resetJButtonActionPerformed(ActionEvent event)
	{
		newGameJButton.setEnabled(true);
		userJTextField.setText("Player 1");
		easyJRadioButton.setSelected(true);
		guessJButton.setEnabled(false);
		targetJTextField.setText(null);
		messageJTextField.setText(null);
		statusJTextField.setText("Please enter a name and select a level, or leave the defaults.");
		userJTextField.setEnabled(true);
	}
   public static void main( String[] args )
   {
      HangmanGUI application = new HangmanGUI();
      application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

   }
   
   public String getPlayerName()
   {
   		String player = "Player 1";
   		if (userJTextField.getText().equals("Player 1"))
   		{
   			return player;
   		}
   		else
   		{
   			player = userJTextField.getText();
   		}
   		return player;
   }
   public char setLevel()
   {
   		char level = '0';
   		if (easyJRadioButton.isSelected())
   		{
   			level = '1';
   			try{
		     	   	hangDa = new HangmanDA("easy.txt");
		   		}  
	 		
		   		catch(IOException e) {
				JOptionPane.showMessageDialog(null, e,
				"File Error", JOptionPane.ERROR_MESSAGE);
				}
   		}
   		else if (mediumJRadioButton.isSelected())
   		{
   			level = '2';
   			try{
		     	   	hangDa = new HangmanDA("medium.txt");
		   		}  
	 		
		   		catch(IOException e) {
				JOptionPane.showMessageDialog(null, e,
				"File Error", JOptionPane.ERROR_MESSAGE);
				}	
   			
   		}
   		else
   		{
   			level = '3';
   			try{
		     	   	hangDa = new HangmanDA("hard.txt");
		   		}  
	 		
		   		catch(IOException e) {
				JOptionPane.showMessageDialog(null, e,
				"File Error", JOptionPane.ERROR_MESSAGE);
				}
   		}
   		return level;
   }

}
