package Tests;
import Helper.LoginHelper;
import Pages.ProductPage;
import Pages.CheckoutStepTwoPage;
import Pages.checkoutPage;
import Pages.AddToCartPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutStepTwoTest extends TestBase {

    ProductPage productPage;
    checkoutPage checkoutInfoPage;
    CheckoutStepTwoPage stepTwoPage;
    AddToCartPage cartPage;
    LoginHelper loginHelper;

    @BeforeMethod
    public void setup() {
        loginHelper = new LoginHelper(driver);
        loginHelper.loginWithValidUsernameAndPassword();
        productPage = new ProductPage(driver);
        checkoutInfoPage = new checkoutPage(driver);
        cartPage = new AddToCartPage(driver);
        stepTwoPage = new CheckoutStepTwoPage(driver);

        productPage.clickAddToCartBtn();
        productPage.clickCartIcon();
        cartPage.clickCheckOutBtn();
        checkoutInfoPage.fillfirstname("Mohamed");
        checkoutInfoPage.filllastname("Magdy");
        checkoutInfoPage.fillpostalcode("12345");
        checkoutInfoPage.clickcontinue();
    }

    @Test
    public void testSummaryContainerIsDisplayed() {
        Assert.assertTrue(stepTwoPage.isLoadedWithOrderSummary(), "Summary container is not displayed.");
    }

    @Test
    public void testProductNameIsCorrect() {
        String name = stepTwoPage.getProductName();
        Assert.assertFalse(name.isEmpty(), "Product name is empty.");
        Assert.assertEquals(name, "Sauce Labs Backpack", "Product name is incorrect.");
    }

    @Test
    public void testProductPriceIsCorrect() {
        String price = stepTwoPage.getProductPrice();
        Assert.assertFalse(price.isEmpty(), "Product price is empty.");
        Assert.assertEquals(price, "$29.99", "Product price is incorrect.");
    }

    @Test
    public void testPaymentInfoIsDisplayed() {
        String payment = stepTwoPage.getPaymentInfo();
        Assert.assertFalse(payment.isEmpty(), "Payment info is not displayed.");
    }

    @Test
    public void testShippingInfoIsDisplayed() {
        String shipping = stepTwoPage.getShippingInfo();
        Assert.assertFalse(shipping.isEmpty(), "Shipping info is not displayed.");
    }

    @Test
    public void testAllSummaryDetailsAreVisible() {
        Assert.assertTrue(stepTwoPage.isLoadedWithOrderSummary(), "Summary container is not displayed.");
        Assert.assertFalse(stepTwoPage.getProductName().isEmpty(), "Product name is empty.");
        Assert.assertFalse(stepTwoPage.getProductPrice().isEmpty(), "Product price is empty.");
        Assert.assertFalse(stepTwoPage.getPaymentInfo().isEmpty(), "Payment info is empty.");
        Assert.assertFalse(stepTwoPage.getShippingInfo().isEmpty(), "Shipping info is empty.");
    }
}
