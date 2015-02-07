import java.util.Random;


public class SimulationCalculator {
	
	/*
	 * Implement calculation methods here 
	 * These methods will typically be called in the controller class
	 * based on information obtained from the view
	 * 
	 */
	
	private int globalMarketRandom = 0;
	
	public void SimulationCalculator() {
		//create a global random variable
		Random random = new Random();
		
		globalMarketRandom = random.nextInt(48) + 1;
	}
	
	public double calcGrowthRate(int riskLevel, double maxGrowth, double minGrowth) {
		
		//Set up randomness inherent in the simulator
		Random random = new Random();
		int companyRandom = 0;
		companyRandom = random.nextInt(98) + 1;
		int randomTotal = globalMarketRandom + companyRandom;
		
		double range = maxGrowth - minGrowth;
		
		double pointsAboveMinimum = (range / 150) * randomTotal;
		
		double growthRate = minGrowth + pointsAboveMinimum;
		
		return growthRate * 5;
		
		//return 0.5; //temporary number for testing purposes
	}

	public int getCompanyReturn(int amtInvested, double growthRate) {
		
		int companyReturn = 0;
		
		if(growthRate > 0)
		{
			companyReturn = (int) Math.ceil(amtInvested * growthRate);
		}
		else if(growthRate < 0)
		{
			companyReturn = (int) Math.floor(amtInvested * growthRate);
		}
		
		return companyReturn;
	}
		
	//calculates the total sum of money that was invested
	public int calcTotalInvestments( int savings, int toysInvestment, int candycorpInvestment, int petcoInvestment) {
		
		int totalInvestment = savings + toysInvestment + candycorpInvestment + petcoInvestment;
		return totalInvestment;
	}

	//calculates the total change in the balance
	public int calcChangeInBalance(int bankReturn, int toysIncReturn,
			int candyCorpReturn, int petCoReturn) {

		int changeInBalance = bankReturn + toysIncReturn + candyCorpReturn + petCoReturn;
		
		return changeInBalance;
	}//calcChangeInBalance
	
	//calculates risk score on a scale of 0-12
	public int calculateRiskScore ( int balance /*balance + totalInvestments*/, int changeInBalance, int totalInvestments, 
														Company ToysInc, Company CandyCo, Company PetCo, Bank bank) {
		int riskScore = 0;
		
		
		if((bank.getAmtInvested() > 0) && (bank.getAmtInvested() == totalInvestments)) {
			riskScore = 13;	//SAVER
		}	
		else if(totalInvestments != 0) {
				if( (balance/(totalInvestments-bank.getAmtInvested())) < 2 )	//if you invested more than 50% of balance
					riskScore++;
				if( (balance/(totalInvestments-bank.getAmtInvested())) < 1.34 ) //if you invested more than 75% of balance
					riskScore++;
				if( (balance/changeInBalance) < 2 ) //if balance changed by more than 50%
					riskScore++;
				if( (balance/changeInBalance) < 1.34 ) //if balance changed by more than 75%
					riskScore++;
				
				int saved = bank.getAmtInvested();
				int toysIncAmt = ToysInc.getAmtInvested();
				int candyCoAmt = CandyCo.getAmtInvested();
				int petCoAmt = PetCo.getAmtInvested();
					
				if( petCoAmt > toysIncAmt && petCoAmt > candyCoAmt )	//if invested mostly in PetCo
					riskScore += 2;
				if ( candyCoAmt > petCoAmt && candyCoAmt > toysIncAmt)	//if invested mostly in CandyCo
					riskScore++;
				if ( petCoAmt == 0 && toysIncAmt == 0 )	//only invested in CandyCo
					riskScore ++;
				if (candyCoAmt == 0 && toysIncAmt == 0 ) //only invested in PetCo
					riskScore += 2;
				
				if( bank.getAmtInvested() == 0 )	//if did not save any money in the bank
					riskScore ++;
		}//if
		else
		{
			riskScore = -1; //SPENDER
		}
	
		return riskScore;
				
	}//calculateInvestorProfile
	
	
	public String calculateRiskStatus( int riskScore ) {
		String riskStatus;
		
		if( riskScore >= 0 && riskScore < 3 )	//between 0 and 3
			riskStatus = "VERY CONSERVATIVE";
		else if( riskScore >= 3 && riskScore < 6 )	//between 3 and 6
			riskStatus = "CONSERVATIVE";
		else if( riskScore >= 6 && riskScore < 9 )	//between 6 and 9
			riskStatus = "RISKY";
		else if ( riskScore >= 9 && riskScore < 12 )	//between 9 and 12
			riskStatus = "VERY RISKY";
		else if( riskScore >= 12 )
			riskStatus = "SAVER";
		else
			riskStatus = "SPENDER";
		
		return riskStatus;
	}

}
