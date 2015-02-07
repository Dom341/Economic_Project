import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * 
 * SimulationExplanation class
 * 
 * This class produces the view to display the user's financial results
 * after a year in the simulator. The user can view their new balance
 * formed from their total profits and losses from all investments in 
 * addition to viewing an informative graph highlighting their career. 
 * The user will also be matched with their profile type by implementing 
 * an algorithm which uses their spending habits to present advice to the
 * user in order to help them become more successful at investing. Finally,
 * the user may proceed to the next year of  
 *
 */
class SimulationExplanation extends JPanel {

	//Create instance of controller to be connected to view
	SimulationController controller;
	
	private Color taupe = new Color(255,255,240);
	private Color green = new Color(0,128,0);
		
	private static final float LABEL_FONT_SIZE = 24f;
	private static final int width = 800;
	private static final int height = 700;
	private JButton next = new JButton("Move to Next Year");
	
	public Graph graph = new Graph(0,0, "Your Balance Progress by Year");
	
	private JPanel east;
	private JPanel west;
	
	private JLabel newBalanceL;
	private JLabel changeInBalanceL;
	private JLabel portfolioL;
	private JTextArea resultsL;
	private JLabel graphL;
	private JLabel bankL;
	private JLabel ToysIncL;
	private JLabel CandyCorpL;
	private JLabel PetCoL;
	private JLabel annualL;
	
	private JLabel bankReturnL;
	private JLabel ToysIncReturnL;
	private JLabel CandyCorpReturnL;
	private JLabel PetCoReturnL;
	

	public SimulationExplanation() 
	{
		setName("EXPLANATION");

		initUI();

	}

