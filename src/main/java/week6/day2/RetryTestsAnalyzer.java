package week6.day2;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * Implements retries for failed test cases.
 * 
 * @author AdityaKRavi
 */
public class RetryTestsAnalyzer implements IRetryAnalyzer {
  int maxRetries = 3;
  int retryCount = 0;

  @Override
  public boolean retry(ITestResult result) {
    if (!result.isSuccess() && retryCount < maxRetries) {
      retryCount++;
      return true;
    }
    return false;
  }
}
