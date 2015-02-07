
public class RiskLesson extends BaseLesson {

	public static final String NAME = "What is Risk?";
	public static final String INFO = "Investing money seems like a great deal so far, as the amount "
			+ "of money you put in to start always becomes bigger as time goes on. However, in the real "
			+ "world every investment (including the bank) has some risk associated with it. Any stock "
			+ "that you invest in could go up or down depending on a huge number of factors, and even the "
			+ "best professional investors in the world can’t predict everything that will happen with "
			+ "the economy. Therefore, it is important to be very careful when investing money into "
			+ "stocks and to never put more money into something than you are willing to lose. "
			+ "Understanding risk is important to investing."
			+ "\n\n"
			+ "For example, say Toy Inc.’s stock has a 30% chance of decreasing by 40%, a 50% "
			+ "chance of increasing by 24% and a 20% chance of increasing by 50%. On average, over "
			+ "any given year the stock will increase by (.3 x -.40 + .5 x .24 + .2 x .5 =) 10%. However, "
			+ "if you invest $100 at the beginning of the year, there is a 30% chance that you will have "
			+ "only $60 at the end of the year. That represents a significant loss that must be "
			+ "factored in. "
			+ "\n\n\n\n\n\n";
	public static final String Q = "If a stock has more risk, it means ________.";
	public static final String M1 = "its value is guaranteed to rise.";
	public static final String M2 = "the company and investors have a higher chance of losing money.";
	public static final String M3 = "its value is guaranteed to go down.";
	public static final String M4 = "you don't have to be careful investing in it.";
	public static final String IMG = "risk.png";
	public static final String CORRECT = M2;
	 
	    /**
         * RiskLesson()
         * Constructor for the RiskLesson class
         */
	   public RiskLesson() {
	      super(NAME, INFO, Q, M1, M2, M3, M4, IMG, CORRECT);
	   }
	   
}
