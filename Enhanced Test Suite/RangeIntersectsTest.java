package org.jfree.data.test;

import static org.junit.Assert.fail;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Range;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RangeIntersectsTest
{
	private Range data; 
	
	/*
	 * Test Setup: Setup function played before every test.
	 * For this setup function, the Range data is assigned
	 * with a lower limit and an upper limit
	 */
	@Before
	public void beforeTestSetup() throws Exception
	{
	    // setup
		data = new Range(0, 10);
	}
	
	// Test Tear-Down: Clean-up function played after every test
	@After
	public void afterTestTeardown()
	{
	    // tear-down: NONE in this test method
	}
	
	/* 
	 * Test 1: This test case tests the intersects function under the following conditions:
	 *  - The Range data intersects the given bounds
	 *  - The upper limit is less than the lower limit
	 *  - The upper limit is not equal to the lower limit
	 */
	@Test
	public void intersectsWithinBoundsWhereUpperLessThanLowerTest()
	{
	    //exercise
	    boolean result = data.intersects(5, 0);
	    Assert.assertFalse("Expected False", result);
	}
	
	/* 
	 * Test 2: This test case tests the intersects function under the following conditions:
	 *  - The Range data intersects the given bounds
	 *  - The upper limit is not less than the lower limit
	 *  - The upper limit is equal to the lower limit
	 */
	@Test
	public void intersectsWithinBoundsWhereUpperEqualsLowerTest()
	{		
	    //exercise
	    boolean result = data.intersects(5, 5);
	    //verify
	    Assert.assertTrue("Expected True", result);
	}

	/* 
	 * Test 3: This test case tests the intersects function under the following conditions:
	 *  - The Range data intersects the given bounds
	 *  - The upper limit is not less than the lower limit
	 *  - The upper limit is not equal to the lower limit
	 */
	@Test
	public void intersectsWithinBoundsWhereUpperGreaterThanLowerTest()
	{		
	    //exercise
	    boolean result = data.intersects(0, 5);
	    //verify
	    Assert.assertTrue("Expected True", result);
	}
	
	/* 
	 * Test 4: This test case tests the intersects function under the following conditions:
	 *  - The Range data does not intersect the given bounds
	 *  - The upper limit is less than the lower limit
	 *  - The upper limit is not equal to the lower limit
	 */
	@Test
	public void intersectsOutsideBoundsWhereUpperLessThanLowerTest()
	{		
	    //exercise
		boolean result = data.intersects(-5, -10);
    	//verify
		Assert.assertFalse("Expected False", result);
	}
	
	/* 
	 * Test 5: This test case tests the intersects function under the following conditions:
	 *  - The Range data does not intersect the given bounds
	 *  - The upper limit is not less than the lower limit
	 *  - The upper limit is equal to the lower limit
	 */
	@Test
	public void intersectsOutsideBoundsWhereUpperEqualsLowerTest()
	{		
	    //exercise
		boolean result = data.intersects(-5, -5);
	    //verify
	    Assert.assertFalse("Expected False", result);
	}

	/* 
	 * Test 6: This test case tests the intersects function under the following conditions:
	 *  - The Range data does not intersect the given bounds
	 *  - The upper limit is not less than the lower limit
	 *  - The upper limit is not equal to the lower limit
	 */
	@Test
	public void intersectsOutsideBoundsWhereUpperGreaterThanLowerTest()
	{		
	    //exercise
		boolean result = data.intersects(-10, -5);
	    
	    //verify
	    Assert.assertFalse("Expected False", result);
	}
	
	@Test
	public void intersectsWithRangeObjectTest()
	{		
	    //exercise
		Range range = new Range(1, 2);
		boolean result = data.intersects(range);
	    
	    //verify
	    Assert.assertTrue("Expected True", result);
	}
	

	@Test
	public void intersectsWithUpperLessThanLowerButInvalidTest()
	{		
	    //exercise
		boolean result = data.intersects(10, 5);
	    
	    //verify
	    Assert.assertFalse("Expected False", result);
	}
	
	

	@Test
	public void intersectsDataBoundsEqualAndWithUpperParamEqualToLowerParamOutBoundMutant()
	{
		data = new Range(0, 0);
		
	    //exercise
		boolean result = data.intersects(1, 0);
	    
	    //verify
	    Assert.assertFalse("Expected False", result);
	}
}
