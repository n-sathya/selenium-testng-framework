package com.example.Framework.Steps;
import com.example.Framework.Page.AccountPage;
import com.example.Framework.Page.HomePage;
import com.example.Framework.Page.LoginPage;
import com.example.Framework.Utils.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class LoginSteps {
    private TestContext context;

    public LoginSteps(TestContext context){
        this.context = context;
    }

    @Given("user is on the login page")
    public void userIsOnLoginPage(){
        HomePage hp = new HomePage(this.context.driver);
        hp.clickLogin();
    }

    @When("user enters valid username and password")
    public void userEntersValidCredentials(){
        System.out.println("Smoke test");
        LoginPage lp = new LoginPage(this.context.driver);
        lp.userLogin("test_acc@testmail.com", "testAccount@108");
    }

    @When("user enters {string} and {string}")
    public void userEntersCredentials(String username, String password){
        System.out.println("Regression test");
        LoginPage lp = new LoginPage(this.context.driver);
        lp.userLogin(username, password);
    }

    @Then("the account page should be visible")
    public void theAccountPageShouldBeVisible(){
        AccountPage ap = new AccountPage(this.context.driver);
        Assert.assertTrue(ap.verifyValidLogin());
    }

}
