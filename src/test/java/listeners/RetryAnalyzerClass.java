package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerClass implements IRetryAnalyzer{

	
	int count=0;
	int retryCount=1;
	@Override
	public boolean retry(ITestResult result) {
		while(retryCount<count)
		{
		count++;
		return true;
		}
		return false;
	}

}
