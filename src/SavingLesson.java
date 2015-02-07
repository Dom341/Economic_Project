
public class SavingLesson extends BaseLesson {

	public static final String NAME = "What is Savings?";
	public static final String INFO = "Have you ever really wanted to buy something, but you’ve "
			+ "already spent all of your allowance? Then you already know why it is important to "
			+ "save money! Saving money and keeping it so that you can spend it later is important "
			+ "for a number of reasons and is one of the most important things to understand about "
			+ "your finances."
			+ "\n\n"
			+ "Suppose you want to buy something that costs more than one week’s worth of "
			+ "allowance. For example, say your allowance ever week is $20 and you want to buy a "
			+ "guitar that is $55. Then you could spend that $20 that you get every week and never "
			+ "have enough money to buy the guitar, or you could not spend any money for 3 weeks and "
			+ "buy the guitar and have $5 left over. Or you could spend $15 of your $20 allowance "
			+ "every week and in ($55/$5 =) 11 weeks you could buy your guitar with the saved money."
			+ "\n\n"
			+ "Saving money for bigger purchases isn’t the only reason to save money. What if you have "
			+ "an emergency that costs a lot of money? How would you pay for this if you don’t have "
			+ "extra money saved? Or maybe you want to help your parents pay for your college, even "
			+ "though that is far into the future. If you start putting a small amount of money into "
			+ "a bank now, then by the time you are in college, you will have a lot of money. "
			+ "\n\n\n\n";
	public static final String Q = "What is one thing you should not do in order to save money?";
	public static final String M1 = "Set goals";
	public static final String M2 = "Have a strategy for saving money";
	public static final String M3 = "Cut back";
	public static final String M4 = "Spend more";
	public static final String IMG = "saving.png";
	public static final String CORRECT = M4;
	 
	    /**
         * SavingLesson()
         * Constructor for the SavingLesson class
         */
	   public SavingLesson() {
	      super(NAME, INFO, Q, M1, M2, M3, M4, IMG, CORRECT);
	   }
	   
}