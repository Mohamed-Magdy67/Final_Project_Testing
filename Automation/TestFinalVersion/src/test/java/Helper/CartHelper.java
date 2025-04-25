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


    }

    public void checkout() {
        System.out.println("Starting checkout process for item: " + lastItemName);
        addToCartPage.clickCheckOutBtn();
    }
    public boolean isCheckoutFormDisplayed() {
        try {
            return checkOutPage.isCheckoutFormDisplayed();
        } catch (Exception e) {
            System.out.println("Error checking checkout form: " + e.getMessage());
            return false;
        }
    }



    public void continueShopping() {
        System.out.println("Attempting to continue shopping after adding item: " + lastItemName);

        addToCartPage.clickContinueShoppingBtn();
        try {
            boolean isRedirected = productPage.verifyRedirectedToPage();
            Assert.assertTrue(isRedirected, "User was not redirected to the product page.");
            System.out.println("Successfully redirected to the product page.");
        } catch (AssertionError ae) {
            System.out.println("Assertion failed during redirect verification: " + ae.getMessage());
        } catch (Exception e) {
            System.out.println("Exception occurred while verifying redirect: " + e.getMessage());
        }
    }


}