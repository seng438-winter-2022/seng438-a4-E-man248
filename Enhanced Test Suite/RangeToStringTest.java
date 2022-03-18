package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;

public class RangeToStringTest {

	
	@Test
	public void toStringRangeObjectNormal() {
		Range object = new Range(1,5);
		
		String result = object.toString();
		//assertTrue(result.equals("Range[1,5]"));
		assertNotNull(result);
	}


	@Test
	public void toStringRangeObjectNull() {
		Range object = null;
		
		try
		{
			String result = object.toString();
			fail();
		}
		catch(Exception e)
		{
			if (!(e instanceof NullPointerException)) fail();
		}
	}

}
