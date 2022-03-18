package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class RangeCombineIgnoringNaNTest {

	/* Setup Before Any Test Occurs
	 * 
	 */
	@Before
	public void setupTest()
	{
		// No General Setup
	}

	/* Test Case 1: 
	 */
	@Test
	public void combineRange1IsNull()
	{
		// Setup:
		Range range1 = null;
		Range range2 = new Range(2.0,3.0);
			
		// Exercise:
		Range result = Range.combineIgnoringNaN(range1, range2);
		assertEquals("Output lower bound should be 2", 2, result.getLowerBound(), .000000001d);
		assertEquals("Output upper bound should be 3", 3, result.getUpperBound(), .000000001d);
	}
	
	/* Test Case 2: 
	 */
	@Test
	public void combineRange1IsNullAndRange2IsNaN()
	{
		// Setup:
		Range range1 = null;
		Range range2 = new Range(Double.NaN, Double.NaN);
			
		// Exercise:
		Range result = Range.combineIgnoringNaN(range1, range2);
		assertNull("Output should be null", result);
	}
	
	/* Test Case 3: 
	 */
	@Test
	public void combineRange2IsNullAndNotNaN()
	{
		// Setup:
		Range range1 = new Range(1.0,5.0);
		Range range2 = null;
			
		// Exercise:
		Range result = Range.combineIgnoringNaN(range1, range2);
		assertEquals("Output lower bound should be 1", 1, result.getLowerBound(), .000000001d);
		assertEquals("Output upper bound should be 5", 5, result.getUpperBound(), .000000001d);
	}
	
	/* Test Case 4: 
	 */
	@Test
	public void combineRange2IsNullAndRange1IsNaN()
	{
		// Setup:
		Range range1 = new Range(Double.NaN, Double.NaN);
		Range range2 = null;
			
		// Exercise:
		Range result = Range.combineIgnoringNaN(range1, range2);
		assertNull("Output should be null", result);
	}
	
	/* Test Case 5:
	 */
	@Test
	public void combineNoNullParams()
	{
		// Setup:
		Range range1 = new Range(1.0,5.0);
		Range range2 = new Range(2.0,3.0);
			
		// Exercise:
		Range result = Range.combineIgnoringNaN(range1, range2);
		assertEquals("Output lower bound should be 1", 1, result.getLowerBound(), .000000001d);
		assertEquals("Output upper bound should be 5", 5, result.getUpperBound(), .000000001d);
	}
	

	/* Test Case 6:
	 */
	@Test
	public void combineBothParamsNull()
	{
		// Setup:
		Range range1 = null;
		Range range2 = null;
					
		// Exercise:
		Range result = Range.combineIgnoringNaN(range1, range2);
		assertNull("Output should be null", result);
	}
	

	/* Test Case 7:
	 */
	@Test
	public void combineBothParamsMakeANaNResult()
	{
		// Setup:
		Range range1 = new Range(Double.NaN, Double.NaN);
		Range range2 = new Range(Double.NaN, Double.NaN);
					
		// Exercise:
		Range result = Range.combineIgnoringNaN(range1, range2);
		assertNull("Output should be null", result);
	}
	


	
	


}
