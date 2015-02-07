import static org.junit.Assert.*;

import org.junit.Test;

/**
 * class TestLesson
 * Creates a TestLesson object and uses Unit Tests to test the methods of BaseLesson
 */
public class TestLesson {
	
	/**
	 * class UnitTestLesson
	 * Create lesson object to test constructor
	 */
	public class UnitTestLesson extends BaseLesson {

			public static final String NAME = "name";
			public static final String INFO = "info";
			public static final String Q = "q";
			public static final String M1 = "m1";
			public static final String M2 = "m2";
			public static final String M3 = "m3";
			public static final String M4 = "m4";
			public static final String IMG = "stocks.png";
			public static final String CORRECT = M1;
			
			/*
			 * constructor for UnitTestLesson
			 */
			public UnitTestLesson() {
			      super(NAME, INFO, Q, M1, M2, M3, M4, IMG, CORRECT);
			   } 
		}
	
	/**
	 * testConstructor()
	 * Tests that the correct variable is passed into BaseLesson's answer variable
	 */
	@Test
	public void testConstructor() {
		
		//Variables
		UnitTestLesson testLesson = new UnitTestLesson();
		String result;
		
		//Check correct variable assignment
		result = testLesson.answer;
		
		//Test result
		assertEquals("m1",result);
	}
	
	/**
	 * testCheckCorrect()
	 * Test the checkCorrect() method of the BaseLesson class
	 */
	@Test
	public void testCheckCorrect() {
		
		//Variables
		UnitTestLesson testLesson = new UnitTestLesson();
		boolean result;
		
		//Check correct answer
		result = (testLesson.rb1.getText() == testLesson.answer);
		
		//Test result
		assertTrue(result);
	}

}
