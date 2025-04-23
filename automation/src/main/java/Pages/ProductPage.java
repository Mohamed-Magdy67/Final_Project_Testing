package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private By pageTitle = By.cssSelector(".product_label");
    private By addToCartBtnFirstItem = By.xpath("//div[@class='inventory_list']//div[1]//div[3]//button[1]");
    private By removeBtnFirstItem = By.xpath("(//button[normalize-space()='REMOVE'])[1]");
    public By shoppingCartBadge = By.cssSelector(".fa-layers-counter.shopping_cart_badge");
    private By cartIcon = By.xpath("//a[@class='shopping_cart_link fa-layers fa-fw']//*[name()='svg']");
    private By firstItem = By.cssSelector(".inventory_item_name");

    public boolean verifyRedirectedToPage() {
        return isElementVisible(pageTitle);
    }

    public String getFirstItemName() {
        return getTextSafely(firstItem);
    }

    public void clickAddToCartBtn() {
        clickOnElement(addToCartBtnFirstItem);
    }

    public void clickRemoveFromCartBtn() {
        clickOnElement(removeBtnFirstItem);
    }

    public void clickCartIcon() {
        clickOnElement(cartIcon);
    }

    public boolean isItemAddedToCart() {
        return isElementVisible(shoppingCartBadge);
    }

    public boolean isItemRemovedFromCart() {
        return isElementInvisible(shoppingCartBadge);
    }
}
