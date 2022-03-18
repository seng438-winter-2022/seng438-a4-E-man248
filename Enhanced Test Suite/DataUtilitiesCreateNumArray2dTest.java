/**
 * @author Gibran Akmal <a href="mailto:gibran.akmal@ucalgary.ca">gibran.akmal@ucalgary.ca</a>
 * @version 2.0
 * @since 1.0
 * UCID: 30094918
 * SENG 438 - Assignment 2
 * Group 31 
 * February 9, 2022
 */
//static method 'createNumberArray2D(double[][] data)' within class 'DataUtilities' subject to testing


//required libraries imported
package org.jfree.data.test;
import static org.junit.Assert.*;
import java.security.InvalidParameterException;
import org.jfree.data.DataUtilities;
import org.junit.Test;

/*
 * This is a test class designed for the CreateNumArray2d method
 */
public class DataUtilitiesCreateNumArray2dTest 
{
	
	
	
	//Test Case 2 (empty 2d Array passed in [all 0s])
	@Test
	public void createNumberArray2D_EmptyTest() 
	{
		try
        {
			//empty 2d array initialized with 2 rows and 2 columns
			double[][] data = new double[2][2];
			
			//result 2D array declared
			Number[][] result;
			
			//result 2D array is assigned the output structure
			result = DataUtilities.createNumberArray2D(data);
			
			
			
			//Both the input 2D array and the output 2D array should hold the same elements
			//following are assertion tests going through each 2d array to see weather each element is the same in both structures
			assertEquals(data[0][0], result[0][0]);
			assertEquals(data[0][1], result[0][1]);
			assertEquals(data[1][0], result[1][0]);
			assertEquals(data[1][1], result[1][1]);
			
        }
		//catch any exception thrown
        catch (Exception e)
        {  
        	//print the exception
        	System.out.print("Assertion Error: " + e.toString());    
        }
	}
	
	//Test case 3 (2d array with single row passed in - can be seen as a 1d array)
	@Test
	public void createNumberArray2D_1RowTest() 
	{
		try
        {
			//2d array initialized with 1 row and 3 columns
			//a kind of 1D array
			double[][]data = new double[1][3];
			data[0][0] = 1.10;
			data[0][1] = 2.65;
			data[0][2] = 3.14;
			
			//should output Number[][] 2d array and is assigned to result variable
			Number[][] result;
			result = DataUtilities.createNumberArray2D(data);
			
			
			
			//checking the length of the resulting data object and weather the values inside each corresponding elements are the same
			assertEquals(data.length, result.length);
			assertEquals(data[0][0], result[0][0]);
			assertEquals(data[0][1], result[0][1]);
			assertEquals(data[0][2], result[0][2]);
        }
		
		//catch any exception thrown
        catch (Exception e)
        {    
        	//print the exception
            System.out.print("Assertion Error: " + e.toString());         
        }
	}
	
	//Test Case 4 (fully populated data[][] array)
	@Test
	public void createNumberArray2D_FullyPopulatedTest() 
	{
		try
        {
			//full 2d array initialized with 2 rows and 2 columns
			double[][]data = 
				{
						{1.10, 2.65},
						{3.14, 6.78}
				};
			
			//should output Number[][] 2d array and is assigned to result variable
			Number[][] result;
			result = DataUtilities.createNumberArray2D(data);
			
		
			//assert weather or not the sizes of both structures are the same
			//asserts weather or not each element of the resulting array is the same as the input data array
			assertEquals(data.length, result.length);
			assertEquals(data[0][0], result[0][0]);
			assertEquals(data[0][1], result[0][1]);
			assertEquals(data[1][0], result[1][0]);
			assertEquals(data[1][1], result[1][1]);
        }
		//catch any exception thrown
        catch (Exception e)
        {
        	//print the exception
           System.out.print("Assertion Error: " + e.toString());    
        }
	}
	
	//Test Case 5 (partially populated 2d Array passed in)
	@Test
	public void createNumberArray2D_NormalTest() 
	{
		try
        {
			//empty 2d array initialized with 1 row and 3 columns
			double[][]data = new double[2][2];
			
			//data array only partially filled
			data[0][0] = 1.10;
			data[0][1] = 2.65;
			data[1][0] = 3.14;
			//data[1][1] = 6.78;
			
			//output Number[][] 2d array and is assigned to result variable
			Number[][] result;
			result = DataUtilities.createNumberArray2D(data);		
			
			
			//asserts weather or not each element of the resulting array is the same as the input data array
			assertEquals(data.length, result.length);
			assertEquals(data[0][0], result[0][0]);
			assertEquals(data[0][1], result[0][1]);
			assertEquals(data[1][0], result[1][0]);
			
			//should be 0 and 0 since the final element was left empty
			assertEquals(data[1][1], result[1][1]);
			
        }
		//catch any exception thrown
        catch (Exception e)
        {
        	//print the exception
           System.out.print("Assertion Error:  " + e.toString());            
        }
	}
	
	//Test Case 5 (partially populated 2d Array passed in)
	@Test
	public void createNumberArray2D_NullMutantTest() 
	{
		try
        {
			//empty 2d array initialized with 1 row and 3 columns
			double[][]data = null;
			
			//output Number[][] 2d array and is assigned to result variable
			Number[][] result;
			result = DataUtilities.createNumberArray2D(data);		
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
	
	//Test Case 5 (partially populated 2d Array passed in)
	@Test
	public void createNumberArray2D_MutantTest2() 
	{
		try
        {
			//empty 2d array initialized with 1 row and 3 columns
			double[][]data = new double[2][2];
			
			//data array only partially filled
			data[0][0] = 1.10;
			data[0][1] = 2.65;
			data[1][0] = 3.14;
			//data[1][1] = 6.78;
			
			//output Number[][] 2d array and is assigned to result variable
			Number[][] result;
			result = DataUtilities.createNumberArray2D(data);		
			
			assertNotNull(result);
			
        }
		//catch any exception thrown
        catch (Exception e)
        {
        	//print the exception
           System.out.print("Assertion Error:  " + e.toString());
           if (e instanceof RuntimeException) fail();
        }
	}
	
	
}
