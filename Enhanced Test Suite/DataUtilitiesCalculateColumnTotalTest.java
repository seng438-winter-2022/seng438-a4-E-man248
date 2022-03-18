package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * This is a test class designed for the CalculateColumnTotal method 
 */
public class DataUtilitiesCalculateColumnTotalTest {
	
	Mockery mockingContext;
	Values2D values;
	
	/* 
	 * Test Setup: Setup function played before every test.
	 * For this set up function, the Mockery used to make the
	 * mock as well as the Values2D class mock have been instantiated.
	 */
	@Before
	public void beforeTestSetup()
	{
	    // setup
		mockingContext = new Mockery();
	    values = mockingContext.mock(Values2D.class);
	}
	
	// Test Tear-Down: Clean-up function played after every test
	@After
	public void afterTestTakedown()
	{
	    // tear-down: NONE in this test method
	}
	
	@Test
	public void calculateColumnTotalNullMutantTest(){
		try 
		{
			values = null;
			double result = DataUtilities.calculateColumnTotal(values, 1);
			fail();
		}
		catch (Exception e)
		{
			if (!(e instanceof IllegalArgumentException))
			{
				fail();
			}
		}
	}
	
	
	
	/* 
	 * Test 4: This test case tests the intersects function under the following conditions:
	 *  - The Values2D object pointer, values, is not null
	 *  - The column index is not less than zero
	 *  - An invalid column index is not chosen (exists)
	 */
	@Test
	public void calculateColumnTotalForTwoValues() {
	    mockingContext.checking(new Expectations() {
	        {
	            one(values).getRowCount();
	            will(returnValue(2));
	            
	            one(values).getValue(0, 0);
	            will(returnValue(5));
	            
	            one(values).getValue(1, 0);
	            will(returnValue(7));
	        }
	    });
	    //exercise
	    double result = DataUtilities.calculateColumnTotal(values, 0);
	    // verify
	    assertEquals(result, 12.0, .000000001d);
	}
}
