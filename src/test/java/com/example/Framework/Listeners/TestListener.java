package com.example.Framework.Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.example.Framework.Test.BaseTest;
import com.example.Framework.Utils.ScreenshotUtils;

public class TestListener implements ITestListener {
    public ScreenshotUtils screen;
    
    public TestListener(){
        screen = new ScreenshotUtils();
        
    }

    @Override
    public void onTestFailure(ITestResult result){        
            try {
                BaseTest baseInstance = (BaseTest) result.getInstance();
                WebDriver driver = baseInstance.getDriver();
                screen.captureScreenShot(driver, result.getName());
                screen.captureScreenShotForAllure(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }

        
        
        

    }
    
}
