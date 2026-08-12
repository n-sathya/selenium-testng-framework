package com.example.Framework.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.example.Framework.Utils.ConfigReader;

public class BaseTest{
    private WebDriver driver;

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) throws InterruptedException{
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        switch (browser) {
            case "chrome":
                 ChromeOptions chromeOptions = new ChromeOptions();
                if(isHeadless){               
                chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
                chromeOptions.addArguments("--window-size=1920,1080");
                }
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }
                driver = new FirefoxDriver(firefoxOptions);
                break;
        
            default:
                ChromeOptions defaultOptions = new ChromeOptions();
                if (isHeadless) {
                    defaultOptions.addArguments("--headless=new");
                    defaultOptions.addArguments("--disable-gpu");
                    defaultOptions.addArguments("--no-sandbox");
                    defaultOptions.addArguments("--disable-dev-shm-usage");
                    defaultOptions.addArguments("--window-size=1920,1080");
                }
                driver = new ChromeDriver(defaultOptions);
                break;
        }
        
        driver.get(ConfigReader.getProperty("baseUrl")); 
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        Thread.sleep(3000);
        if (!isHeadless) {
             driver.manage().window().maximize();
            }
       // driver.manage().window().maximize(); 

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    
     
}
