package org.jfree.data.test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class RangeExpandToIncludeTest {

	@Before
	public void setupTests()
	{
		// No Setup Needed!
	}
	
	/* Test Case 1:
	 * Testing if Range is null, if it is returns a new of range of equal double value
	 * Test Passes
	 */
	@Test
	public void rangeIsNull() {
		Range test = null;
		double doubleTest = 1.0;
		
		Range value = new Range(doubleTest,doubleTest);
		Range result = Range.expandToInclude(test, doubleTest);
		assertEquals(value,result);
	}
	
	/* Test Case 2:
	 * Testing if Range is NOT null, if it is returns that range
	 * Test Passes
	 */
	@Test
	public void rangeIsNotNull() {
		Range test = new Range(1.0,1.0);
		double doubleTest = 1.0;
		
		Range value = new Range(doubleTest,doubleTest);
		Range result = Range.expandToInclude(test, doubleTest);
		assertEquals(value,result);
	}
	
	/* Test Case 3:
	 * Testing if value is less than the lower bound, if it is returns a new range of the value and the upper bound
	 * Test Passes
	 */
	@Test
	public void lessThanLower() {
		double value = 0.5;
		Range range = new Range(1.0,2.0);
		
		Range shouldEqual = new Range(value, range.getUpperBound());
		Range result = Range.expandToInclude(range, value);
		assertEquals(shouldEqual,result);
	}
	
	/* Test Case 4:
	 * Testing if value is greater than the upper bound, if it is returns a new range of the value and the lower bound
	 * Test Passes
	 */
	@Test
	public void moreThanUpper() {
		double value = 2.5;
		Range range = new Range(1.0,2.0);
		
		Range shouldEqual = new Range(range.getLowerBound(), value);
		Range result = Range.expandToInclude(range, value);
		assertEquals(shouldEqual,result);
	}
}
