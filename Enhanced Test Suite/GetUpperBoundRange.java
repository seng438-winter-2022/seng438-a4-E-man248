package org.jfree.data.test;

import static org.junit.Assert.*;


import org.jfree.data.Range;

import org.junit.Test;
/*
 * Author: Priyanka Gautam 
 * UCID : 30091244
 * 
*/

public class GetUpperBoundRange {
	
	/*
	 * Setting a private variable values of type Range in order to use it in the test cases
	*/
private Range values; 
	
	//TEST 1
	/*The result variable stores the return value from the getUpperBound()
	 * Here the values is initialized to a new Range where the lower bound is 1.0 and the upper bound is 5.0. We are asserting to see if the result == 5.0
	*/
	@Test
	public void testUpperBoundBothPositive() {
		values = new Range (1.0,5.0);
		double result = values.getUpperBound();
		assertEquals(5.0, result,.000000001d);
	}
	
	//TEST 2
	/* The result variable stores the return value from the getUpperBound()
	 * Here the values is initialized to a new Range where the lower bound is -6.0 and the upper bound is 3.0. We are asserting to see if the result == 3.0
	*/
		@Test 
		public void testUpperBoundLowerNegative() {
			values = new Range (-6.0, 3.0);
			
			double result = values.getUpperBound();
			assertEquals(3.0, result,.000000001d);
			
		}
	//TEST 3
		/*The result variable stores the return value from the getUpperBound()
		 * Here the values is initialized to a new Range where the lower bound is -6.0 and the upper bound is -3.0. We are asserting to see if the result == -3.0
		*/
	@Test 
	public void testUpperBoundBothNegative() {
		values = new Range (-6.0, -3.0);
		
		double result = values.getUpperBound();
		assertEquals(-3.0, result,.000000001d);
		
	}
	
	
	
	

}
