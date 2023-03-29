package vTiger.Genericutilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listnersimplimentation implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		String METHODNAME = result.getMethod().getMethodName();
		System.out.println(METHODNAME+" Execution started");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		String METHODNAME = result.getMethod().getMethodName();

		System.out.println(METHODNAME+ "---pass---");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String METHODNAME = result.getMethod().getMethodName();
		
		System.out.println(METHODNAME+"--Fail--");

		
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		String METHODNAME = result.getMethod().getMethodName();
		
		System.out.println(METHODNAME+"---skipped---");

		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
		WebdriverUtility wUtil=new WebdriverUtility();

		JavaUtility jUtil=new JavaUtility();
		String METHODNAME = result.getMethod().getMethodName();
		System.out.println(METHODNAME+"---Failed---");

		String Screenshotname = METHODNAME+"--"+jUtil.getsystemDateInFormat();
		
		try {
			wUtil.Takescreenshot(Baseclass.sDriver, Screenshotname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("suite excecuted started");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("suite execution finished");
	}

	
	
	
}
