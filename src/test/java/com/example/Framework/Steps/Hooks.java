package com.example.Framework.Steps;

import com.example.Framework.Utils.ConfigReader;
import com.example.Framework.Utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    private final TestContext context;

    public Hooks(TestContext context){
        this.context = context;
    }

    @Before
    public void cucumber_setUp() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        this.context.driver = driver;
        driver.get(ConfigReader.getProperty("baseUrl"));
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        driver.manage().window().maximize();
        Thread.sleep(2000);

    }

    @After
    public void cucumber_tearDown(){
        this.context.driver.quit();
    }
}
