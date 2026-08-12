package com.example.Practise;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result){        
       System.out.println("Test Result is  Fail for : " + result.getName());
        
    }

    @Override
    public void onTestSuccess(ITestResult result){
        System.out.println("Test Result is  Pass for : " + result.getName());

    }

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("Started Test Details: ");
        System.out.println(result.getTestName());
        System.out.println(result.getTestClass().getName());
        System.out.println(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result){
        System.out.println("Skipped Test Details: ");
        System.out.println(result.getTestName());
        System.out.println(result.getTestClass().getName());
        System.out.println(result.getName());

    }


    
}
