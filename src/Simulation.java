import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.net.URL;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;



public class Simulation extends JPanel {
	
	private final double GRAPH_CONVERSION = 10;
	
	SimulationController controller;
	
	private JPanel east;
	private JPanel stuffHolder;
	private JPanel west;
	private JPanel newEast;
	
	private Color taupe = new Color(255,255,240);
	private Color green = new Color(0,128,0);
		
	private static final float LABEL_FONT_SIZE = 24f;
	private static final float FONT_SIZE = 16f;
	private static final int width = 1000;
	private static final int height = 700;
	private JButton done = new JButton("SEE RESULTS");
	private JButton restart = new JButton("RETURN TO LESSON");
	private JButton end = new JButton("DONE");

	//Graph
	private Graph toysGraph = new Graph(0,0, "ToysInc Year by Year Progress");
	private Graph candyGraph = new Graph(0,0, "CandyCorp Year by Year Progress");
	private Graph petGraph = new Graph(0,0, "PetCo Year by Year Progress");
	private Graph invisiGraph = new Graph(0,0, "invisible");


	private JLabel bankL;
	private JLabel stuffL;
	private JLabel stuffL2;
	public JLabel yearL;
	private JLabel balanceL;
	private JLabel marketL;
	private JLabel ToysIncL;
	private JLabel CandyCorpL;
	private JLabel PetCoL;
	private JLabel graphL;
	private JLabel companyInfoL;
	private JLabel spacerL;
	
	private JLabel [] stuff;
	private ImageIcon [] image;
	
	private JTextArea bankDescription;
	private JTextArea companyDescription;
	private JTextArea finalDescription;
	

	private TextField bankT;
	private TextField ToysIncT;
	private TextField CandyCorpT;
	private TextField PetCoT;
	
	private JButton bankB;
	private JButton starsB;
	private JButton ToysIncB;
	private JButton CandyCorpB;
	private JButton PetCoB;
	private JButton ToysIncBInfo;
	private JButton CandyCorpBInfo;
	private JButton PetCoBInfo;
	
	private String bankS;
	private String ToysIncS;
	private String CandyCorpS;
	private String PetCoS;

	public Simulation() 
	{
		setName("SIMULATION");
		initUI();

	}

