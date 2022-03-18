package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeShiftTest
{

	/* Setup Before Any Test Occurs
	 * 
	 */
	@Before
	public void setupTest() {
		// No General Setup
	}

	/* Test Case 1: 
	 */
	@Test
	public void shiftBaseRangeIsNull()
	{
		// Setup:
		Range base = null;
		double delta = 1;
		
		// Exercise:
		try
		{
			Range result = Range.shift(base, delta);
			fail("Null not permitted, failed test");
		}
		catch(Exception e)
		{
			
		}
			
	}

	/* Test Case 2: 
	 */
	@Test
	public void shiftNotAllowingZeroCrossingWithDeltaNotEqualZero()
	{
		// Setup:
		Range base = new Range(1,5);
		double delta = 1;
			
		// Exercise:
		Range result = Range.shift(base, delta);
		assertEquals("Output lower bound should be 2", 2, result.getLowerBound(), .000000001d);
		assertEquals("Output upper bound should be 6", 6, result.getUpperBound(), .000000001d);
	}
	

	/* Test Case 2: 
	 */
	@Test
	public void shiftNotAllowingZeroCrossingWithDeltaNotEqualZeroNegativeMutant()
	{
		// Setup:
		Range base = new Range(-1,5);
		double delta = 1;
			
		// Exercise:
		Range result = Range.shift(base, delta);
		assertEquals("Output lower bound should be 0", 0, result.getLowerBound(), .000000001d);
		assertEquals("Output upper bound should be 6", 6, result.getUpperBound(), .000000001d);
	}

	/* Test Case 2: 
	 */
	@Test
	public void shiftNotAllowingZeroCrossingWithDeltaNotEqualZeroBothNegative()
	{
		// Setup:
		Range base = new Range(-10,-5);
		double delta = 1;
			
		// Exercise:
		Range result = Range.shift(base, delta);
		assertEquals("Output lower bound should be -9", -9, result.getLowerBound(), .000000001d);
		assertEquals("Output upper bound should be -4", -4, result.getUpperBound(), .000000001d);
	}
	
	
	/* Test Case 2: 
	 */
	@Test
	public void shiftNotAllowingZeroCrossingAdditionMutationTest()
	{
		// Setup:
		Range base = new Range(1,5);
		double delta = -1;
			
		// Exercise:
		Range result = Range.shift(base, delta);
		assertEquals("Output lower bound should be 0", 0, result.getLowerBound(), .000000001d);
		assertEquals("Output upper bound should be 4", 4, result.getUpperBound(), .000000001d);
	}

	/* Test Case 3: 
	 */
	@Test
	public void shiftAllowZeroCrossingGivenZero()
	{
		// Setup:
		Range base = new Range(1,5);
		double delta = 0;
			
		// Exercise:
		Range result = Range.shift(base, delta, true);
		assertEquals("Output lower bound should be 1", 1, result.getLowerBound(), .000000001d);
		assertEquals("Output upper bound should be 5", 5, result.getUpperBound(), .000000001d);
	}
	
	/* Test Case 3: 
	 */
	@Test
	public void shiftAllowZeroCrossingGivenZeroMutantTrue()
	{
		// Setup:
		Range base = new Range(1,5);
		double delta = 0;
			
		// Exercise:
		Range result = Range.shift(base, delta, false);
		assertEquals("Output lower bound should be 1", 1, result.getLowerBound(), .000000001d);
		assertEquals("Output upper bound should be 5", 5, result.getUpperBound(), .000000001d);
	}
	

	@Test
	public void shiftNullMutantTest(){
		try 
		{
			Range base = null;
			double delta = 0;
				
			// Exercise:
			Range result = Range.shift(base, delta, false);
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