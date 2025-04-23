package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class checkoutPage extends BasePage {

    private WebDriver driver;
    By pageTitle = By.xpath("//div[@class='subheader' and text()='Checkout: Your Information']");
    By first_name = By.id("first-name");
    By last_name = By.id("last-name");
    By postal_code = By.id("postal-code");
    By continuebutton = By.cssSelector(".btn_primary.cart_button");
    By cancelbutton = By.cssSelector(".cart_cancel_link.btn_secondary");
    By erroricon = By.xpath("//*[@class=\"svg-inline--fa fa-times-circle fa-w-16 fa-2x \"]");


    public checkoutPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }
    
    public boolean isCheckoutFormDisplayed() {
        return isElementVisible(pageTitle);
    }
    public void fillfirstname(String name){
        sendKeys(first_name,name);
    }
    public void filllastname(String name2){
        sendKeys(last_name,name2);
    }
    public void fillpostalcode(String PC){

        sendKeys(postal_code,PC);
    }

    public void clickcontinue()
    {
        clickOnElement(continuebutton);
    }
    public void clickcancel()
    {
        clickOnElement(cancelbutton);
    }
    public void clickonerror()
    {
        clickOnElement(erroricon);
    }


}
