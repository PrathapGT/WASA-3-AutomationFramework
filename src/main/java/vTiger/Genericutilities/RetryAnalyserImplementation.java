package vTiger.Genericutilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation for iretryanalyser interface in testng
 * @author home
 *
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer {

	
	int count=0;
	int retrycount=3;
	
	/*
	 * This method will retry for 3 times
	 */
	public boolean retry(ITestResult result) {
		
		while(count<retrycount) {
			
			count++;
			return true;
		}
		
		return false;
		
	}

}
