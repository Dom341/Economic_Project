
public class SimulationController {

	//MVC
	Simulation simView;
	SimulationExplanation simExplainView;
	SimulationCalculator simCalc;
	
    //Company Details
    public static String ToysIncDescription = "TOYS INC."
    		+ "Toys Inc. sells awesome toys that will challenge your child's intellect and stretch their imagination. Huge selection of specialty educational toys, games, gifts." + '\n'
			+ "Toys Inc. has been performing solidly for the past two years as a result of a new line of plush animal toys with internal robotics. Strong management and a powerful brand, Toys Inc. has analysts forecasting moderate but steady growth." + '\n'
			+ "Average Return: 8%" + '\n'
			+ "Range of Return:  ±34% ";
    private static int ToysIncRiskLevel = 2;
    private static double ToysIncMaxGrowthRate = 0.25;
    private static double ToysIncMinGrowthRate = -0.09;
    
    public static String CandyCorpDescription = "CANDY CORP"
    		+ "Candy Corp is a family-run candy company making your favorite sweet treats since 1906. Our products include lollipops, candy canes, and marshmallow candies." + '\n'
			+ "In response to a recent slowdown in sales Candy Corp acquired a new CEO, Princess Bubblegum, who is just beginning to prove her ability to break with tradition and modernize this old-time candy company." + '\n'
			+ "Average Return: 37.5%" + '\n'
			+ "Range of Return: ±55%";
    private static int CandyCorpRiskLevel = 6;
    private static double CandyCorpMaxGrowthRate = 0.50;
    private static double CandyCorpMinGrowthRate = -0.25;
    
    public static String PetCoDescription = "PETCO"
    		+ "Pet Co.'s commitment to Natural, Holistic, and Organic pet food is unparalleled in the pet industry. Pet Co. offers a wide range of pet products and services. If it squawks, purrs or barks we probably sell it." + '\n'
			+ "Pet Co. just underwent a massive corporate restructuring. Pet Co. is rapidly expanding however some analysts worry that it is growing too quickly and will not be able to control spending. While some forecasts predict low returns others have labeled Pet Co the hottest thing since Noah’s Ark." + '\n'
			+ "Average Return: 25%" + '\n'
			+ "Range of Return: ±80%";
    private static int PetCoRiskLevel = 10;
    private static double PetCoMaxGrowthRate = 1.00;
    private static double PetCoMinGrowthRate = -0.50;
    
    
    //Risk Assessment and Explanation Messages
    public static final String VRISK_GAIN = "Investment Analysis: VERY RISKY" + '\n' +
    		"You are a very risky investor! You bet the farm and it paid off. Remember, however, that while you may "
    		+ "have earned large returns this year such a risky investing style could leave you with nothing next year. "
    		+ "Perhaps move some of your investments into savings to prevent large losses in the future.";
    public static final String VRISK_LOSS = "Investment Analysis: VERY RISKY" + '\n' +
    		"You are a very risky investor! You bet it all and lost. The market did not perform well this year which "
    		+ "resulted in a loss. Next year move some of your investments into savings or invest in companies which "
    		+ "have a smaller range of returns.";
    public static final String RISK_GAIN = "Investment Analysis: RISKY" + '\n' +
    		"You are a risky investor! While a high risk investment portfolio can yield high returns be cautious. "
    		+ "The market performed particularly well this year but it may fluctuate back. It is important to balance risky "
    		+ "investments with adequate savings in the event of a loss.";
    public static final String RISK_LOSS = "Investment Analysis: RISKY" + '\n' +
    		"Loss: You are a risky investor! The market performed poorly this year resulting in a loss. You may have made too "
    		+ "many risky investments or invested too heavily in one company. Next year move more money into savings and invest "
    		+ "in companies that are more likely to yield a positive return.";
    public static final String CONSERVATIVE_GAIN = "Investment Analysis: CONSERVATIVE" + '\n' + 
    		"Gain: You are a conservative investor! Your cautious investing style resulted in some gains but you may be missing "
    		+ "opportunities in the market. Research the market to find out which companies will yield a better return.";
    public static final String CONSERVATIVE_LOSS = "Investment Analysis: CONSERVATIVE " + '\n' + 
    		"Loss: You are a conservative investor! By investing cautiously you were able to minimize your losses. The market "
    		+ "contracted however next year may be promising. Shift some of your investments out of savings and into low risk "
    		+ "investment opportunities. ";
    public static final String VCONSERVATIVE_GAIN = "Investment Analysis: VERY CONSERVATIVE" + '\n' +
    		"You are a very conservative investor! You saved heavily and invested sparingly although you will not be able to "
    		+ "make much of a return. While it is important to be cautions you could take greater advantage of market";
    public static final String VCONSERVATIVE_LOSS = "Investment Analysis: VERY CONSERVATIVE" + '\n' +
    		"You are a very conservative investor! Despite the fact that you saved and invested cautiously the markets did"
    		+ " not turn in your favor and you still suffered a loss. Better luck next time chump.";
    public static final String SAVER = "Investment Analysis: SAVER" + '\n' +
    		"You are a saver! By deciding only to save you are shielded from the fluctuations in the market and therefore "
    		+ "are guaranteed a positive return. However, by failing to invest you fail to take advantage of market opportunities "
    		+ "for growth and a higher return.";
    public static final String SPENDER = "Investment Analysis: SPENDER" + '\n' + 
    		"You are a spender! While consuming is enjoyable, alone it is unsustainable. If you continue to consume "
    		+ "you will quickly run out of money. Next year save some of your money in the bank and invest in the "
    		+ "market to increase your total wealth.";
	
