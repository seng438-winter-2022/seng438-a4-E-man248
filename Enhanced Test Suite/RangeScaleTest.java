package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeScaleTest {

	/* Setup Before Any Test Occurs
	 * 
	 */
	@Before
	public void setupTest()
	{
		// No General Setup
	}

	/* Test Case 1: 
	 * The scale factor passed in is a value less than 0
	 */
	@Test
	public void scaleFactorLessThanZero()
	{
		double factor = -1;
		Range base = new Range(2.0,3.0);
		try
		{
			Range result = Range.scale(base, factor);
			fail("Null not permitted, failed test");
		}
		catch(Exception e) {
			
		}
	}
	

	/* Test Case 2: 
	 * The scale factor passed in is a value less than 0
	 */
	@Test
	public void scaleFactorEqualZeroMutationTest()
	{
		double factor = 0;
		Range base = new Range(0, 0);
		try
		{
			Range result = Range.scale(base, factor);
			assertEquals(0, result.getLowerBound(), 0.000001f);
			assertEquals(0, result.getUpperBound(), 0.000001f);
		}
		catch(Exception e) {
			fail();
		}
	}
	

	

	/* Test Case 2: 
	 * The scale factor passed in is a value less than 0
	 */
	@Test
	public void scaleFactorNormalMutationTest()
	{
		double factor = 1;
		Range base = new Range(1, 3);
		try
		{
			Range result = Range.scale(base, factor);
			assertEquals(1, result.getLowerBound(), 0.000001f);
			assertEquals(3, result.getUpperBound(), 0.000001f);
		}
		catch(Exception e) {
			fail();
		}
	}
	
	
	@Test
	public void shiftNullMutantTest(){
		try 
		{
			double factor = 1;
			Range base = null;
			Range result = Range.scale(base, factor);
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
