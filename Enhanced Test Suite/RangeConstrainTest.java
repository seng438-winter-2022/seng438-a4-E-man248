package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeConstrainTest {

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
	public void constrainValueLessThanLowerBound()
	{
		// Setup:
		Range range = new Range(1,5);
		double value = 0;
		
		// Exercise:
		double result = range.constrain(value);
		assertEquals("Output result should be 1", 1, result, .000000001d);
	}
	
	/* Test Case 2: 
	 */
	@Test
	public void constrainValueGreaterThanUpperBound()
	{
		// Setup:
		Range range = new Range(1,5);
		double value = 6;
		
		// Exercise:
		double result = range.constrain(value);
		assertEquals("Output result should be 5", 5, result, .000000001d);
	
	}
	

	/* Test Case 3: 
	 */
	@Test
	public void constrainValueWithinBound()
	{
		// Setup:
		Range range = new Range(1,5);
		double value = 3;
		
		// Exercise:
		double result = range.constrain(value);
		assertEquals("Output result should be 3", 3, result, .000000001d);
	}

}
