public class InterestLesson extends BaseLesson {

	public static final String NAME = "What is Interest?";
	public static final String INFO = "Banks hold people’s money for them. People feel safe putting "
			+ "their money into banks because they are secure and the money is easy to get out. But "
			+ "it is also possible to store your money, say, under your mattress and it would be easy "
			+ "to access. So why put your money into a bank? The bank regularly pays you a small "
			+ "percentage of the money that you deposited, called interest, to encourage you to put "
			+ "your money into the bank rather than holding it under your mattress."
			+ "\n\n"
			+ "For example, say you put $100 in a bank account with an interest rate of 5% (.05) "
			+ "annually compounding. After one year, you will have ($100 x (1 + .05)) = $105 in your "
			+ "account. Banks use compounding interest, which means that the interest that you got "
			+ "after year one is also included in the computation for the next period. After two "
			+ "years, you will have ($105 x (1 + .05)) = $110.25. After two years, the bank has paid "
			+ "you $10.25 to store your $100 with them."
			+ "\n\n"
			+ "As time goes on, prices of all things go up by an amount called inflation. Using a bank "
			+ "and earning interest is one way to make sure that your money is always going to be worth "
			+ "the same or more, year after year. "
			+ "\n\n\n\n";
	public static final String Q = "What do banks do?";
	public static final String M1 = "Keep money safe and hold money in accounts";
	public static final String M2 = "Help you spend money foolishly by lending you more";
	public static final String M3 = "Take your money";
	public static final String M4 = "Invest money into stocks for you";
	public static final String IMG = "interest.png";
	public static final String CORRECT = M1;
	 
	    /**
	     * InterestLesson()
	     * Constructor for the InterestLesson class
	     */
		public InterestLesson() {
		  super(NAME, INFO, Q, M1, M2, M3, M4, IMG, CORRECT); 
		  
	    }	   
}
