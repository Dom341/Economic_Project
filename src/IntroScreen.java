import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public class IntroScreen extends JPanel {

	   Font lFont = new Font("Calibri", Font.BOLD, 30);
	   Font bFont = new Font("Calibri", Font.BOLD, 15);
	   
	   private static final String INTRO_LABEL = "Welcome to Understanding Finance!";
	   private static final String INTRO_TEXT = "This game will teach you how to use money responsibly. "
	   		+ "If this is your first time here, you should go through our tutorial. "
	   		+ "This will teach you about money, saving and investing. "
	   		+ "If you have played before, you can jump straight to the simulation or "
	   		+ "go through the tutorial again.";
	   private static final String FUN = "Have fun!";
	   
	   private JButton startLesson = new JButton("Start Tutorial");
	   private JButton startGame = new JButton("Start Simulation");
	   private Color taupe = new Color(255,255,240);
	   private Color green = new Color(0,128,0);
	   
	   private boolean pressStartGame = true;

	   public IntroScreen() {
	      setName("INTRO SCREEN");
	      initUI();
	   }

	   public void initUI()
	   {
		   	  //set null layout
		      setLayout(null);

		      //set heading text
		      JLabel label = new JLabel(INTRO_LABEL, SwingConstants.CENTER);
		      label.setFont(label.getFont().deriveFont(Font.BOLD, 50));
		      label.setForeground(green);
		      label.setBounds(0,50,1200,60);
		      
	          //set Intro Text description
		      JTextArea introText = new JTextArea(INTRO_TEXT);
		      introText.setFont(label.getFont().deriveFont(Font.BOLD, 25));
		      introText.setLineWrap(true);
		      introText.setWrapStyleWord(true);
		      introText.setMargin(new Insets(0,50,50,50));
		      introText.setBackground(taupe);
		      introText.setEditable(false);
		      introText.setBounds(0,150,1200,200);
		      
		      //set image
		      URL imageURL = getClass().getResource("cash.png");
		      Image image = getToolkit().getImage(imageURL);
		      ImageIcon icon = new ImageIcon(image);
		      JLabel imgLabel = new JLabel(icon);
		      imgLabel.setBounds(0,300,1200,200);
		      
		      //set "have fun" label
		      JLabel funLabel = new JLabel(FUN, SwingConstants.CENTER);
		      funLabel.setFont(label.getFont().deriveFont(Font.BOLD, 50));
		      funLabel.setForeground(green);
		      funLabel.setBackground(taupe);
		      funLabel.setBounds(0,550,1200,60);
		      
		      //set Buttons
		      startLesson.setBounds(425,620,175,50);
	  		  startLesson.setFont(bFont);
		      startGame.setBounds(600,620,175,50);
	  		  startGame.setFont(bFont);

	  		  //add everything to null layout
		      add(label);
		      add(introText);
		      add(imgLabel);
		      add(funLabel);
	  		  add(startLesson);
		      add(startGame);
		      
		      setBackground(taupe);
	   }
	   
	   public void changeButtonText()
	   {
		   if(pressStartGame)
		   {
		   pressStartGame = false;
		   startGame.setText("Go Back To Simulation");
		   }
	   }

	   public void addStartLessonActionListener(ActionListener listener) {
		      startLesson.addActionListener(listener);
		   }
	   
	   public void addStartGameActionListener(ActionListener listener) {
		      startGame.addActionListener(listener);
		   }
}