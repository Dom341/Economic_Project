public class StocksLesson extends BaseLesson {

	public static final String NAME = "What are Stocks?";
	public static final String INFO = "By their nature, every company is owned by somebody. Sometimes, "
			+ "one person owns a whole company while other times, millions of people own a company "
			+ "together. A stock represents a share in the ownership of a company. In the case of the "
			+ "company owned by one person, that person owns all of the stock for that company. In the "
			+ "case of the company owned by millions of people, each person owns one or more shares "
			+ "of the company, and together all of the shares are accounted for."
			+ "\n\n"
			+ "For example, say Toys Inc. has 100 shares that each represent 1% ownership of the "
			+ "company. If Tony has 5 shares, then he has (5 / 100 =) 5% ownership of Toys Inc. If "
			+ "you have 55 shares, then you have (55 / 100 =) 55% ownership of Toys Inc. If Sally "
			+ "has 40 shares, then she has (40 / 100 =) 40% ownership of Toys Inc. Together, you three "
			+ "own all 100 shares, and therefore the company is completely owned by you three."
			+ "\n\n"
			+ "So why would you want to own stock? Every share that you acquire gives you one vote "
			+ "to decide certain things that the company does. If you have over 50% of the shares of "
			+ "a company, then you have the majority voting power and can make decisions by yourself "
			+ "about the company. Another reason to hold stock is that the price of the stock changes "
			+ "depending on the performance of the company. If the company is doing well, the price "
			+ "could go up, meaning you have gained profit over your original purchase price. It is "
			+ "also possible that the company pays dividends to its shareholders. A dividend represents "
			+ "a part of the company’s profits, paid out to the shareholders. "
			+ "\n\n";
	public static final String Q = "Which is not true about stocks?";
	public static final String M1 = "All companies sell stock.";
	public static final String M2 = "Anyone can buy stocks.";
	public static final String M3 = "Companies sell stock to get money.";
	public static final String M4 = "Stocks are units of ownership in a company.";
	public static final String IMG = "stocks.png";
	public static final String CORRECT = M1;
	 
	   /**
        * StocksLesson()
        * Constructor for the StocksLesson class
        */
	   public StocksLesson() {
	      super(NAME, INFO, Q, M1, M2, M3, M4, IMG, CORRECT);
	   }
	   
}
