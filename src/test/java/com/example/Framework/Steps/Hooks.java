package com.example.Framework.Steps;

import com.example.Framework.Utils.ConfigReader;
import com.example.Framework.Utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    private final TestContext context;

    public Hooks(TestContext context){
        this.context = context;
    }

    @Before
    public void cucumber_setUp() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--window-size=1920,1080");
        WebDriver driver = new ChromeDriver(chromeOptions);
        this.context.driver = driver;
        driver.get(ConfigReader.getProperty("baseUrl"));
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        Thread.sleep(2000);


    }

    @After
    public void cucumber_tearDown(){
        this.context.driver.quit();
    }
}
