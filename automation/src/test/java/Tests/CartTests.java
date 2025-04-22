package Tests;

import Helper.CartHelper;
import Helper.LoginHelper;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartTests extends Test_Base {
    private CartHelper cartHelper;
    private LoginHelper loginHelper;

    @BeforeMethod
    public void setUpTest() {
        loginHelper = new LoginHelper(driver);
        cartHelper = new CartHelper(driver);
        loginHelper.loginWithValidUsernameAndPassword();  
    }

    @Test
    public void verifyItemAdditionAndCartNavigation() {
        cartHelper.addFirstItemAndVerify();
    }

    @Test
    public void verifyItemRemovalFlow() {
        cartHelper.addFirstItemAndVerify();
        cartHelper.removeFirstItemAndVerify();
    }
}
