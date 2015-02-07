
public class Company extends Asset  {

	private static String companyName;
	private static String companyDescription;
	private double maxGrowthRate;
	private double minGrowthRate;
	
	
	Company( String compName, String description, int riskLevel,
										double maxGrowRt, double minGrowRt) {
		
		companyName = compName;
		companyDescription = description;
		setRiskLevel(riskLevel);
		maxGrowthRate = maxGrowRt;
		minGrowthRate = minGrowRt;
		
	}//company constructor
	
	public String getCompanyName() {
		return companyName;
	}
	public String getCompanyDescription() {
		return companyDescription;
	}
	public double getMaxGrowthRate() {
		return maxGrowthRate;
	}
	public double getMinGrowthRate() {
		return minGrowthRate;
	}
	public void resetValues() {
			setAmtInvested(0);
		}
	
	}//Company Class
	
	

