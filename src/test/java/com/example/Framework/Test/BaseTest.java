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
    public void setUp(String browser){
        boolean isHeadless = Boolean.parseBoolean(System.getProperty("headless", "false"));
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless=new");
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--no-sandbox");
                chromeOptions.addArguments("--disable-dev-shm-usage");
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
                }
                driver = new ChromeDriver(defaultOptions);
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
