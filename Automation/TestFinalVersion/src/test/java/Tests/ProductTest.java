package Tests;

import org.testng.Assert;
import org.testng.annotations.*;

import Helper.LoginHelper;
import Pages.ProductPage;

public class ProductTest extends TestBase {
    private ProductPage productPage;
    private LoginHelper loginHelper;

    @BeforeMethod
    public void setUp() {
        productPage = new ProductPage(driver);
        loginHelper = new LoginHelper(driver);
        loginHelper.loginWithValidUsernameAndPassword();
    }

    @Test
    public void testAddAndRemoveItemFromCart() {
        Assert.assertTrue(productPage.verifyRedirectedToPage(), "Navigate To Product Page");

        productPage.clickAddToCartBtn();
        Assert.assertTrue(productPage.isItemAddedToCart(), "Item should be added");

        productPage.clickRemoveFromCartBtn();
        Assert.assertTrue(productPage.isItemRemovedFromCart(), "Item should be removed");
    }
}
