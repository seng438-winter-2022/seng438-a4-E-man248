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
 * This is a test class designed for the CalculateRowTotal method
 */
public class DataUtilitiesCalculateRowTotalTest {

	// Initialize
	private Mockery mockingContext;
	private Values2D values;

	/* Setup Before Any Test Occurs
	 * 
	 */
	@Before
	public void setupTest() {
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
	}

	/* Test Case 1: Pass
	 * In test case 1, we tested for having Values2D values (table) being valid (not NULL) 
	 * as well as our row integer number above 0. 
	 * This should return a proper output, being the sum of the returned values.
	 */
	@Test
	public void calculateRowTotal_NotNullTest() {
		try
		{
			// Mock
			mockingContext.checking(new Expectations() {
				{
					one(values).getColumnCount();
					will(returnValue(3)); // 3 columns in our row
	
					one(values).getValue(0, 0);
					will(returnValue(3)); // The value in that specific column
	
					one(values).getValue(0, 1);
					will(returnValue(4));
	
					one(values).getValue(0, 2);
					will(returnValue(3));
				}
			});
			
			double result = DataUtilities.calculateRowTotal(values, 0); // Valid Row Int
			assertEquals("Output should be 10", 10.0, result, .000000001d);
			// Output is 3 + 4 + 3 = 10
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
	
	/* Test Case 2: Pass
	 * In test case 2, we tested for having Values2D values table values being invalid (NULL) 
	 * as well as our row integer number above 0. (valid)
	 * 
	 * Since one our inputs are invalid, our output should be 0
	 */
	@Test
	public void calculateRowTotal_TableValuesNullTest() {
		try
		{
			// Mock
			mockingContext.checking(new Expectations() {
				{
					one(values).getColumnCount();
					will(returnValue(3)); // 3 columns all are null numbers

					one(values).getValue(0, 0);
					will(returnValue(null));
					
					one(values).getValue(0, 1);
					will(returnValue(null));

					one(values).getValue(0, 2);
					will(returnValue(null));
				}
			});
		    double result = DataUtilities.calculateRowTotal(values, 0); // value is null
		    assertEquals(0, result, .000000001d);
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

	/* Test Case 3: Pass
	 * In test case 3, we tested for having Values2D values (table) being invalid (NULL) 
	 * as well as our row integer number below 0. (invalid)
	 * 
	 * Since one our inputs are invalid, our output should be 0
	 */
	@Test
	public void calculateRowTotal_IsNull_LessthanZeroTest() {
		// instantiate null to null test
		values = null;
		
		try
		{
			double result = DataUtilities.calculateRowTotal(values, -1); // values is null & row int is less than 0
			assertEquals(0, result, .000000001d);
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

}
