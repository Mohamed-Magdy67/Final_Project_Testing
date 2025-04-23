package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartPage extends BasePage {

    public AddToCartPage(WebDriver driver) {
        super(driver);
    }

    private By pageTitle = By.xpath("//div[@class='subheader' and text()='Your Cart']");
    private By cartItemQuantity = By.xpath("//div[@class='cart_quantity']");
    private By removeBtn = By.xpath("(//button[normalize-space()='REMOVE'])[1]");
    private By checkOutBtn = By.cssSelector(".btn_action.checkout_button");
    private By continueShoppingBtn = By.xpath("(//a[normalize-space()='Continue Shopping'])[1]");
    private By itemNameInCart = By.cssSelector(".inventory_item_name");

    public boolean verifyCartPageLoaded() {
        return isElementVisible(pageTitle);
    }

    public boolean checkQuantity(String quantity) {
        return isTextEqual(cartItemQuantity, quantity);
    }

    public void clickRemoveBtn() {
        clickOnElement(removeBtn);
    }

    public void clickCheckOutBtn() {
        clickOnElement(checkOutBtn);
    }

    public void clickContinueShoppingBtn() {
        clickOnElement(continueShoppingBtn);
    }

    public boolean isItemPresentInCart() {
        return isElementVisible(itemNameInCart);
    }

    public boolean isItemNotPresentInCart() {
        return isElementInvisible(itemNameInCart);
    }
}
