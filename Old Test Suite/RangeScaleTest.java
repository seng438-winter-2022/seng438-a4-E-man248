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
	

}
