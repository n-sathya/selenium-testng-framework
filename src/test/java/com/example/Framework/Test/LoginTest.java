package com.example.Framework.Test;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import com.example.Framework.Page.AccountPage;
import com.example.Framework.Page.HomePage;
import com.example.Framework.Page.LoginPage;
//import com.example.Framework.Utils.ConfigReader;
import com.example.Framework.Utils.TestDataProvider;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;


@Epic("Authentication")
@Feature("Login")
public class LoginTest extends BaseTest {    
     
    private HomePage hp;

    @BeforeMethod
    public void loginSetUp(){         
         hp = new HomePage(getDriver());
    }

    /* @DataProvider(name="Read_XL")
    public Object[][] getData() throws IOException{
        ExcelReader excel = new ExcelReader();
        String path = System.getProperty("user.dir") + "//Data//Excel.xlsx";
        Object[][] obj = excel.readXL(path);
        return obj;
    }  */

    /* @Test(dataProvider = "Read_XL", enabled=false)
    public void inValidUserLogin(String uname, String Pwd){      
        lp.userLogin(uname, Pwd);
        Assert.assertFalse(lp.verifyAlertMessage());
    } */
    
    @Test(dataProvider = "Read_XL", dataProviderClass = TestDataProvider.class)
    public void validUserLogin(String UserName, String Password, String Valid){
        LoginPage lp = hp.clickLogin();
        //String uname = ConfigReader.getProperty("userName");
        //String password = ConfigReader.getProperty("passWord");
        lp.userLogin(UserName, Password);
        AccountPage ap = new AccountPage(getDriver());
        boolean result= ap.verifyValidLogin();
        Assert.assertEquals(String.valueOf(result).toLowerCase(), Valid.toLowerCase());
        if (result){
            ap.userLogout();
        }
               

    }



    

   

 
    
}
