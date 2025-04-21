package Tests;

import org.testng.Assert;
import org.testng.annotations.*;

import Helper.LoginHelper;
import Pages.ProductPage;

public class ProductTest extends Test_Base {
    private ProductPage productPage;
    private LoginHelper loginHelper;

    @BeforeMethod
    public void setUp() {
        // Initialize page objects
        productPage = new ProductPage(driver);
        loginHelper = new LoginHelper(driver);
        
        // Perform login and verify
        loginHelper.loginWithValidUsernameAndPassword();
    }

    @Test
    public void testAddAndRemoveItemFromCart() {
        Assert.assertTrue(productPage.verifyRedirectedToPage(), "Navigate To Product Page");

        
        productPage.clickAddToCartBtn();
        Assert.assertTrue(productPage.isItemAddedToCart(), "Item should be added");

        productPage.clickOnRemoveCart();
        Assert.assertTrue(productPage.isItemRemovedFromCart(), "Item should be removed");
    }
}