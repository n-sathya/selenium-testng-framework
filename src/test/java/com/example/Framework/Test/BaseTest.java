package com.example.Framework.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.example.Framework.Utils.ConfigReader;

public class BaseTest{
    private WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser){
        switch (browser) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;
        
            default:
                driver = new ChromeDriver();
                break;
        }
        
        driver.get(ConfigReader.getProperty("baseUrl"));       
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.manage().window().maximize(); 

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    
     
}
