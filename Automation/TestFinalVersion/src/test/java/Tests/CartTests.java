package Tests;

import Helper.CartHelper;
import Helper.LoginHelper;
import Pages.AddToCartPage;
import Pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends TestBase {
    private CartHelper cartHelper;
    private ProductPage productPage;
    private AddToCartPage addToCartPage;
    private LoginHelper loginHelper;

    @BeforeMethod
    public void setUpTest() {
        loginHelper = new LoginHelper(driver);
        productPage = new ProductPage(driver);
        addToCartPage = new AddToCartPage(driver);
        cartHelper = new CartHelper(driver);
        loginHelper.loginWithValidUsernameAndPassword();
    }

    @Test
    public void verifyItemAdditionAndCartAndContinueShopping() {

        cartHelper.addFirstItemAndVerify();

    }

    @Test
    public void verifyItemRemovalFlow() {
        cartHelper.addFirstItemAndVerify();
        cartHelper.removeFirstItemAndVerify();
    }

    @Test
    public void verifyContinueShoppingAfterItemRemoval() {
        cartHelper.addFirstItemAndVerify();
        cartHelper.removeFirstItemAndVerify();
        cartHelper.continueShopping();
    }

    @Test
    public void verifyInvalidCheckoutAfterItemRemoval() {
        cartHelper.addFirstItemAndVerify();
        cartHelper.removeFirstItemAndVerify();
        cartHelper.checkout();

        boolean isFormDisplayed = cartHelper.isCheckoutFormDisplayed();
        Assert.assertFalse(isFormDisplayed, "Checkout form should not be displayed after removing the item.");
    }


}