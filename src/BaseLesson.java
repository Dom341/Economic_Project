import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

/**
 * class BaseLesson
 * Interface for all of the lessons
 */
public abstract class BaseLesson extends JPanel {
	
	   //
	   private static final float LABEL_FONT_SIZE = 24f;
	   private static final float FONT_SIZE = 16f;
	   private JButton next = new JButton("Next");
	   private JButton back = new JButton("Back");
	   JRadioButton rb1, rb2, rb3, rb4;
	   private Color taupe = new Color(255,255,240);
	   private Color green = new Color(0,128,0);
	   String answer;
	   public ButtonGroup group;
	   
	   /**
	    * BaseLesson()
	    * Constructor for BaseLesson
	    * 
	    * @param name
	    * @param info
	    * @param q
	    * @param m1
	    * @param m2
	    * @param m3
	    * @param m4
	    * @param img
	    * @param correct
	    */
	   public BaseLesson(String name, String info, String q, String m1, String m2, String m3, String m4, 
			   			 String img, String correct) {
	      setName(name);
	      answer = correct;
	      
	      //use absolute layout
	      setLayout(null);
	      setBackground(taupe);
	      
	      //set heading
	      JLabel label = new JLabel(getName(), SwingConstants.CENTER);
	      label.setFont(label.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
	      label.setForeground(green);
	      label.setBounds(0,0,1200,30);
	      
	      //set next button
	      next.setBounds(580,575,65,25);
	      next.setEnabled(false); //set disabled until a radio button is clicked
	      back.setBounds(520,575,65,25);
	      
	      //set image
	      URL imageURL = getClass().getResource(img);
	      Image image = getToolkit().getImage(imageURL);
	      ImageIcon icon = new ImageIcon(image);
	      JLabel imgLabel = new JLabel(icon);
	      imgLabel.setBounds(550,30,100,100);
	      
	      //set text area
	      JTextArea textArea = new JTextArea(info + q);
	      textArea.setFont(textArea.getFont().deriveFont(FONT_SIZE));
	      textArea.setLineWrap(true);
	      textArea.setWrapStyleWord(true);
	      textArea.setMargin(new Insets(10,10,10,10));
	      textArea.setEditable(false);
	      textArea.setBackground(taupe);
	      textArea.setBounds(0,125,1200,310);
	      
	      //add radio buttons
	      group = new ButtonGroup();
	      
	      rb1 = new JRadioButton(m1);
	      group.add(rb1);
	      rb1.setBackground(taupe);
	      rb1.setBounds(30,440,500,30);
	      
	      rb2 = new JRadioButton(m2);
	      group.add(rb2);
	      rb2.setBackground(taupe);
	      rb2.setBounds(30,470,500,30);
	      
	      rb3 = new JRadioButton(m3);
	      group.add(rb3);
	      rb3.setBackground(taupe);
	      rb3.setBounds(30,500,500,30);
	      
	      rb4 = new JRadioButton(m4);
	      group.add(rb4);
	      rb4.setBackground(taupe);
	      rb4.setBounds(30,530,500,30);
	      
	      //add radio button listener
	      RadioListener myListener = new RadioListener();
	      rb1.addActionListener(myListener);
	      rb2.addActionListener(myListener);
	      rb3.addActionListener(myListener);
	      rb4.addActionListener(myListener);
	      
	      //add components to the layout
	      add(label);
	      add(next);
	      add(back);
	      add(imgLabel); 
	      add(textArea);
	      add(rb1);
	      add(rb2);
	      add(rb3);
	      add(rb4); 
	   }
	   
	   /**
	    * class RadioListener
	    * Adds action listener for radio buttons
	    */
	   class RadioListener implements ActionListener {
	    	/**
	    	 * actionPerformed()
	    	 * Calls the checkCorrect() method when a radio button is clicked  
	    	 */
		   	public void actionPerformed(ActionEvent e) {
	    	  		checkCorrect();
	    	}
	   }
	   
	   /**
	    * addNextActionListener()
	    * Adds action listener for the Next button
	    * @param listener
	    */
	   public void addNextActionListener(ActionListener listener) {
	      next.addActionListener(listener);
	   }
	   
	   /**
	    * addBackActionListener()
	    * Adds action listener for the Back button
	    * @param listener
	    */
	   public void addBackActionListener(ActionListener listener) {
		  back.addActionListener(listener);
	   }
	   
	   /**
	    * checkCorrect()
	    * Checks to see if the correct radio button has been clicked 
	    * corresponding to the lesson's correct answer
	    */
	   public void checkCorrect() {
		   
		   if(rb1.isSelected()) {
			   if(rb1.getText() == answer) {
				   showCorrectDialog();
			   }
			   else
				   showIncorrectDialog();
		   }
		   else if(rb2.isSelected()) {
			   if(rb2.getText() == answer) {
				   showCorrectDialog();
			   }
			   else
				   showIncorrectDialog();
		   }
		   else if(rb3.isSelected()) {
			   if(rb3.getText() == answer) {
				   showCorrectDialog();
			   }
			   else
				   showIncorrectDialog();
		   }
		   else if(rb4.isSelected()) {
			   if(rb4.getText() == answer) {
				   showCorrectDialog();
			   }
			   else
				   showIncorrectDialog();
		   }
	   }
	   
	   /**
	    * showCorrectDialog()
	    * Gets image for the dialog box ad shows the corresponding "correct" message
	    */
	   public void showCorrectDialog() {
		   //get correct dialog box image
		   URL greenIconURL = getClass().getResource("green.png");
		   Image greenImage = getToolkit().getImage(greenIconURL);
		   ImageIcon greenIcon = new ImageIcon(greenImage);
		   
		   //show dialog box
		   JOptionPane.showMessageDialog(this,
				   "Good job!", //answer message
				   "Correct", //title bar
				   JOptionPane.INFORMATION_MESSAGE, 
				   greenIcon);
		   
		   //enable next button
		   next.setEnabled(true);
	   }
	   
	   /**
	    * showIncorrectDialog()
	    * Gets image for the dialog box ad shows the corresponding "incorrect" message
	    */
	   public void showIncorrectDialog() {
		   //get incorrect dialog box image
		   URL redIconURL = getClass().getResource("red.png");
		   Image redImage = getToolkit().getImage(redIconURL);
		   ImageIcon redIcon = new ImageIcon(redImage);
		   
		   //show dialog box
		   JOptionPane.showMessageDialog(this,
				   "Try again.", //answer message
				   "Incorrect", //title bar
				   JOptionPane.INFORMATION_MESSAGE, 
				   redIcon);
	   }
	   
	   /**
	    * resetButtons()
	    * Clears the radio button selection for when the user navigates back to the page
	    */
	   public void resetButtons() {
		   group.clearSelection();
	   }
	   
	   /**
	    * resetSlide()
	    * Resets radio buttons and the next button for when the user navigates back to the page
	    */
	   public void resetSlide() {
		   resetButtons();
		   next.setEnabled(false); //set disabled until a radio button is clicked
	   }
	}