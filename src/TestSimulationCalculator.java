import static org.junit.Assert.*;

import org.junit.Test;


public class TestSimulationCalculator {

	SimulationCalculator simCalc = new SimulationCalculator();
	
	//Can't test because of randomness
	@Test
	public void testCalcGrowthRate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCompanyReturn() {
		
		int amtInvested = 100;
		double growthRate = .25;
		int result;
		
		result = simCalc.getCompanyReturn(amtInvested, growthRate);
		
		assertEquals(25, result);
		
	}

	@Test
	public void testCalcTotalInvestments() {
		
		int a = 50;
		int b = 20;
		int c = 25;
		int d = 50;
		int result;
		
		result = simCalc.calcTotalInvestments(a, b, c, d);
		
		assertEquals(145, result);
	}

	@Test
	public void testCalculateRiskStatus() {
		
		int riskScore = 6;
		String result;
		
		result = simCalc.calculateRiskStatus(riskScore);
		
		assertEquals("RISKY", result);
	}

}
