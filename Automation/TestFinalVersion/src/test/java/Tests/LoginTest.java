package Tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTest extends TestBase {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    LoginPage loginPage;

    @BeforeMethod
    public void setup() {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void LoginWithValidUsernameAndValidPassword()  {
        loginPage.fillUserName("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    @Test
    public void loginWithoutData () {
        loginPage.fillUserName("");
        loginPage.fillPassword("");
        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.requiredErrorMessageUsernameActualResult(),
                loginPage.getRequiredErrorUsernameTextExpectResult(),
                "Epic sadface: Username is required\n");
    }

    @Test
    public void loginWithJustValidPassword(){
        loginPage.fillUserName("");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.requiredErrorMessageUsernameActualResult(),
                loginPage.getRequiredErrorUsernameTextExpectResult(),
                "Epic sadface: Username is required\n");
    }

    @Test
    public void loginWithJustValidUsername(){
        loginPage.fillUserName("standard_user");
        loginPage.fillPassword("");
        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.requiredErrorMessagePasswordActualResult(),
                loginPage.getRequiredErrorPasswordTextExpectResult(),
                "Epic sadface: Password is required\n");
    }

    @Test
    public void loginWithInvalidUsernameAndValidPassword(){
        loginPage.fillUserName("standard");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.invalidCredentialActualResult(),
                loginPage.getInvalidCredentialExpectedResult(),
                "Epic sadface: Username and password do not match any user in this service\n");
    }

    @Test
    public void loginWithValidUsernameAndInvalidPassword(){
        loginPage.fillUserName("standard_user");
        loginPage.fillPassword("secret");
        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.invalidCredentialActualResult(),
                loginPage.getInvalidCredentialExpectedResult(),
                "Epic sadface: Username and password do not match any user in this service\n");
    }

    @Test
    public void loginWithInvalidUsernameAndInvalidPassword(){
        loginPage.fillUserName("standard");
        loginPage.fillPassword("secret");
        loginPage.clickOnLoginButton();

        Assert.assertEquals(loginPage.invalidCredentialActualResult(),
                loginPage.getInvalidCredentialExpectedResult(),
                "Epic sadface: Username and password do not match any user in this service\n");
    }
}