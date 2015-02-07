public class MarketLesson extends BaseLesson {

	public static final String NAME = "What is the Market?";
	public static final String INFO = "The stock market is a market for stocks – a place for anyone to "
			+ "buy and sell shares in different companies in the hopes of either acquiring control of a "
			+ "company or making a profit off of the sales. Stocks are traded through stock exchanges "
			+ "like the New York Stock Exchange (NYSE) or the NASDAQ. In order to be traded on an "
			+ "exchange, a company’s stock has to be made public, often during a one-time sale called "
			+ "an initial public offering, during which anyone can buy the stock directly from the "
			+ "company. The people that trade stocks in the stock market are varied – some are "
			+ "individual investors, some are huge institutions like banks and others are professionals "
			+ "whose job it is to trade every day on the stock market."
			+ "\n\n"
			+ "The collection of all of the stocks that you own is called your portfolio. For example, "
			+ "if Toy Inc.’s stock is $10 and you have 8 shares, Cookie Corp.’s stock is $5 and you have "
			+ "20 shares and Candy Co.’s stock is $25 and you have 3 shares, you have ($10 x 8 + $5 x 20 "
			+ "+ $25 x 3 =) $255 in your portfolio. ($10 x 8 =) $80 worth of Toy Inc. shares, ($5 x 20 =) "
			+ "$100 worth of Cookie Corp.’s shares and ($25 x 3 =) $75 worth of Candy Co.’s shares. "
			+ "\n\n\n\n\n";
	public static final String Q = "According to the stock prices above, which gives you the largest "
			+ "amount of money in your portfolio?";
	public static final String M1 = "5 shares of Toy Inc., 20 shares of Cookie Corp., 3 shares of Candy Co.";
	public static final String M2 = "10 shares of Toy Inc., 10 shares of Cookie Corp., 1 share of Candy Co.";
	public static final String M3 = "3 shares of Toy Inc., 10 shares of Cookie Corp., 10 shares of Candy Co.";
	public static final String M4 = "15 shares of Toy Inc., 10 shares of Cookie Corp., 8 shares of Candy Co.";
	public static final String IMG = "market.png";
	public static final String CORRECT = M4;
	 
	  /**
       * MarketLesson()
       * Constructor for the MarketLesson class
       */
	   public MarketLesson() {
	      super(NAME, INFO, Q, M1, M2, M3, M4, IMG, CORRECT);
	   }
	   
}
