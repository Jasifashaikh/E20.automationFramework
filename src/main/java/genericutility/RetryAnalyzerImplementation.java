package genericutility;
/*
 * This class provides inplementation to IRetryAnalyzer Interface of TestNG
 */

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementation implements IRetryAnalyzer{
	int count = 0;
	int retryCount = 3;//Manually analyzed

	@Override
	public boolean retry(ITestResult result) {
	
		while(count<retryCount)
		{
			count++;
			return true;//retry
		}
		
		return false;//stop retry
	}

}
