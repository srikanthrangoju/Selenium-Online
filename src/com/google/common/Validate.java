package com.google.common;

import org.testng.Assert;

import com.google.common.testlisteners.TestListener;

public class Validate {
	public static boolean validateStringEquals(String expected,String actual,boolean ignorecase){
	/*	if(ignorecase)
			Assert.assertEquals(expected.toLowerCase(),actual.toLowerCase());
	else
			Assert.assertEquals(expected, actual);
		}
	*/
	if(ignorecase){
		if(expected.equalsIgnoreCase(actual)){
			System.out.println("Expected:"+expected+"and Actual:"+actual+ "are equal.");
			return true;
		}
			else
				System.out.println("Expected:"+expected+"and Actual:"+actual+ "are not equal.");
				TestListener.validationfailures++;
				return false;
			}
	if(expected.equals(actual)){
		System.out.println("Expected:"+expected+"and Actual:"+actual+ "are equal.");
		return true;
	}
		else
			System.out.println("Expected:"+expected+"and Actual:"+actual+ "are not equal.");
			TestListener.validationfailures++;
			return false;
		}

	}


