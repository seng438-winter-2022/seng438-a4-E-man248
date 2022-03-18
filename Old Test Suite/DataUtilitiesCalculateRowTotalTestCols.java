/**
 * @author Gibran Akmal <a href="mailto:gibran.akmal@ucalgary.ca">gibran.akmal@ucalgary.ca</a>
 * @version 1.0
 * @since 1.0
 * UCID: 30094918
 * SENG 438 - Assignment 3
 * Group 31 
 * February 26, 2022
 */
//static method calculateRowTotal(Values2D data, int row, int[] validCols)' within class 'DataUtilities' subject to testing



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
 * This is a test class designed for the CalculateRowTotal method (with one extra column argument)
 */
public class DataUtilitiesCalculateRowTotalTestCols 
{
	
	
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
		 * as well as the valid number of columns being above zero but below the actual column count (within range)
		 * This should return a proper output, being the sum of the returned values.
		 */
	@Test
	public void calculateRowTotal_NothingNull()
	{
		try
		{
			//exercise
			mockingContext.checking(new Expectations() {
		        {
		                     
		            
		            one(values).getColumnCount();
		            will(returnValue(5));
		            
		            one(values).getRowCount();
		            will(returnValue(1));
		            
		            one(values).getValue(1, 1);
		            will(returnValue(9));
		            
		            one(values).getValue(1, 2);
		            will(returnValue(11));
		            
		            one(values).getValue(1, 3);
		            will(returnValue(13));
		         
		        }
		    });
			
			int [] validCols = {1,2,3};
			double result = DataUtilities.calculateRowTotal(values, 1, validCols);
			assertEquals(result, 33.0, .000000001d);
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
	
	
	/* Test Case 2: Pass
	 * In test case 2, we tested for having Values2D values (table) being valid (not NULL) 
	 * as well as our row integer number above 0. 
	 * as well as the valid number of columns being below the actual column count (within range) with the row value for one of the valid columns being null
	 * This should return a proper output, being the sum of the returned values with the null value not being included in calculations
	 */
	@Test
	public void calculateRowTotal_NullWithinRange()
	{
		try
		{
			//exercise
			mockingContext.checking(new Expectations() {
		        {
		                     
		            
		        	one(values).getColumnCount();
		            will(returnValue(4));
		            
		            one(values).getRowCount();
		            will(returnValue(1));
		            
		            one(values).getValue(1, 1);
		            will(returnValue(9));
		            
		            one(values).getValue(1, 2);
		            will(returnValue(11));
		            
		            one(values).getValue(1, 3);
		            will(returnValue(null));
		            
		         
		        }
		    });
			int [] validCols = {1,2,3};
			double result = DataUtilities.calculateRowTotal(values, 1, validCols);
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
	
	
	/* Test Case 3: Pass
	 * In test case 3, we tested for having Values2D values (table) being valid (not NULL) 
	 * as well as our row integer number above 0. 
	 * as well as the valid number of columns being exactly the same as the actual column count with the row value for one of the valid columns being null
	 * This should return a proper output, being the sum of the returned values with the null value not being included in calculations
	 */
	@Test
    public void calculateRowTotal_NullExact()
    {
        try
        {
            //exercise
            mockingContext.checking(new Expectations() {
                {
                   
                    one(values).getColumnCount();
                    will(returnValue(3));

                    one(values).getRowCount();
                    will(returnValue(1));

                    one(values).getValue(1, 1);
                    will(returnValue(9));

                    one(values).getValue(1, 2);
                    will(returnValue(11));

                    one(values).getValue(1, 3);
                    will(returnValue(null));


                }
            });
            int [] validCols = {1,2,3};
            double result = DataUtilities.calculateRowTotal(values, 1, validCols);
            assertEquals(result, 20.0, .000000001d);
//            fail("Expected Invalid Parameter Exception");
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
