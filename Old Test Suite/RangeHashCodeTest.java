package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeHashCodeTest {


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
	public void RangeGetCorrectHashCodeTest()
	{
		// Setup:
		Range range = new Range(1,5);
		
		// Exercise:
		double result = range.hashCode();
		System.out.println(result);
		assertEquals("Output result should be 2118385664", 2118385664, result, .000000001d);
	}

}
