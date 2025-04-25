package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base_Page{

    By userName = By.xpath("//input[@id=\"user-name\"]");
    By password = By.xpath("//input[@id=\"password\"]");
    By loginButton = By.xpath("//button[@type=\"submit\"]");
    By requiredErrorUsernameMessage = By.xpath("//h3[@data-test='error' and contains(text(), 'Username is required')]");
    By requiredErrorPasswordMessage = By.xpath("//h3[@data-test='error' and contains(text(), 'Password is required')]");
    By invalidCredentialMessage = By.xpath("//h3[@data-test='error' and contains(text(), 'do not match')]");

    private String requiredErrorUsernameTextExpectResult = "Epic sadface: Username is required";
    private String requiredErrorPasswordTextExpectResult = "Epic sadface: Password is required";
    private String invalidCredentialExpectedResult = "Epic sadface: Username and password do not match any user in this service";

    public String getRequiredErrorUsernameTextExpectResult(){
        return requiredErrorUsernameTextExpectResult;
    }

    public String getRequiredErrorPasswordTextExpectResult(){
        return requiredErrorPasswordTextExpectResult;
    }

    public String getInvalidCredentialExpectedResult(){
        return  invalidCredentialExpectedResult;
    }

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUserName(String name){
        sendKeys(userName,name);
    }

    public void fillPassword(String password){
        sendKeys(this.password,password);
    }

    public void clickOnLoginButton() {
        clickOnElement(loginButton);
    }

    public String requiredErrorMessageUsernameActualResult(){
        return getElementText(requiredErrorUsernameMessage);
    }

    public String requiredErrorMessagePasswordActualResult(){
        return getElementText(requiredErrorPasswordMessage);
    }

    public String invalidCredentialActualResult(){
        return getElementText(invalidCredentialMessage);
    }

}
