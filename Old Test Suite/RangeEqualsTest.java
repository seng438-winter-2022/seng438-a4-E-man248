package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeEqualsTest
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
	public void equalsBothRangesNull()
	{
		// Setup:
		Range range1 = null;
		Range range2 = null;
		
		// Exercise:
		try
		{
			boolean result = range1.equals(range2);
			fail("Null not permitted, failed test");
		}
		catch(Exception e)
		{
			
		}
			
	}

	/* Test Case 2: 
	 */
	@Test
	public void equalsRange2IsNotARange()
	{
		// Setup:
		Range range1 = new Range(1,5);
		Object range2 = new Object();
		
		// Exercise:
		boolean result = range1.equals(range2);
		assertFalse("Output should be false!", result);
	}
	


	/* Test Case 3: 
	 */
	@Test
	public void equalsUpperBoundsNotEqaul()
	{
		// Setup:
		Range range1 = new Range(1,5);
		Object range2 = new Range(1,6);
		
		// Exercise:
		boolean result = range1.equals(range2);
		assertFalse("Output should be false!", result);
	}
	
	/* Test Case 4: 
	 */
	@Test
	public void equalsLowerBoundsNotEqaul()
	{
		// Setup:
		Range range1 = new Range(1,5);
		Object range2 = new Range(2,5);
		
		// Exercise:
		boolean result = range1.equals(range2);
		assertFalse("Output should be false!", result);
	}
}