    public static int bankReturn = 0;
    public static int ToysIncReturn = 0;
    public static int CandyCorpReturn = 0;
    public static int PetCoReturn = 0;
	
	public static int year = 1;
	public static int stuffCount = 0;
	
	public static int Balance = 100;
	public static int totalInvested;
	public static int changeInBalance;
	
	public static int[] pastBalances = new int[6]; //holds changeInBalance values
	
	public static boolean gameStatus = true;
	
	public static String investmentProfile;
	
	//Asset Objects
	public static Bank bank = new Bank();
	public static Company ToysInc = new Company("ToysInc", ToysIncDescription, ToysIncRiskLevel, 
													ToysIncMaxGrowthRate, ToysIncMinGrowthRate);
	public static Company CandyCorp = new Company("CandyCorp", CandyCorpDescription, CandyCorpRiskLevel, 
													CandyCorpMaxGrowthRate, CandyCorpMinGrowthRate);
	public static Company PetCo = new Company("PetCo", PetCoDescription, PetCoRiskLevel, 
													PetCoMaxGrowthRate, PetCoMinGrowthRate);
	
	

	//Constructor
    public SimulationController( Simulation simView, SimulationExplanation simExplainView, 
    		SimulationCalculator simCalc )
    {
    	this.simCalc = simCalc; // connect model to controller
        this.simView = simView;
        this.simExplainView = simExplainView;
        this.simView.AddListener(this); // Pass controller to simulator view 
        this.simExplainView.AddListener(this); // Pass controller to simulator explanation
        
    }
    
    //calculates the rate of growth for each company and stores them in the company objects
    public void generateCompanyGrowthRates() {
    	
    	
    	double ToysIncGrowthRate = simCalc.calcGrowthRate(ToysInc.getRiskLevel(),	//generate growth rate
				ToysInc.getMaxGrowthRate(), ToysInc.getMinGrowthRate());
    	ToysInc.setAssetGrowthRate(ToysIncGrowthRate);								//store in Company object
    	
    	double CandyCorpGrowthRate = simCalc.calcGrowthRate(CandyCorp.getRiskLevel(),
				CandyCorp.getMaxGrowthRate(), CandyCorp.getMinGrowthRate());
    	CandyCorp.setAssetGrowthRate(CandyCorpGrowthRate);
    	
    	double PetCoGrowthRate = simCalc.calcGrowthRate(PetCo.getRiskLevel(),
				PetCo.getMaxGrowthRate(), PetCo.getMinGrowthRate());
    	PetCo.setAssetGrowthRate(PetCoGrowthRate);
    	
    	
 /*    	bankGrowthRate = bank.getGrowthRate();
    	ToysIncGrowthRate = simCalc.getGrowthRate(ToysInc.getRiskLevel(),
    								ToysInc.getMaxGrowthRate(), ToysInc.getMinGrowthRate());
    	CandyCorpGrowthRate = simCalc.getGrowthRate(CandyCorp.getRiskLevel(),
    								CandyCorp.getMaxGrowthRate(), CandyCorp.getMinGrowthRate());
    	PetCoGrowthRate = simCalc.getGrowthRate(PetCo.getRiskLevel(),
    								PetCo.getMaxGrowthRate(), PetCo.getMinGrowthRate());*/
    	
    }
    
    //calculates the rate of return for each company and stores them in the company objects
    public void generateCompanyReturns() {

    	//retrieve user input from company asset objects
    	int bankAmtInvested = bank.getAmtInvested();
    	int ToysIncAmtInvested = ToysInc.getAmtInvested();
    	int CandyCorpAmtInvested = CandyCorp.getAmtInvested();
    	int PetCoAmtInvested = PetCo.getAmtInvested();
    	
    	
    	
//    	if((bankAmtInvested == 0 && ToysIncAmtInvested == 0) && (CandyCorpAmtInvested == 0 && PetCoAmtInvested == 0))
//    	{
//    		simView.displayError("Cannot proceed without investing");
//    	}
//    	else
//    	{
    		//Set return values for this year
        	bankReturn = simCalc.getCompanyReturn(bankAmtInvested, bank.getGrowthRate());
        	ToysIncReturn = simCalc.getCompanyReturn(ToysIncAmtInvested, ToysInc.getGrowthRate());
        	CandyCorpReturn = simCalc.getCompanyReturn(CandyCorpAmtInvested, CandyCorp.getGrowthRate());
        	PetCoReturn = simCalc.getCompanyReturn(PetCoAmtInvested, PetCo.getGrowthRate());
        	
    	//}
    	
 	
    	
    	/*bankReturn = simCalc.getCompanyReturn(bankAmtInvested, bankGrowthRate);
    	ToysIncReturn = simCalc.getCompanyReturn(ToysIncAmtInvested, ToysIncGrowthRate);
    	CandyCorpReturn = simCalc.getCompanyReturn(CandyCorpAmtInvested, CandyCorpGrowthRate);
    	PetCoReturn = simCalc.getCompanyReturn(PetCoAmtInvested, PetCoGrowthRate);

    	bank.setAmtInvested(bankAmtInvested + bankReturn);
    	ToysInc.setAmtInvested(ToysIncAmtInvested + ToysIncReturn);
    	CandyCorp.setAmtInvested(CandyCorpAmtInvested + CandyCorpReturn);
    	PetCo.setAmtInvested(PetCoAmtInvested + PetCoReturn);*/
    }
    
