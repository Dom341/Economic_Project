import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class ConclusionPage extends JPanel {

	   private static final float LABEL_FONT_SIZE = 38f;
	   private static final float FONT_SIZE = 24f;
	   private Color taupe = new Color(255,255,240);
	   private Color green = new Color(0,128,0);

	   private String successNote = "Congratulations! You have collected all of the stuff and won the game! It is "
	   		+ "clear that you have a good knowledge of how to be financially responsible. I encourage you to "
	   		+ "keep learning about these valuable life skills as time goes on.";

	   private String failureNote = "Good try! Unfortunately, you only got " + SimulationController.stuffCount 
			+ " \"stuff\" in the end. But you were so close! You should restart this program and try again!\n\n\n"
			+ "                                                     Hint:\n"
			+ "Often, the best strategy for investing is to diversify, or spread your money over multiple "
			+ "investments. This means that if one of your investments goes down, others that went up can more "
			+ "than make up for it. Try it out the next time you go through this program!";



	   public ConclusionPage() {
	      setName("The end");
	      setLayout(null);

	      //set heading
	      JLabel label = new JLabel(getName(), SwingConstants.CENTER);
	      label.setFont(label.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
	      label.setForeground(green);
	      label.setBounds(0,80,1200,80);

	      //set text area
	      JTextArea textArea = new JTextArea(checkSuccess());
	      textArea.setFont(textArea.getFont().deriveFont(Font.BOLD, FONT_SIZE));
	      textArea.setLineWrap(true);
	      textArea.setWrapStyleWord(true);
	      textArea.setBackground(taupe);
	      textArea.setBounds(200,200,800,600);

	      //add components to the layout
	      add(textArea);
	      add(label);
	      setBackground(taupe);
	   }

	   public String checkSuccess(){

		   if (SimulationController.stuffCount == 12)
		   return successNote; else
			   return failureNote;
	   }

}