package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


/*
 * This is a test class designed for the Clone method
 */
public class DataUtilitiesCloneTest {

	@Before
	public void setupTests()
	{
		// No Setup Needed!
	}

	/* Test Cases 1: 
	 * This test case tests an input source double of null
	 * and tests to see if the function clones back a double of null
	 * The test case passes
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void sourceIsNull() {
		try {
			double[][] testSource = DataUtilities.clone(null);
			fail("Null not permitted, failed test");
		}
		catch(Exception e) {
			if (e instanceof NullPointerException) fail();	
		}
	}
	
	/* Test Cases 2: 
	 * This test case tests an input source double that are valid
	 * and tests to see if the function clones back that same double
	 * The test case passes
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void sourceIsValid() {
		double[][] testSource = {{0,1}, {1,0}};
		assertEquals(testSource, DataUtilities.clone(testSource));
	}
	
	/* Test Cases 3: 
	 * This test case tests an input source double where one element is null
	 * and tests to see if the function clones back with that same double
	 * The test case passes
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void sourceElementIsNULL() {
		double[][] testSource = {null, {1,0}};
		assertEquals(testSource, DataUtilities.clone(testSource));
	}
	
}
