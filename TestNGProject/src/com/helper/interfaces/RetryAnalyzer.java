package com.helper.interfaces;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {

    int counter = 0;
    int retryLimit = 3; //number of times the test is retried.

    /*
     * This method will return true if a test need to be retried (test failed)
     * and false when test passes
     *
     */
    @Override
    public boolean retry(ITestResult result) {

        if(counter < retryLimit)
        {
            counter++;
            return true;
        }
        return false;
    }
}