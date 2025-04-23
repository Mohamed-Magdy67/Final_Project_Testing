package Tests;

import Helper.CartHelper;
import Helper.LoginHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends TestBase {
    private CartHelper cartHelper;
    private LoginHelper loginHelper;

    @BeforeMethod
    public void setUpTest() {
        loginHelper = new LoginHelper(driver);
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
	public void verifyInvalidCheckoutAfterItemRemoval() {
        cartHelper.addFirstItemAndVerify();
        cartHelper.removeFirstItemAndVerify();
	}
	@Test 
	public void verifyContinueShoppingAfterItemRemoval() {
        cartHelper.addFirstItemAndVerify();
        cartHelper.removeFirstItemAndVerify();
	}
	
}
