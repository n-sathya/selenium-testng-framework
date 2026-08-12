package com.example.Practise;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetry implements IRetryAnalyzer {
    int count = 0;
    int maxRetries = 3;

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxRetries)
        {
           
            count =count+1;
             return true;
        }
    return false;
        
    }



    
}
