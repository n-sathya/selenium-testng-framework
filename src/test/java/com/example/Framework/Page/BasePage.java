package com.example.Framework.Page;
import java.time.Duration;


//https://tutorialsninja.com/demo/
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.Framework.Utils.ConfigReader;

import io.qameta.allure.Step;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected final Logger log = LogManager.getLogger(this.getClass());

    public BasePage(WebDriver driver){
        this.driver = driver;  
        wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(ConfigReader.getProperty("timeout"))));
        PageFactory.initElements(driver,this);  
    }

    @Step("Entering {1} into field")
    public void type(WebElement element, String text) throws TimeoutException{
        wait.until(ExpectedConditions.visibilityOf(element));
        String field_name = getFieldName(element);
        log.info("Entering " + text + " into field " + field_name );
        element.sendKeys(text);
        log.info("Entering " + text + " into field " + field_name + " is complete." );
    }

    public void click(WebElement element) throws TimeoutException{
        wait.until(ExpectedConditions.elementToBeClickable(element));
        String field_name = getFieldName(element);
        log.info("Clicking " + field_name);
        element.click();
        log.info("Successfully Clicked " + field_name);
    }

    public String gettext(WebElement element) throws TimeoutException{    
        wait.until(ExpectedConditions.visibilityOf(element));
        log.info("Extracting text ");   
        String text = element.getText();
        log.info(" Text  Extracted : " + text);
        return text;
    }

    public boolean elementPresent(WebElement element) throws TimeoutException{        
        wait.until(ExpectedConditions.visibilityOf(element));
        String field_name = getFieldName(element);
        log.info("Checking Presence of " + field_name);
        return element.isDisplayed();
    }

    public String getFieldName(WebElement element){

        String name = element.getAccessibleName();
        if (name == null || name.isEmpty()){
            name = element.getText();
        }
        return name;
    }

    
}
