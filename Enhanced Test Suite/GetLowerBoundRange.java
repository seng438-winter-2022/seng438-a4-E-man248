package org.jfree.data.test;

import static org.junit.Assert.*;


import org.jfree.data.Range;

import org.junit.Test;

/*
 * Author: Priyanka Gautam 
 * UCID : 30091244
 * 
*/

public class GetLowerBoundRange {
	
	/*
	 * Setting a private variable values of type Range in order to use it in the test cases
	*/
private Range values; 
	

	//TEST 1
	/*The result variable stores the return value from the getLowerBound()
	 * Here the values is initialized to a new Range where the lower bound is 1.0 and the upper bound is 5.0. We are asserting to see if the result == 1.0
	*/
	@Test
	public void testLowerBound() {
		values = new Range (1.0,5.0);
		double result = values.getLowerBound();
		assertEquals(1.0, result,.000000001d);
	}
	
	
	//TEST 2
	/* The result variable stores the return value from the getLowerBound()
	 * Here the values is initialized to a new Range where the lower bound is -6.0 and the upper bound is 3.0. We are asserting to see if the result == -6.0
	*/
	@Test 
	public void testLowerBoundUpperLimitPositive() {
		values = new Range (-6.0, 3.0);
		
		double result = values.getLowerBound();
		assertEquals(-6.0, result,.000000001d);
		
	}
	//TEST 3
	/*The result variable stores the return value from the getLowerBound()
	 * Here the values is initialized to a new Range where the lower bound is -6.0 and the upper bound is -3.0. We are asserting to see if the result == -6.0
	*/
		@Test 
		public void testLowerBoundBothLimitNegative() {
			values = new Range (-6.0, -3.0);
			
			double result = values.getLowerBound();
			assertEquals(-6.0, result,.000000001d);
			
		}
	

}
