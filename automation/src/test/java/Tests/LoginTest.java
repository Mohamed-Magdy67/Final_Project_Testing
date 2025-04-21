package Tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;

public class LoginTest extends Test_Base{
    LoginPage loginPage ;

    @BeforeMethod
    public void init () {
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithValidUserNameAndValidPassword () {
        loginPage.fillUserName("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

}
