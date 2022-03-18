package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.Before;
import org.junit.Test;

//tells weather or not two list of 2d double arrays are equal
//this class contains tester methods for these test cases
public class DataUtilitiesEqualTest {

	@Before
	/*
	 * This is a test class designed for the CalculateColumnTotal method (with 3 args)
	 */
	public void setupTests()
	{
		// No Setup Needed!
	}
	
	@Test	
	//tells weather or not two list of 2d double arrays are equal
	//if both lists are null then they should be equal
	public void equalAIsNullBIsNullTest()
	{
		double[][] a = null;
		double[][] b = null;
		assertTrue(DataUtilities.equal(a, b));
	}
	
	
	//if a is not null and b is null then they are not equal
	@Test
	public void equalAIsNotNullBIsNullTest()
	{
		double[][] a = {{0,1}, {1,0}};
		double[][] b = null;
		assertFalse(DataUtilities.equal(a, b));
	}
	
	
	//if a is null and b is not null then they are not equal
	@Test
	public void equalAIsNullBIsNotNullTest()
	{
		double[][] a = null;
		double[][] b = {{0,1}, {1,0}};
		assertFalse(DataUtilities.equal(a, b));
	}
	
	//if a and b are not null then we proceed to check
	@Test
	public void equalAandBNotEqualLengths()
	{
		double[][] a = {{0,1}};
		double[][] b = {{0,0}, {1,1}};
		assertFalse(DataUtilities.equal(a, b));
	}
	
	//a and b the lists are completely unequal
	@Test
	public void equalAandBCompletelyNotEqual()
	{
		double[][] a = {{0,1}, {1,0}};
		double[][] b = {{0,0}, {1,1}};
		assertFalse(DataUtilities.equal(a, b));
	}
	
	//part of the lists a and b are equal
	@Test
	public void equalAandBPartiallyEqual()
	{
		double[][] a = {{0,0}, {1,0}};
		double[][] b = {{0,0}, {1,1}};
		assertFalse(DataUtilities.equal(a, b));
	}
	
	//a and b both lists are exactly identical
	@Test
	public void equalAandBCompletelyEqual()
	{
		double[][] a = {{0,0}, {1,1}};
		double[][] b = {{0,0}, {1,1}};
		assertTrue(DataUtilities.equal(a, b));
	}	
	
}
