package com.example.Framework.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.Framework.Page.HomePage;
import com.example.Framework.Page.RegistrationPage;

public class RegisterationTest extends BaseTest{
    

    @Test
    public void registerationTest(){        
        HomePage homePage = new HomePage(getDriver());
        RegistrationPage regPage = homePage.clickRegister();
        boolean result = regPage.userRegistration();
        Assert.assertTrue(result);
    }
}
