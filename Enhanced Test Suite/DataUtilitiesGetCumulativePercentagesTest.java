package org.jfree.data.test;

import static org.junit.Assert.fail;

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

public class DataUtilitiesGetCumulativePercentagesTest
{
	private Mockery mockingContext;
	private KeyedValues data; 
	
	/* 
	 * Test Setup: Setup function played before every test.
	 * For this set up function, the Mockery used to make the
	 * mock as well as the KeyedValues class mock have been instantiated.
	 */
	@Before
	public void beforeTestSetup() throws Exception
	{
	    // setup
		mockingContext = new Mockery();
		data = mockingContext.mock(KeyedValues.class);
	}
	
	// Test Tear-Down: Clean-up function played after every test
	@After
	public void afterTestTeardown()
	{
	    // tear-down: NONE in this test method
	}
	

	/* 
	 * Test 2: This test case tests the intersects function under the following conditions:
	 *  - The KeyedValues object pointer, data, is not null
	 *  - The object data is empty (no entries)
	 *  - All items in data do not have their values set to zero
	 *  - There is not only one item in data
	 */	
	@Test
	public void getCumulativePercentagesEmptyArray() throws InvalidParameterException
	{
		try
		{
			//setup
			mockingContext.checking(new Expectations() {
		        {
		            one(data).getItemCount();
		            will(returnValue(0));

		            one(data).getItemCount();
		            will(returnValue(0));
		        }
		    });
			
		    //exercise
		    KeyedValues result = DataUtilities.getCumulativePercentages(data);
		}
	    catch (Exception e)
	    {
	    	//verify
	    	if (!(e instanceof InvalidParameterException))
	    	{
	    		Assert.fail("Asserstion Error: Expected Invalid Parameter Exception, got " + e.toString());
	    	}
	    }
	}
	
	@Test
	public void getCumulativePercentages_NullMutantTest() 
	{
		try
        {
			data = null;
			
			KeyedValues result = DataUtilities.getCumulativePercentages(data);
			
			fail();
			
        }
		//catch any exception thrown
        catch (Exception e)
        {
    		if (!(e instanceof IllegalArgumentException))
			{
				fail();
			}	       
        }
	}
}
	
	

	/* 
	 * Test 4: This test case tests the intersects function under the following conditions:
	 *  - The KeyedValues object pointer, data, is not null
	 *  - The object data not is empty
	 *  - All items in data have their values set to zero
	 *  - There is not only one item in data
	 */			
	
		
	
	
	