	public void initUI()
	{
		ToysIncS = "Info About Toys Inc";
		CandyCorpS = "Info About Candy";
		PetCoS = "Info About Pets";
		
		stuff = new JLabel [13];
		image = new ImageIcon [13];
		
		setPreferredSize(new Dimension(width, height));
		setDoubleBuffered(true);
		
		GridLayout layout = new GridLayout(1, 2);
		this.setLayout(layout);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		
		//West
		//1st row
		west = new JPanel();
		west.setLayout(new GridBagLayout());
		west.setBackground(taupe);
		
		yearL = new JLabel("Year: " + controller.year);
		yearL.setFont(yearL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		yearL.setForeground(green);
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 0;
		
		c.insets = new Insets(0,30,0,0);
		
		
		west.add(yearL, c);
		
		//2nd row
		companyInfoL = new JLabel("Company Info: ");
		companyInfoL.setFont(companyInfoL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		companyInfoL.setForeground(green);
		c.gridx = 0;
		c.gridy = 1;


		west.add(companyInfoL, c);

		//3rd row
		String exampleText = "The Bank is as stable as it gets. They will hold your money and keep it safe, "
				+ "paying you a consistent return rate of 2% every year. You can count on them to make the best "
				+ "decisions with your money. However, don’t expect to make huge returns from such a risk-free investment.";
		
		companyDescription = new JTextArea(exampleText);
		companyDescription.setFont(companyDescription.getFont().deriveFont(Font.BOLD, FONT_SIZE));
		companyDescription.setLineWrap(true);
		companyDescription.setWrapStyleWord(true);
		companyDescription.setBackground(getBackground());
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		c.gridheight = 2;

		west.add(companyDescription, c);
		
		//4th row
		graphL = new JLabel("Graph: ");
		graphL.setFont(graphL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		graphL.setForeground(green);
		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 1;
		c.gridheight = 1;

		west.add(graphL, c);
		
		//5th row
		//graph = new JPanel();
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 2;
		c.gridheight = 2;
		c.ipady = 200;
		c.ipadx = 200;
		west.add(toysGraph, c);
		toysGraph.setVisible(false);
		west.add(candyGraph, c);
		candyGraph.setVisible(false);
		west.add(petGraph, c);
		petGraph.setVisible(false);
		west.add(invisiGraph, c);
		
		
		
		//East
		//1st row
		east = new JPanel();
		east.setLayout(new GridBagLayout());
		east.setBackground(taupe);
		
		
		balanceL = new JLabel("Balance: $" + controller.Balance);
		balanceL.setFont(balanceL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		balanceL.setForeground(green);
		
		c.insets = new Insets(0,0,30,0);
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.ipady = 0;
		c.ipadx = 0;
		
		east.add(balanceL, c);
		
		//2nd row
		stuffL = new JLabel("STUFF");
		stuffL.setFont(stuffL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		stuffL.setForeground(green);
		c.gridx = 0;
		c.gridy = 1;
		
		c.insets = new Insets(0,30,0,30);
		east.add(stuffL, c);


		//3rd row	
		stuffL2 = new JLabel("Buy 12 things to win! Each is $20.");
		stuffL2.setFont(stuffL2.getFont().deriveFont(Font.BOLD, FONT_SIZE));
		
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 2;
		
		east.add(stuffL2, c);
		
		
		//4th row
		stuffHolder = new JPanel();
		stuffHolder.setLayout(new BoxLayout(stuffHolder, BoxLayout.X_AXIS));
		stuffHolder.setPreferredSize(new Dimension(300,30));
		
		Border starBorder;
		starBorder = BorderFactory.createLineBorder(Color.BLACK);
		
		stuffHolder.setBorder(starBorder);
		
		c.gridx = 0;
		c.gridy = 3;
		c.ipady = 30;
		c.gridwidth = 2;
		c.anchor = GridBagConstraints.PAGE_START;
		
		east.add(stuffHolder, c);
		
		
		//5th row
		starsB = new JButton("Buy stuff");
		
		c.gridx = 0;
		c.gridy = 4;
		c.ipady = 20;
		c.gridwidth = 1;
		
		east.add(starsB, c);
		
		
		//6th row
		bankL = new JLabel("Bank");
		bankL.setFont(bankL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		bankL.setForeground(green);
		
		c.insets = new Insets(20,30,0,30);
		c.gridx = 0;
		c.gridy = 5;
		c.ipady = 0;

		east.add(bankL, c);


		//7th row
		bankDescription = new JTextArea("The bank will take your savings and return a small investment at the end of the year.");
		bankDescription.setFont(bankDescription.getFont().deriveFont(Font.BOLD, FONT_SIZE));
		bankDescription.setLineWrap(true);
		bankDescription.setWrapStyleWord(true);
		bankDescription.setBackground(getBackground());

		c.insets = new Insets(0,30,0,30);
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 2;

		east.add(bankDescription, c);


		//8th row
		bankT = new TextField();
		c.gridx = 0;
		c.gridy = 7;
		c.gridwidth = 1;
		

		east.add(bankT, c);

		//9th row
		//Add save button and set action listener
		bankB = new JButton("Save");
		bankB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Get text input and send to controller
				bankS = bankT.getText();

				boolean number = numberCheck(bankS);
				if(number)
				{
					boolean check = controller.balanceErrorCheck(bankS);

					if(!check)
					{
						displayError("Insufficient funds");
					}
					else
					{
						controller.getInput( bankS, 'b');
						updateBalance();
					}	
				}
				else
				{
					displayError("Only positive integer numbers are valid");
				}


			}
		});
		c.gridx = 0;
		c.gridy = 8;

		c.ipady = 20;


		east.add(bankB, c);
		
		
		//10th row
		marketL = new JLabel("The Market: ");
		marketL.setFont(marketL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		marketL.setForeground(green);
		c.insets = new Insets(20,30,0,30);
		c.gridx = 1;
		c.gridy = 9;
		c.ipady = 0;
		
		east.add(marketL, c);
		
		
		//11th row
		ToysIncL = new JLabel("ToysInc");
		ToysIncL.setFont(ToysIncL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		ToysIncL.setForeground(green);
		c.insets = new Insets(0,30,0,30);
		c.gridx = 0;
		c.gridy = 10;
		
		east.add(ToysIncL, c);
		
		
		CandyCorpL = new JLabel("CandyCorp");
		CandyCorpL.setFont(CandyCorpL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		CandyCorpL.setForeground(green);
		c.gridx = 1;
		c.gridy = 10;
		
		east.add(CandyCorpL, c);
		
		PetCoL = new JLabel("PetCo");
		PetCoL.setFont(PetCoL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		PetCoL.setForeground(green);
		c.gridx = 2;
		c.gridy = 10;
		
		east.add(PetCoL, c);
		
		
		//12th row
		ToysIncT = new TextField();
		c.gridx = 0;
		c.gridy = 11;
		
		east.add(ToysIncT, c);
		
		CandyCorpT = new TextField();
		c.gridx = 1;
		c.gridy = 11;
		
		east.add(CandyCorpT, c);
		
		PetCoT = new TextField();
		c.gridx = 2;
		c.gridy = 11;
		
		east.add(PetCoT, c);
		
		//13th row
		ToysIncBInfo = new JButton("Info");
		
		
		c.gridx = 0;
		c.gridy = 12;
		
		c.ipady = 10;
		
		east.add(ToysIncBInfo, c);
			
		
		CandyCorpBInfo = new JButton("Info");
		
		
		c.gridx = 1;
		c.gridy = 12;
		
		east.add(CandyCorpBInfo, c);
		
		
		PetCoBInfo = new JButton("Info");
		
		c.gridx = 2;
		c.gridy = 12;
		
		east.add(PetCoBInfo, c);
		
		
		//14th row
		ToysIncB = new JButton("Invest");
		//Add invest button and set action listener
		ToysIncB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Get text input and send to controller
				ToysIncS = ToysIncT.getText();
				
				boolean number = numberCheck(ToysIncS);
				if(number)
				{
					boolean check = controller.balanceErrorCheck(ToysIncS);
			        
					if(!check)
					{
						displayError("Insufficient funds");
					}
					else
					{
						controller.getInput( ToysIncS, 't');	
						updateBalance();
					}	
				}
				else
				{
					displayError("Only positive integer numbers are valid");
				}		
		        		
			}
		});
		
		c.gridx = 0;
		c.gridy = 13;
		
		east.add(ToysIncB, c);
		
		CandyCorpB = new JButton("Invest");
		//Add invest button and set action listener
		CandyCorpB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Get text input and send to controller
				CandyCorpS = CandyCorpT.getText();
				
				boolean number = numberCheck(CandyCorpS);
				if(number)
				{
					boolean check = controller.balanceErrorCheck(CandyCorpS);
			        
					if(!check)
					{
						displayError("Insufficient funds");
					}
					else
					{
						controller.getInput( CandyCorpS, 'c');	
						updateBalance();
					}	
				}
				else
				{
					displayError("Only positive integer numbers are valid");
				}
			}
		});	
		
		c.gridx = 1;
		c.gridy = 13;
		
		east.add(CandyCorpB, c);
		
		
		PetCoB = new JButton("Invest");
		//Add invest button and set action listener
		PetCoB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Get text input and send to controller
				PetCoS = PetCoT.getText();
				
				boolean number = numberCheck(PetCoS);
				if(number)
				{
					boolean check = controller.balanceErrorCheck(PetCoS);
			        
					if(!check)
					{
						displayError("Insufficient funds");
					}
					else
					{
						controller.getInput( PetCoS, 'p');	
						updateBalance();
					}	
				}
				else
				{
					displayError("Only positive integer numbers are valid");
				}	
		        			
			}
		});	
		
		c.gridx = 2;
		c.gridy = 13;
		
		east.add(PetCoB, c);

		

		//15th row
		
		c.insets = new Insets(15,30,0,30);
		
		c.gridx = 1;
		c.gridy = 14;
		
		c.ipady = 40;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		restart.setBackground(Color.WHITE);
		east.add(restart, c);
		
		
		c.gridx = 2;
		c.gridy = 14;
		done.setBackground(Color.WHITE);
		east.add(done, c);

		
	
		this.add(west);
		this.add(east);
		
		
	
	}
	
	public void advanceCycle()
	{
		clearAll();
		incrementYear();
		updateBalance();
		updateGraphs();
		
		controller.regenerateMarket();
	}
	
	public void incrementYear()
	{
		controller.incrementYear();
		yearL.setText("Year: " + controller.year);
	}
	
	public void updateBalance()
	{
		balanceL.setText("Balance: $" + controller.Balance);
	}
	
	
	public void clearAll()
	{
		bankT.setText("");
		ToysIncT.setText("");
		CandyCorpT.setText("");
		PetCoT.setText("");
	}
	
	
	public void addStuff()
	{
		int count = controller.stuffCount;
		controller.stuffCount++;
		
		controller.Balance = controller.Balance - 20; 
		updateBalance();
		
		Random rand = new Random();
		int item = rand.nextInt(5) + 1;
		
		switch(item)
		{
			case 1:
				URL star = getClass().getResource("star.png");
				image[count] = new ImageIcon(star);
				break;
			case 2:
				URL basketball = getClass().getResource("Basketball.png");
				image[count] = new ImageIcon(basketball);
				break;
			case 3:
				URL laptop = getClass().getResource("Laptop.png");
				image[count] = new ImageIcon(laptop);
				break;
			case 4: 
				URL lego = getClass().getResource("Lego.png");
				image[count] = new ImageIcon(lego);
				break;
			case 5:
				URL Tshirt = getClass().getResource("Tshirt.png");
				image[count] = new ImageIcon(Tshirt);
				break;
		}
		
		stuff[count] = new JLabel(image[count]);

		stuffHolder.add(stuff[count]);
		stuffHolder.revalidate();

		if(controller.stuffCount == 12)
		{
			controller.gameStatus = false;
		}
			
	}
	
	public boolean numberCheck(String value)
    {
    	if(value.matches("[0-9]+"))
    	{
    		return true;
    	}
    	else 
    	{
    		return false;
    	}
    }
	
	public void displayCandyInfo(String info)
	{
		invisiGraph.setVisible(false);
		toysGraph.setVisible(false);
		petGraph.setVisible(false);
		candyGraph.setVisible(true);
		companyDescription.setText(info);
	}
	
	public void displayToysInfo(String info)
	{
		invisiGraph.setVisible(false);
		toysGraph.setVisible(true);
		petGraph.setVisible(false);
		candyGraph.setVisible(false);
		companyDescription.setText(info);
	}
	
	public void displayPetInfo(String info)
	{
		invisiGraph.setVisible(false);
		toysGraph.setVisible(false);
		petGraph.setVisible(true);
		candyGraph.setVisible(false);
		companyDescription.setText(info);
	}
	
	public void updateGraphs()
	{
		toysGraph.addPoint((int) (GRAPH_CONVERSION*controller.ToysInc.getGrowthRate()));
		candyGraph.addPoint((int) (GRAPH_CONVERSION*controller.CandyCorp.getGrowthRate()));
		petGraph.addPoint((int) (GRAPH_CONVERSION*controller.PetCo.getGrowthRate()));
	}
	
	public void displayError(String message)
	{
		JOptionPane.showMessageDialog(this, message);
	}
	
	public void lastChance()
	{
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		
		newEast = new JPanel();
		newEast.setLayout(new GridBagLayout());
		
		
		this.remove(west);
		this.add(newEast);
		
		
		String tips = "How Far Will Your Earnings Take You?"
				+ '\n' + '\n' + "       Use the earnings from your investments "
						+ "to purchase any number of remaining items! Remember, "
						+ "however, that your consumption today will affect your "
						+ "ability to earn tomorrow. By building healthy spending "
						+ "habits through savings and wise investments you will "
						+ "position yourself for financial success in the future."
				+ '\n' + '\n' + "       Here are a couple of money management tips "
						+ "to help you maintain healthy spending habits today and "
						+ "help secure prosperity tomorrow."
				+ '\n' + '\n' + "       Tip 1"
				+ '\n' + '\n' + "       Lower the limits on your bank cards and "
						+ "consider not having easy access to your savings account "
						+ "with your debit card. Use technology to help keep your "
						+ "money safe from yourself!"
				+ '\n' + '\n' + "       Tip 2"
				+ '\n' + '\n' + "       Plan your spending based on when you receive "
						+ "your money. Always borrowing from the bank of Mom, Dad or "
						+ "Grandparents doesn’t help you develop good habits while you "
						+ "have the chance!"
				+ '\n' + '\n' + "       Tip 3"
				+ '\n' + '\n' + "       Have at least 2 bank accounts – one for savings "
						+ "and the other for your weekly spending.";
				
		
		finalDescription = new JTextArea(tips);
		finalDescription.setFont(finalDescription.getFont().deriveFont(Font.BOLD, FONT_SIZE));
		finalDescription.setLineWrap(true);
		finalDescription.setWrapStyleWord(true);
		finalDescription.setBackground(taupe);
		
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.ipady = 250;
		c.ipadx = 25;
		c.insets = new Insets(0,0,0,25);

		newEast.add(finalDescription, c);
		

		
		
		east.remove(bankL);
		east.remove(marketL);
		east.remove(ToysIncL);
		east.remove(CandyCorpL);
		east.remove(PetCoL);
		east.remove(bankT);
		east.remove(ToysIncT);
		east.remove(CandyCorpT);
		east.remove(PetCoT);
		east.remove(bankB);
		east.remove(ToysIncB);
		east.remove(CandyCorpB);
		east.remove(PetCoB);
		east.remove(ToysIncBInfo);
		east.remove(CandyCorpBInfo);
		east.remove(PetCoBInfo);
		east.remove(done);
		east.remove(restart);
		east.remove(bankDescription);
		
		
		c.weightx = 0.5;
		c.weighty = 0.5;
		c.gridx = 0;
		c.gridy = 4;
		c.ipady = 40;
		c.ipadx = 0;
		c.insets = new Insets(0,30,0,30);
		
		end.setFont(new Font("Arial", Font.BOLD, 20));
		
		east.add(end, c);
		
		spacerL = new JLabel("    ");
		spacerL.setFont(spacerL.getFont().deriveFont(Font.BOLD, LABEL_FONT_SIZE));
		
		
		c.gridx = 1;
		c.gridy = 7;
		c.ipady = 0;
		c.insets = new Insets(0,0,0,0);
		
		east.add(spacerL, c);
		
		
		
		revalidate();
	}
	
	//Adding listeners to the buttons
	public void AddListener( SimulationController controller )
    {
        this.controller = controller;
    }
	
	public void addDoneActionListener(ActionListener listener) {
		done.addActionListener(listener);
	}
	
	public void addRestartActionListener(ActionListener listener) {
		restart.addActionListener(listener);
	}
	
	public void addToysInfoListener(ActionListener listener) {
		ToysIncBInfo.addActionListener(listener);
	}
	
	public void addCandyInfoListener(ActionListener listener) {
		CandyCorpBInfo.addActionListener(listener);
	}
	
	public void addPetInfoListener(ActionListener listener) {
		PetCoBInfo.addActionListener(listener);
	}
	
	public void addStarListener(ActionListener listener) {
		starsB.addActionListener(listener);
	}
	
	public void addEndListener(ActionListener listener) {
		end.addActionListener(listener);
	}
	
	
}

