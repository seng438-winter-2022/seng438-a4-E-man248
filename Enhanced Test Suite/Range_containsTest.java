/**
 * @author Gibran Akmal <a href="mailto:gibran.akmal@ucalgary.ca">gibran.akmal@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 * UCID: 30094918
 * SENG 438 - Assignment 2
 * Group 31 
 * February 9, 2022
 */
//method 'contains(double value)' within class 'Range' subject to testing


//required libraries imported
package org.jfree.data.test;
import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Test;

//test class for method
public class Range_containsTest 
{
	//contains(double value) is not as static method, therefore we need to create an object of it 
	//private Range object initialized with lower bound of 13.0 and upper bound of 31.0
	private Range range = new Range(13.0, 31.0);

	//Test Case 1 (value within range)
	@Test
	public void contains_trueTest() 
	{
		//result variable holds true/false
		boolean result = range.contains(13.31);
		
		//assert weather resulting boolean matches our expected boolean value of 'true'
		assertEquals(true, result);
	}
	
	//Test Case 2 (value out of range)
	@Test
	public void contains_falseTest() 
	{
		//result variable holds true/false
		boolean result = range.contains(31.13);
		
		//assert weather resulting boolean matches our expected boolean value of 'false'
		assertEquals(false, result);
	}
	

	//Test Case 2 (value out of range)
	@Test
	public void contains_EqualToLowerMutantTest() 
	{
		//result variable holds true/false
		boolean result = range.contains(13.0);
		
		//assert weather resulting boolean matches our expected boolean value of 'false'
		assertEquals(true, result);
	}
	


	//Test Case 2 (value out of range)
	@Test
	public void contains_EqualToUpperMutantTest() 
	{
		//result variable holds true/false
		boolean result = range.contains(31.0);
		
		//assert weather resulting boolean matches our expected boolean value of 'false'
		assertEquals(true, result);
	}

}
