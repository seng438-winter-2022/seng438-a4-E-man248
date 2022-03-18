//Priyanka Gautam 
//30091244

package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class RangeExpandTest {


	@Before
	public void setUp() {
		//No setup needed
	}

	
/*In this test case, all appropriate values are being tested. This covers one branch of if statement*/
	@Test
	public void RangeAppropriateValuesTest() {
		Range range = new Range(11,20);
		double lowerMargin = 5; 
		double upperMargin =6; 
		// getlength() returns 20-10 = 9
		Range result = Range.expand(range, lowerMargin, upperMargin);
		assertEquals(-34.0,result.getLowerBound(),  .000000001d);
		assertEquals(74,result.getUpperBound(), .000000001d);
		
		
	}
	/* In this test case, when the new lower margin is calculated, it will actually result in being greater than the upper margin
	 * which covers the second branch of the if statement. Since lowerMargin > upperMargin, the if statement is executed
	 * and new lower and upper margins are evaluated*/
	@Test
	public void RangeLowerRangeGreaterTest() {
		Range range = new Range(11,20);
		double lowerMargin = -5; //56
		double upperMargin = -4; //-16
		// getlength() returns 20-10 = 9
		Range result = Range.expand(range, lowerMargin, upperMargin);
		assertEquals(20.0,result.getLowerBound(),  .000000001d);
		assertEquals(20.0,result.getUpperBound(), .000000001d);
		
		
	}
	

	/* In this test case, when the new lower margin is calculated, it will actually result in being greater than the upper margin
	 * which covers the second branch of the if statement. Since lowerMargin > upperMargin, the if statement is executed
	 * and new lower and upper margins are evaluated*/
	@Test
	public void RangeLowerRangeEqualTest() {
		Range range = new Range(11,14);
		double lowerMargin = -5; //56
		double upperMargin = -5; //-16
		// getlength() returns 20-10 = 9
		Range result = Range.expand(range, lowerMargin, upperMargin);
		assertEquals(12.5,result.getLowerBound(),  .000000001d);
		assertEquals(12.5,result.getUpperBound(), .000000001d);
		
		
	}


	@Test
	public void ExpandNullMutantTest(){
		try 
		{
			Range range = null;
			double lowerMargin = -5; //56
			double upperMargin = -5; //-16
			Range result = Range.expand(range, lowerMargin, upperMargin);
			fail();
		}
		catch (Exception e)
		{
			if (!(e instanceof IllegalArgumentException))
			{
				fail();
			}
		}
	}
	

}
