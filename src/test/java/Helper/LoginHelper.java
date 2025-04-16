package Helper;

import Tests.Test_Base;
import Pages.LoginPage;

public class LoginHelper {
    LoginPage loginPage = new LoginPage(Test_Base.driver);

    public void loginWithValidUsernameAndValidPassword() {
        loginPage.fillUserName("standard_user");
        loginPage.fillPassword("secret_sauce");
    }

}



