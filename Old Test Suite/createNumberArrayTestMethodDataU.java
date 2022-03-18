package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;


import org.jfree.data.DataUtilities;
import java.lang.Number;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/*
 * Author: Priyanka Gautam 
 * UCID : 30091244
 * 
*/

public class createNumberArrayTestMethodDataU {
	
	
	
	@Before
	
	public void beforeTestSetup() {
		// setup
		//No mocking needed for this method 
	
	}
	
	//Test case 1
	/*
	 * In this test case, we are testing to see if the method createNumberArray can handle a null parameter appropriately. 
	 * The parameter variable is called data of type double []. This variable is set to null. Since the method createNumberArray takes in a double [] and returns
	 * a Number [], result stores the return value of the method. The method call is nested in a try and catch because the createNumberArray is supposed to
	 *  throw an InvalidParameterExeption.
	*/
		@Test
		public void createNumberArrayInputNull()  {
			
			double [] data = null;
			try {
			Number [] result = DataUtilities.createNumberArray(data);
			}
			 catch (Exception e)
	        {
	            if (!(e instanceof InvalidParameterException))
	            {
	                System.out.print("Assertion Error: Expected Invalid Parameter Exception, got " + e.toString());
	            }
				
			}
			
			
		}

	
	//Test case 2
		/* In this test case , we are testing with a valid non-empty parameter for createNumberArray method. This test case is to see if the createNumberArray 
		 * behaves appropriately and returns a valid Number []. 
		 * The result variable holds the return value of createNumberArray. We are asserting to check if result[0] == 3.0 and result[1] == 2.0 
		 * and if they are objects of Number. 
		 * 
		 */
		
	@Test
	public void createNumberArrayInputNotNull() {
		
		double [] data = {3.0,2.0};
		
		
		Number [] result = DataUtilities.createNumberArray(data);
		
		assertNotEquals(result.length, 0);
		
		assertEquals("Element 0 is a Number and should be ", 3.0, result[0]);
		assertEquals("Element 1 is a Number and should be ", 2.0, result[1]);
		
				
	}
	
	
	
	
	
	
	

}
