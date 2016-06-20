package webdriver;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testNGListeners implements ITestListener{

	@Override
	public void onFinish(ITestContext result) {
		
	}

	@Override
	public void onStart(ITestContext result) {
			
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Testcase Failed"+result);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase Skipped"+result);
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Testcase Started"+result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcase Completes"+result);
		
	}
	

}
