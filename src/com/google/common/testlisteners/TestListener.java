package com.google.common.testlisteners;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

public class TestListener implements IInvokedMethodListener{
	public static int validationfailures=0;

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult result) {
		//Assert.assertEquals("validation failure should not be zero",0,validationfailures);
		if(validationfailures>0)
		{
			System.out.println("Found one or more validation failures in test"+method.getTestMethod().getMethod().getName());
			result.setStatus(TestResult.FAILURE);
		}
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		validationfailures=0;
		
	}
	

}