    public void updateBalance() {
    	
    	//generateCompanyGrowthRates();
    	//generateCompanyReturns();
    	
    	totalInvested = simCalc.calcTotalInvestments(bank.getAmtInvested(), 
    												  ToysInc.getAmtInvested(),
    												  CandyCorp.getAmtInvested(),
    												  PetCo.getAmtInvested());
    	
    	changeInBalance = simCalc.calcChangeInBalance(bankReturn, ToysIncReturn, CandyCorpReturn, PetCoReturn);
    	
/*    	changeInBalance = simCalc.calcChangeInBalance(bank.getAmtInvested(), 
    												  ToysInc.getAmtInvested(),
    												  CandyCorp.getAmtInvested(),
    												  PetCo.getAmtInvested());*/
    	Balance += (totalInvested + changeInBalance);
    }
    
    //Calculates an investment profile based on the user's investment behavior
    public String generateInvestmentProfile() {
    	String investStatus;
    	int originalBalance = Balance + totalInvested;
    	int riskScore = simCalc.calculateRiskScore ( originalBalance,  changeInBalance, totalInvested, 
				ToysInc, CandyCorp, PetCo, bank);
    	return investStatus = simCalc.calculateRiskStatus(riskScore);
    }
    
    //returns a string explanation corresponding to a particular investment profile
    public String getExplanation() {
    	investmentProfile = generateInvestmentProfile();
    	
    	if(investmentProfile.equals("VERY CONSERVATIVE")) {
    		if( changeInBalance >= 0)
    			return VCONSERVATIVE_GAIN;
    		else
    			return VCONSERVATIVE_LOSS;
    	}
    	else if(investmentProfile.equals("CONSERVATIVE")) {
    		if( changeInBalance >= 0)
    			return CONSERVATIVE_GAIN;
    		else
    			return CONSERVATIVE_LOSS;
    	}
		else if(investmentProfile.equals("RISKY")) {
			if( changeInBalance >= 0)
				return RISK_GAIN;
			else
				return CONSERVATIVE_LOSS;
		}
    	else if(investmentProfile.equals("VERY RISKY")) {
    		if( changeInBalance >= 0)
    			return VRISK_GAIN;
    		else
    			return VRISK_LOSS;
    	}  	
    	else if( investmentProfile.equals("SAVER"))
    		return SAVER;
    	else if( investmentProfile.equals("SPENDER"))
    		return SPENDER;
    	else
    		return "Failed to calculate investment profile";
    	
	
    }//getExplanation
    
    public void incrementYear()
	{
		year++;
	}
    
    public void regenerateMarket() {
    	
    	//Rest Values
    	bank.setAmtInvested(0);
    	ToysInc.resetValues();
    	CandyCorp.resetValues();
    	PetCo.resetValues();
                
    	
    	//Reset Change in balance
    	pastBalances[year - 1] = changeInBalance;
    	changeInBalance = 0;
    	
    	
    }
    
    
  //Processes input from simulation view
    public void getInput( String value, char source ) {
    	
    	//convert input to integer
    	int intValue = Integer.parseInt(value);
    	
    	switch(source){
		case 'b':Balance = Balance + bank.getAmtInvested();
				bank.setAmtInvested( intValue );
				Balance = Balance - intValue;
				break;
		case 't': Balance = Balance + ToysInc.getAmtInvested();
				ToysInc.setAmtInvested( intValue );
				Balance = Balance - intValue;
				break;		
		case 'c': Balance = Balance + CandyCorp.getAmtInvested();
				CandyCorp.setAmtInvested( intValue );
				Balance = Balance - intValue;
				break;
		case 'p': Balance = Balance + PetCo.getAmtInvested();
				PetCo.setAmtInvested( intValue );
				Balance = Balance - intValue;
				break; 		
	}
    	
    }//getInput
    
    
    public boolean balanceErrorCheck( String value ) {
    	int intValue = Integer.parseInt(value);
    	if( Balance - intValue < 0 )
    		return false;
    	else
    		return true;
    }
    
}
