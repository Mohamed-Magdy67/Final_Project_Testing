package Helper;

import Pages.ProductPage;
import Pages.AddToCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CartHelper {
    private final ProductPage productPage;
    private final AddToCartPage addToCartPage;
    private String lastItemName;

    public CartHelper(WebDriver driver) {
        this.productPage = new ProductPage(driver);
        this.addToCartPage = new AddToCartPage(driver);
    }

    public void addFirstItemAndVerify() {
        // Get and store item name
        lastItemName = productPage.getFirstItemName();
        System.out.println("Adding item to cart: " + lastItemName);

        // Add to cart and verify
        productPage.clickAddToCartBtn();
        Assert.assertTrue(productPage.isItemAddedToCart(), 
            "FAIL: Cart badge not updated after adding " + lastItemName);
        System.out.println("PASS: Item added to cart - badge updated");

     // Navigate to cart and verify
        productPage.clickCartIcon();
        Assert.assertTrue(addToCartPage.verifyCartPageLoaded(), 
            "FAIL: Cart page did not load properly");
        Assert.assertTrue(addToCartPage.isItemPresentInCart(), 
            "FAIL: " + lastItemName + " not found in cart");
        System.out.println("PASS: " + lastItemName + " successfully added to cart");

    }

    public void removeFirstItemAndVerify() {
        System.out.println("Removing item from cart: " + lastItemName);
        
        // Remove and verify
        addToCartPage.clickRemoveBtn();
        Assert.assertTrue(productPage.isItemRemovedFromCart(), 
            "FAIL: Cart badge still shows items after removal");
        Assert.assertFalse(addToCartPage.isItemPresentInCart(), 
            "FAIL: " + lastItemName + " still appears in cart");
        System.out.println("PASS: " + lastItemName + " successfully removed from cart");
        
        // Return to products page
        addToCartPage.clickContinueShoppingBtn();
    }
}