	public void initUI()
	{
		
		setPreferredSize(new Dimension(width, height));
		setDoubleBuffered(true);
		
		GridLayout layout = new GridLayout(1, 2);
		this.setLayout(layout);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		west = new JPanel();
		west.setBackground(taupe);
		east = new JPanel();
		east.setBackground(taupe);
		
		west.setLayout(new GridBagLayout());
		east.setLayout(new GridBagLayout());
		
		
		//West
		//1st row
		newBalanceL = new JLabel("Your new Balance: " + controller.Balance);
		newBalanceL.setFont(newBalanceL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		newBalanceL.setForeground(green);
		
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		
		c.insets = new Insets(30,30,0,0);
		
		
		west.add(newBalanceL, c);
		
		//2rd row
		graphL = new JLabel("Graph: ");
		graphL.setFont(graphL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		graphL.setForeground(green);

		c.gridx = 0;
		c.gridy = 1;


		west.add(graphL, c);


		//3rd row
		c.gridx = 0;
		c.gridy = 2;
		c.ipady = 200;
		c.ipadx = 200;
		c.gridwidth = 2;
		c.gridheight = 2;
		
		c.insets = new Insets(0,30,0,0);


		west.add(graph,c);
		
		
		
		
		
		//4th row
		resultsL = new JTextArea("");
		resultsL.setFont(resultsL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		resultsL.setLineWrap(true);
		resultsL.setWrapStyleWord(true);
		resultsL.setBackground(getBackground());


		c.ipady = 0;
		c.ipadx = 0;
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		c.gridheight = 2;
		c.insets = new Insets(30,30,0,0);

		west.add(resultsL, c);
		
		
		
		//East
		//1st row
		changeInBalanceL = new JLabel("Growth: " + controller.changeInBalance);
		changeInBalanceL.setFont(changeInBalanceL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		changeInBalanceL.setForeground(green);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.ipady = 0;
		c.insets = new Insets(0,30,0,0);
		
		
		
		east.add(changeInBalanceL, c);
		
		
		
		
		c.gridx = 4;
		c.gridy = 0;
		c.ipady = 20;
		c.insets = new Insets(0,0,0,50);

		east.add(next, c);
		
		
		//2nd row
		annualL = new JLabel("Annual Returns: ");
		annualL.setFont(annualL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));	
		annualL.setForeground(green);

		c.gridx = 0;
		c.gridy = 1;
		c.ipady = 0;
		c.insets = new Insets(50,30,0,0);

		east.add(annualL, c);

		//3rd row
		bankL = new JLabel("Bank ");
		bankL.setFont(bankL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		bankL.setForeground(green);
		c.gridx = 0;
		c.gridy = 2;

		c.insets = new Insets(30,30,0,0);
		east.add(bankL, c);


		ToysIncL = new JLabel("ToysInc ");
		ToysIncL.setFont(ToysIncL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		ToysIncL.setForeground(green);
		c.gridx = 1;
		c.gridy = 2;


		east.add(ToysIncL, c);

		
		//4th row
		bankReturnL = new JLabel("$" + controller.bankReturn);
		bankReturnL.setFont(bankReturnL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		c.gridx = 0;
		c.gridy = 3;

		east.add(bankReturnL, c);

		ToysIncReturnL = new JLabel("$" + controller.ToysIncReturn);
		ToysIncReturnL.setFont(ToysIncReturnL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		c.gridx = 1;
		c.gridy = 3;



		east.add(ToysIncReturnL, c);

		
		//5th row

		CandyCorpL = new JLabel("CandyCorp ");
		CandyCorpL.setFont(CandyCorpL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		CandyCorpL.setForeground(green);
		c.gridx = 0;
		c.gridy = 4;


		east.add(CandyCorpL, c);


		PetCoL = new JLabel("PetCo ");
		PetCoL.setFont(PetCoL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		PetCoL.setForeground(green);
		c.gridx = 1;
		c.gridy = 4;


		east.add(PetCoL, c);
		
		
		//6th row
		CandyCorpReturnL = new JLabel("$" + controller.CandyCorpReturn);
		CandyCorpReturnL.setFont(CandyCorpReturnL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		c.gridx = 0;
		c.gridy = 5;


		east.add(CandyCorpReturnL, c);

		PetCoReturnL = new JLabel("$" + controller.PetCoReturn);
		PetCoReturnL.setFont(PetCoReturnL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		c.gridx = 1;
		c.gridy = 5;


		east.add(PetCoReturnL, c);
		

		
		this.add(west);
		this.add(east);
	}
	
	
	
	public void generateResults()
	{
    	controller.generateCompanyGrowthRates();
    	controller.generateCompanyReturns();
		controller.updateBalance();
		displayCompanyGrowth();
		updateBalance();
		
		String explanation = controller.getExplanation();
		
		resultsL.setText(explanation);
		
		revalidate();
		
	}
	
	//Redraws the balance
	public void updateBalance()
	{
		newBalanceL.setText("Your new balance: " + controller.Balance);
		changeInBalanceL.setText("Growth: " + controller.changeInBalance);
	}
	
	//Displays the growth rate for each company
	public void displayCompanyGrowth() {
		//sets the text fields for company growth rates
	
		bankReturnL.setText("$" + controller.bankReturn);
		if(controller.bankReturn != 0)
		{
			bankReturnL.setForeground(Color.GREEN);
		}
		else if(controller.bankReturn == 0)
		{
			bankReturnL.setForeground(Color.BLACK);
		}
		
		ToysIncReturnL.setText("$" + controller.ToysIncReturn);
		if(controller.ToysIncReturn > 0)
		{
			ToysIncReturnL.setForeground(Color.GREEN);
		}
		else if(controller.ToysIncReturn < 0)
		{
			ToysIncReturnL.setForeground(Color.RED);
		}
		else 
		{
			ToysIncReturnL.setForeground(Color.BLACK);
		}
		
	    CandyCorpReturnL.setText("$" + controller.CandyCorpReturn);
	    if(controller.CandyCorpReturn > 0)
		{
			CandyCorpReturnL.setForeground(Color.GREEN);
		}
		else if(controller.CandyCorpReturn < 0)
		{
			CandyCorpReturnL.setForeground(Color.RED);
		}
		else 
		{
			CandyCorpReturnL.setForeground(Color.BLACK);
		}
	    
	    PetCoReturnL.setText("$" + controller.PetCoReturn);
	    if(controller.PetCoReturn > 0)
		{
	    	PetCoReturnL.setForeground(Color.GREEN);
		}
		else if(controller.PetCoReturn < 0)
		{
			PetCoReturnL.setForeground(Color.RED);
		}
		else 
		{
			PetCoReturnL.setForeground(Color.BLACK);
		}
	    
		
	}
	
	
	
	
	
	
	//Connect View to Controller
	public void AddListener( SimulationController controller )
    {
        this.controller = controller;
    }
	

	public void addBackActionListener(ActionListener listener) 
	{
		next.addActionListener(listener);
	}
}
