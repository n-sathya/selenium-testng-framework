package com.example.Framework.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.example.Framework.Utils.ConfigReader;


public class HomePage extends BasePage {

    
    public HomePage(WebDriver driver){
        super(driver);
        
    }

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    private WebElement myAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    private WebElement linkRegister;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    private WebElement linkLogin;

    public RegistrationPage clickRegister(){
        
            click(myAccount);
            click(linkRegister);    
            wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("regUrl")));  
            log.info("Success clicking Register link in home page.");  
            return new RegistrationPage(driver);
       
    }

    public LoginPage clickLogin(){
       
             click(myAccount);
             click(linkLogin);        
             wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("loginUrl")));   
             log.info("Success clicking Login link in home page.");
             return new LoginPage(driver);     
        
        }
       

    }


    
    

