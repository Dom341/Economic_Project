

public abstract class Asset {
	
	
	//Private data members
	private int amtInvested;	//the monetary value invested in this asset
	private double assetGrowthRate; //growth rate of asset per unit
	private int riskLevel; //risk level on a scale of 1 - 10, 10 being high risk
	
	
	//SETTERS

	public void setAmtInvested( int amtInvestedArg ) {
		amtInvested = amtInvestedArg;
	}
	public void setAssetGrowthRate( double assetGrowthRateArg ) {
		assetGrowthRate = assetGrowthRateArg;
	}
	public void setRiskLevel( int riskLevelArg ) {
		riskLevel = riskLevelArg;
	}
	
	//GETTERS
	public int getAmtInvested(){
		return amtInvested;
	}
	public double getGrowthRate() {
		return assetGrowthRate;
	}
	public int getRiskLevel() {
		return riskLevel;
	}
	
	
	
	
}//Asset Class
