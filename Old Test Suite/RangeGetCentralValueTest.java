package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeGetCentralValueTest
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
	public void getCentralValueCorrectlyTest()
	{
		// Setup:
		Range range = new Range(1,5);
		
		// Exercise:
		double result = range.getCentralValue();
		assertEquals("Output result should be 3", 3, result, .000000001d);
	}

}
