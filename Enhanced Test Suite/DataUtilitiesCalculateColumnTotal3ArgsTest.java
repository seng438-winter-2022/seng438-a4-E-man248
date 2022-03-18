//Priyanka Gautam 
//30091244

package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/*
 * This is a test class designed for the CalculateColumnTotal method (with 3 args)
 */
public class DataUtilitiesCalculateColumnTotal3ArgsTest {

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
	
	/* 
	 * Test 1: This test case tests the intersects function under the following conditions:
	 * All the data is 'good; 
	 * This test passes an appropriate values2D value where the table has 5 rows and 1 column. The data points are as follows:
	 * (1,1) = 9 
	 * (2,1)= 11
	 * (3,1) = 13
	 * Since this is a valid test, it covers one branch of the if statement 
	 * The total is evaluated by summing all the values (9+11+3)
	 */
	@Test
	public void calculateColumnTotalWithAppropriateValues2D()
	{
		try
		{
			//exercise
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getRowCount();
		            will(returnValue(5));
		            
		            one(values).getColumnCount();
		            will(returnValue(1));
		            
		            one(values).getValue(1, 1);
		            will(returnValue(9));
		            
		            one(values).getValue(2, 1);
		            will(returnValue(11));
		            
		            one(values).getValue(3, 1);
		            will(returnValue(13));
		            
		         
		        }
		    });
			int [] validRows = {1,2,3};
			double result = DataUtilities.calculateColumnTotal(values, 1, validRows);
			assertEquals(33.0,result,  .000000001d);
//			fail("Expected Invalid Parameter Exception");
		}
	    catch (Exception e)
	    {
	    	//verify
	    	if (!(e instanceof InvalidParameterException))
	    	{
	    		Assert.fail("Asserstion Error: Expected Invalid Parameter Exception, got " + e.toString() + "\n");
	    	}
	    }
	}
	/*
	 * This test is to test the second branch of the if statement where a value in the values2D table is null. 
	 * This is why one of the points has been set to null. The expected output is that only non null values are used 
	 * in calculating total. Thus, the only values used in summing the total are values from (1, 1) and (2,1) 
	 * */
	@Test
	public void calculateColumnTotalDataIsNull()
	{
		try
		{
			//exercise
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getRowCount();
		            will(returnValue(4));
		            
		            one(values).getColumnCount();
		            will(returnValue(1));
		            
		            one(values).getValue(1, 1);
		            will(returnValue(9));
		            
		            one(values).getValue(2, 1);
		            will(returnValue(11));
		            
		            one(values).getValue(3, 1);
		            will(returnValue(null));
		            
		         
		        }
		    });
			int [] validRows = {1,2,3};
			double result = DataUtilities.calculateColumnTotal(values, 1, validRows);
			assertEquals(result, 20.0, .000000001d);
//			fail("Expected Invalid Parameter Exception");
		}
	    catch (Exception e)
	    {
	    	//verify
	    	if (!(e instanceof InvalidParameterException))
	    	{
	    		Assert.fail("Asserstion Error: Expected Invalid Parameter Exception, got " + e.toString() + "\n");
	    	}
	    }
	}
	
	/*
	 * This test is to test the second branch of the if statement where a value in the values2D table is null. 
	 * This is why one of the points has been set to null. The expected output is that only non null values are used 
	 * in calculating total. Thus, the only values used in summing the total are values from (1, 1) and (2,1) 
	 * */
	@Test
	public void calculateColumnTotalDataIsNullMutantTest()
	{
		try
		{
			//exercise
			values = null;
			int [] validRows = {1,2,3};
			double result = DataUtilities.calculateColumnTotal(values, 1, validRows);
			assertEquals(result, 20.0, .000000001d);	
			fail("Expected IllegalArgumentException");
		}
	    catch (Exception e)
	    {
	    	//verify
	    	if (!(e instanceof IllegalArgumentException))
	    	{
	    		Assert.fail("Asserstion Error: Expected Invalid Parameter Exception, got " + e.toString() + "\n");
	    	}
	    }
	}
	
	
	
	/*
	 * In this test case, the if statement branch row < row count is being tested. This is why the rowCount is 3 but 
	 * only values retrieved from 2 rows will used in computing the total. The expected result is calculated by summing 
	 * value from (1,1) and (2,1). 
	 * */
	@Test
	public void calculateColumnTotalRowLessThanRowCount()
	{
		try
		{
			//exercise
			mockingContext.checking(new Expectations() {
		        {
		            one(values).getRowCount();
		            will(returnValue(3));
		            
		            one(values).getColumnCount();
		            will(returnValue(1));
		            
		            one(values).getValue(1, 1);
		            will(returnValue(9));
		            
		            one(values).getValue(2, 1);
		            will(returnValue(11));
		            
		            one(values).getValue(3, 1);
		            will(returnValue(12));
		            
		         
		        }
		    });
			int [] validRows = {1,2,3};
			double result = DataUtilities.calculateColumnTotal(values, 1, validRows);
			assertEquals(result, 20.0, .000000001d);
//			fail("Expected Invalid Parameter Exception");
		}
	    catch (Exception e)
	    {
	    	//verify
	    	if (!(e instanceof InvalidParameterException))
	    	{
	    		Assert.fail("Asserstion Error: Expected Invalid Parameter Exception, got " + e.toString() + "\n");
	    	}
	    }
	}
	
}
