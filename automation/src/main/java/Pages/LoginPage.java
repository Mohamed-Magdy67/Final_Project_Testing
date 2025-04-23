package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    By username = By.xpath("//input[@id=\"user-name\"]");
    By password = By.xpath("//input[@id=\"password\"]");
    By loginButton = By.xpath("//input[@id='login-button']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUserName(String name){
        sendKeys(username,name);
    }

    public void fillPassword(String password){
        sendKeys(this.password,password);
    }

    public void clickLoginButton(){
        clickOnElement(this.loginButton);
    }

}
