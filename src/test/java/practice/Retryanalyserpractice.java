package practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Retryanalyserpractice {

	@Test(retryAnalyzer=vTiger.Genericutilities.RetryAnalyserImplementation.class)
	
	public void practice() {
		
		
		Assert.fail();
		System.out.println("hi");
	}
}
