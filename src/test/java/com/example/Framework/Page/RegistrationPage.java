package com.example.Framework.Page;



import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.example.Framework.Utils.RandomDataGenerator;

public class RegistrationPage extends BasePage{
    String emailValue;
    String pwdValue;
    public RegistrationPage(WebDriver driver)
    {
        super(driver);
    }

    @FindBy(id="input-firstname")
    private WebElement firstName;

    @FindBy(id="input-lastname")
    private WebElement lastName;

    @FindBy(id="input-email")
    private WebElement email;

    @FindBy(id="input-telephone")
    private WebElement phone;

    @FindBy(id="input-password")
    private WebElement password;

    @FindBy(id="input-confirm")
    private WebElement confirmPassword;

    @FindBy(css = "input[name='agree']")
    private WebElement privacy;

    @FindBy(css = "input[value='Continue']")
    private WebElement continueButton;

    @FindBy(xpath= "//h1[text()='Your Account Has Been Created!']")
    private WebElement confirmationText;

   

    public boolean userRegistration(){
        try{
            log.info("Starting Registration Process");
            type(firstName, RandomDataGenerator.getAlphabets(8));        
            type(lastName, RandomDataGenerator.getAlphabets(8));        
            emailValue= RandomDataGenerator.getAlphabets(5) + "@gmail.com";
            type(email, emailValue);         
            String phoneValue= "512" + RandomDataGenerator.getNumeric(7);
            type(phone, phoneValue);       
            pwdValue = RandomDataGenerator.getAlphaNumeric(9) + "!";
            type(password, pwdValue);        
            type(confirmPassword, pwdValue);       
            click(privacy);
            Assert.assertTrue(privacy.isSelected());       
            click(continueButton);        
            return gettext(confirmationText).equalsIgnoreCase("Your Account Has Been Created!");  
                    
        }catch(TimeoutException e){
            System.out.println(e.getMessage());
            return false;
        }finally{
            log.info("Completing Registration Process");  
        }
        
        
        
        
    }


    
    
}
