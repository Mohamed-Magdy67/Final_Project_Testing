package Helper;

import Pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class LoginHelper {
    private final LoginPage loginPage;
    private final WebDriver driver;

    public LoginHelper(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    public void loginWithValidUsernameAndPassword() {
        loginPage.fillUserName("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickOnLoginButton();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
        }
    }
}
