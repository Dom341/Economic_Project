import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class SimulatorStart extends JPanel {

	   private static final int WIDTH = 1200;
	   private static final int HEIGHT = 700;
	   private static final int BWIDTH = 200;
	   private static final int BHEIGHT = 100;
	   private static final int LWIDTH = 1000;
	   private static final int LHEIGHT = 300;

	   Font lFont = new Font("Calibri", Font.BOLD, 30);
	   Font bFont = new Font("Calibri", Font.BOLD, 15);

	   private static final String INTRO_TEXT = "You are about to start a simulation "
	   		+ "that is modeled after real-world situations. Over the course of five "
	   		+ "years, you will have to invest money wisely in order to by 12 \"stuff.\" "
	   		+ "There are four investments that you can choose: The Bank, Toys Inc., "
	   		+ "Candy Corp. and Pet Co. Be sure to research the firms by clicking "
	   		+ "\"info,\" checking their risk and returns. In order to invest in a company, "
	   		+ "enter the amount you want to invest into the text box below their name "
	   		+ "and click invest. Once you are done with your investments, click \"See "
	   		+ "Results\" to see how you performed and move forward one year.";
	   private static final String GOOD_LUCK_TEXT = "That's it! You're ready to go! Good luck!";
	  
	   private JButton startSim = new JButton("Begin");
	   private JButton goBack = new JButton("Back to Intro Screen");
	   private Color taupe = new Color(255,255,240);
	   private Color green = new Color(0,128,0);

	   /**
	    * SimulatorStart()
	    * Constructor for the SimulatorStart class
	    */
	   public SimulatorStart() {
	      setName("INVEST START");
	      initUI();
	   }

	   public void initUI()
	   {
		   	  //set null layout
		      setLayout(null);
		      setBackground(taupe);
		      
		      //set heading text
		      JLabel label = new JLabel("Let's Start Investing!", SwingConstants.CENTER);
		      label.setFont(label.getFont().deriveFont(Font.BOLD, 50));
		      label.setForeground(green);
		      label.setBounds(0,50,1200,60);

	          //set Intro Text description
	          JTextArea introText = new JTextArea(INTRO_TEXT);
	  		  introText.setFont(lFont);
	  		  introText.setLineWrap(true);
	  		  introText.setWrapStyleWord(true);
	  		  introText.setEditable(false);
	  		  introText.setBackground(taupe);
		      introText.setBounds(WIDTH/2-LWIDTH/2,HEIGHT/2-200,LWIDTH,LHEIGHT);
		      
		      //set good luck text
		      JLabel goodLuckLabel = new JLabel(GOOD_LUCK_TEXT, SwingConstants.CENTER);
		      goodLuckLabel.setFont(label.getFont().deriveFont(Font.BOLD, 25));
		      goodLuckLabel.setForeground(green);
		      goodLuckLabel.setBounds(0,550,1200,60);
		      
		      //set Buttons
		      startSim.setBounds(600,620,175,50);
	  		  startSim.setFont(bFont);
		      goBack.setBounds(425,620,175,50);
	  		  goBack.setFont(bFont);

	  		  //add Everything to null layout
		      add(startSim);
		      add(label);
		      add(goodLuckLabel);
		      add(goBack);
		      add(introText);
	   }

	   public void addNextActionListener(ActionListener listener) {
		      startSim.addActionListener(listener);
		   }
	   public void addgoBackActionListener(ActionListener listener) {
		      goBack.addActionListener(listener);
		   }
}