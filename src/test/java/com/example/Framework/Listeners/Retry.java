package com.example.Framework.Listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{
      private int counter = 1;
      private int maxRetry = 2;

    @Override
    public boolean retry(ITestResult result) {
      
        if (counter < maxRetry ){
            counter = counter + 1;
            return true;
        }
        return false;
    }

    

    
}
