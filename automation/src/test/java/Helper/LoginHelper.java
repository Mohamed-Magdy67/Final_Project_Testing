package Helper;

import Pages.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

public class LoginHelper {
    private final LoginPage loginPage;
    private final WebDriver driver;  // Store driver as a field

    public LoginHelper(WebDriver driver) {
        this.driver = driver;  // Initialize the driver
        this.loginPage = new LoginPage(driver);
    }

    public void loginWithValidUsernameAndPassword() {
        loginPage.fillUserName("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickLoginButton();
        
        // Handle alert if present
        try {
            Alert alert = driver.switchTo().alert();  // Now using the stored driver
            alert.accept();
        } catch (Exception e) {
            // Alert didn't appear
        }
    }
}