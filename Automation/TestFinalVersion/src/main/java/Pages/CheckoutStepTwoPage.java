package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage {
    private WebDriver driver;

    private By summaryContainer = By.id("checkout_summary_container");
    private By productName = By.className("inventory_item_name");
    private By productPrice = By.className("inventory_item_price");
    private By paymentInfo = By.xpath("//div[@class='summary_value_label'][1]");
    private By shippingInfo = By.xpath("//div[@class='summary_value_label'][2]");

    public CheckoutStepTwoPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLoadedWithOrderSummary() {
        return driver.findElement(summaryContainer).isDisplayed();
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public String getProductPrice() {
        return driver.findElement(productPrice).getText();
    }

    public String getPaymentInfo() {
        return driver.findElement(paymentInfo).getText();
    }

    public String getShippingInfo() {
        return driver.findElement(shippingInfo).getText();
    }
}
