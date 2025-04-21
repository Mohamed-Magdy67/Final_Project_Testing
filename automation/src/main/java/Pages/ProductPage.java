package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends Base_Page {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    // Identify elements
    private By pageTitle = By.cssSelector(".product_label");
    private By addToCart_Btn_FristItem = By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]");
    private By remove_Btn_FristItem = By.xpath("(//button[normalize-space()='REMOVE'])[1]");
    private By shoppingCartBadge = By.cssSelector(".fa-layers-counter.shopping_cart_badge");

    // Methods
    public boolean verifyRedirectedToPage() {
        return isElementVisible(pageTitle);
    }

    public void clickAddToCartBtn() {
        clickOnElement(addToCart_Btn_FristItem);
    }

    public void clickOnRemoveCart() {
        clickOnElement(remove_Btn_FristItem);
    }

    public boolean isItemAddedToCart() {
        return isElementVisible(shoppingCartBadge);
    }
    public boolean isItemRemovedFromCart() {
        return isElementInvisible(shoppingCartBadge);
    }

}
