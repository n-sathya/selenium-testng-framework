package com.example.Framework.Page;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage extends BasePage{
 

    @FindBy(id="input-email")
    private WebElement email;

    @FindBy(id="input-password")
    private WebElement password;
    
    @FindBy(css="input[value='Login']")
    private WebElement login_btn;


    @FindBy(xpath = "//div[contains(@class,'alert') and contains(@class,'alert-danger') and contains(@class,'alert-dismissible')]")
    private WebElement alert_msg;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void setEmail(String email){
        type(this.email, email);
    }

    public void setPassword(String pwd){
        type(this.password,pwd);
    }

    public void clickButton(){
        click(this.login_btn);
    }

    public String getAlertMsgText(){     
        return gettext(alert_msg);
    }

    public void userLogin(String uname, String Pwd){
        try{
        log.info("starting Login steps....");
        setEmail(uname);
        setPassword(Pwd);
        log.info("Login Button to be Pressed....");
        clickButton();  
        log.info("Ending login steps ...");      
        }catch(TimeoutException exception){            
            log.info(exception.getMessage());
        }        
        
    }

    public boolean verifyAlertMessage(){
        try{
            log.info("Verifying Failed Login Text Message.....");
            return getAlertMsgText().contains("Warning");
        }catch(TimeoutException exception){
            System.out.println(exception.getMessage());
            log.info(exception.getMessage());
            return false;
        }
        
    }

    
}
