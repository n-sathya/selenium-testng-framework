package com.example.Framework.Page;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage {

    public AccountPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath="//h2[normalize-space()='My Account']")
    private WebElement txt_MyAccount;

    @FindBy(xpath="//a[normalize-space()='Logout' and @class='list-group-item']")
    private WebElement lnk_Logout;

    public boolean verifyValidLogin(){
        try{
                boolean result =  elementPresent(txt_MyAccount); 
                log.info("Login Successfull : " + result);                 
                return result;
        }catch(TimeoutException exception){
            log.info(exception.getMessage());
            log.info("Login Failed......");
            return false;
        }
        
    }

    public void userLogout(){
        log.info("Clicking Logout:");  
        try{           
            click(lnk_Logout);
            log.info("logout operation Success");
        }catch(TimeoutException exception){
            log.info("logout operation failed");
        }
                

    }
}
   
    

