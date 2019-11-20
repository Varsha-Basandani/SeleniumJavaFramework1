package listeners;

import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener {

	public void onFinish(ITestContext arg0) {
		System.out.println("************Tests completed: "+arg0.getName());	
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		System.out.println("************Test failed: "+arg0.getName());
		
	}

	public void onTestSkipped(ITestResult arg0) {
		System.out.println("************Test skipped :"+arg0.getName());
		
	}

	public void onTestStart(ITestResult arg0) {
		System.out.println("************Test started :"+arg0.getName());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	

	
	

}
