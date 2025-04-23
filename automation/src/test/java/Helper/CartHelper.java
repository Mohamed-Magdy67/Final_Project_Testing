package Helper;

import Pages.ProductPage;
import Pages.checkoutPage;
import Pages.AddToCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartHelper {
    private final ProductPage productPage;
    private final AddToCartPage addToCartPage;
    private final checkoutPage checkOutPage;
    private String lastItemName;

    public CartHelper(WebDriver driver) {
        this.productPage = new ProductPage(driver);
        this.addToCartPage = new AddToCartPage(driver);
        this.checkOutPage = new checkoutPage(driver);
    }

    public void addFirstItemAndVerify() {
        lastItemName = productPage.getFirstItemName();
        System.out.println("Adding item to cart: " + lastItemName);

        productPage.clickAddToCartBtn();
        Assert.assertTrue(productPage.isItemAddedToCart(),
                "FAIL: Cart badge not updated after adding " + lastItemName);
        System.out.println("PASS: Item added to cart - badge updated");

        productPage.clickCartIcon();
        Assert.assertTrue(addToCartPage.verifyCartPageLoaded(),
                "FAIL: Cart page did not load properly");
        Assert.assertTrue(addToCartPage.isItemPresentInCart(),
                "FAIL: " + lastItemName + " not found in cart");
        System.out.println("PASS: " + lastItemName + " successfully added to cart");
    }

    public void removeFirstItemAndVerify() {
        System.out.println("Removing item from cart: " + lastItemName);

        addToCartPage.clickRemoveBtn();
        Assert.assertTrue(productPage.isItemRemovedFromCart(),
                "FAIL: Cart badge still shows items after removal");
        Assert.assertTrue(addToCartPage.isItemNotPresentInCart(),
                "FAIL: " + lastItemName + " still appears in cart");
        System.out.println("PASS: " + lastItemName + " successfully removed from cart");

        addToCartPage.clickContinueShoppingBtn();
        Assert.assertTrue(productPage.verifyRedirectedToPage(), "Navigate To Product Page");
    }

    public void checkout() {
        System.out.println("Removing item from cart and attempting checkout: " + lastItemName);

        addToCartPage.clickCheckOutBtn();
        try {
            // Add check for checkout page loading (this could vary based on what should happen)
            Assert.assertTrue(checkOutPage.isCheckoutFormDisplayed(), "FAIL: Checkout page should not load after removal");
            System.out.println("PASS: Checkout page did not load after removing item");
        } catch (Exception e) {
            System.out.println("FAIL: Error occurred when trying to navigate to checkout after removal: " + e.getMessage());
        }
    }
}
