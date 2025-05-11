package Tests;

import Pages.AddToCartPage;
import Pages.ProductPage;
import Pages.checkoutPage;
import Helper.LoginHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends TestBase {

    private ProductPage productPage;
    private AddToCartPage addToCartPage;
    private checkoutPage checkoutPage;
    private LoginHelper loginHelper;
    private String firstItemName;

    @BeforeMethod
    public void setUpTest() {
        loginHelper = new LoginHelper(driver);
        productPage = new ProductPage(driver);
        addToCartPage = new AddToCartPage(driver);
        checkoutPage = new checkoutPage(driver);

        loginHelper.loginWithValidUsernameAndPassword();
    }

    @Test
    public void verifyItemAdditionAndCartAndContinueShopping() {
        firstItemName = productPage.getFirstItemName();
        productPage.clickAddToCartBtn();
        Assert.assertTrue(productPage.isItemAddedToCart(), "Cart badge not updated after adding item.");

        productPage.clickCartIcon();
        Assert.assertTrue(addToCartPage.verifyCartPageLoaded(), "Cart page did not load properly.");
        Assert.assertTrue(addToCartPage.isItemPresentInCart(), "Item not found in cart.");

        addToCartPage.clickContinueShoppingBtn();
        Assert.assertTrue(productPage.verifyRedirectedToPage(), "Did not redirect back to the product page after continuing shopping.");
    }


    @Test
    public void verifyItemRemovalFlow() {
        firstItemName = productPage.getFirstItemName();
        productPage.clickAddToCartBtn();
        productPage.clickCartIcon();

        addToCartPage.clickRemoveBtn();
        Assert.assertTrue(productPage.isItemRemovedFromCart(), "Cart badge still shows items.");
        Assert.assertTrue(addToCartPage.isItemNotPresentInCart(), "Item still appears in cart.");
    }

    @Test
    public void verifyContinueShoppingAfterItemRemoval() {
        firstItemName = productPage.getFirstItemName();
        productPage.clickAddToCartBtn();
        productPage.clickCartIcon();

        addToCartPage.clickRemoveBtn();
        addToCartPage.clickContinueShoppingBtn();

        boolean isRedirected = productPage.verifyRedirectedToPage();
        Assert.assertTrue(isRedirected, "Not redirected to product page.");
    }

    @Test
    public void verifyInvalidCheckoutAfterItemRemoval() {
        firstItemName = productPage.getFirstItemName();
        productPage.clickAddToCartBtn();
        productPage.clickCartIcon();

        addToCartPage.clickRemoveBtn();
        addToCartPage.clickCheckOutBtn();

        boolean isFormDisplayed;
        try {
            isFormDisplayed = checkoutPage.isCheckoutFormDisplayed();
        } catch (Exception e) {
            isFormDisplayed = false;
        }

        Assert.assertFalse(isFormDisplayed, "Checkout form should not be displayed after item removal.");
    }
}