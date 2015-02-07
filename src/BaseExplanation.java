import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;


public abstract class BaseExplanation extends JPanel {
	
	   private static final float LABEL_FONT_SIZE = 24f;
	   private static final float FONT_SIZE = 16f;
	   private JButton next = new JButton("Next");
	   private Color taupe = new Color(255,255,240);
	   private Color green = new Color(0,128,0);
	   private ActionListener listener;
	   
	   public BaseExplanation(String name, String info) {
	      setName(name);
	      
	      //set heading
	      JLabel label = new JLabel(getName(), SwingConstants.CENTER);
	      label.setFont(label.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
	      label.setForeground(green);
	      
	      //add next button
	      JPanel btnPanel = new JPanel(new GridBagLayout());
	      btnPanel.setBackground(taupe);
	      btnPanel.add(next);
	      
	      //set text area
	      JTextArea textArea = new JTextArea(info);
	      textArea.setFont(textArea.getFont().deriveFont(FONT_SIZE));
	      textArea.setLineWrap(true);
	      textArea.setWrapStyleWord(true);
	      textArea.setBackground(taupe);
	      
	      
	      //add components to the layout
	      setLayout(new BorderLayout());
	      add(btnPanel, BorderLayout.SOUTH);
	      add(textArea);
	      add(label, BorderLayout.NORTH);
	      setBackground(taupe);
	   }
	 
	   public void addNextActionListener(ActionListener listener) {
	      next.addActionListener(listener);
	   }
	}