package Helper;

import org.testng.Assert;
import Pages.LoginPage;
import Tests.Test_Base;

public class LoginHelper {
    LoginPage loginPage = new LoginPage(Test_Base.driver);

    public void LoginWithValidUsernameAndValidPassword()  {
        loginPage.fillUserName("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    public void loginWithoutData () {
        loginPage.fillUserName("");
        loginPage.fillPassword("");
        loginPage.clickOnLoginButton();

    }
    public void loginWithJustValidPassword(){
        loginPage.fillUserName("");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }

    public void loginWithJustValidUsername(){
        loginPage.fillUserName("standard_user");
        loginPage.fillPassword("");
        loginPage.clickOnLoginButton();
    }
    public void loginWithInvalidUsernameAndValidPassword(){
        loginPage.fillUserName("standard");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickOnLoginButton();
    }
    public void loginWithValidUsernameAndInvalidPassword(){
        loginPage.fillUserName("standard_user");
        loginPage.fillPassword("secret");
        loginPage.clickOnLoginButton();
    }
    public void loginWithInvalidUsernameAndInvalidPassword(){
        loginPage.fillUserName("standard");
        loginPage.fillPassword("secret");
        loginPage.clickOnLoginButton();
    }
}
