package Tests;

import Helper.LoginHelper;
import Pages.ProductPage;
import Pages.checkoutPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.AddToCartPage;



public class CheckoutTest  extends TestBase {
    LoginPage loginpage;
    ProductPage productpage;
    checkoutPage check;
    AddToCartPage AddPage;
    private LoginHelper loginHelper;


    @BeforeMethod
    public void init(){
        loginHelper = new LoginHelper(driver);
        loginHelper.loginWithValidUsernameAndPassword();
        loginpage = new LoginPage(driver);
        check = new checkoutPage(driver);
        productpage = new ProductPage(driver);
        AddPage = new AddToCartPage(driver);
    }

    @Test
    public void testloading() throws InterruptedException {
        productpage.clickAddToCartBtn();
        productpage.clickCartIcon();
        AddPage.clickCheckOutBtn();

    }

    @Test
    public void testwithempty() throws InterruptedException {
        productpage.clickAddToCartBtn();
        productpage.clickCartIcon();
        AddPage.clickCheckOutBtn();
        check.clickcontinue();
        Thread.sleep(2000);
        check.clickonerror();

    }

    @Test
    public void testwithemptyfirstname() throws InterruptedException {
        productpage.clickAddToCartBtn();
        productpage.clickCartIcon();
        AddPage.clickCheckOutBtn();
        check.fillfirstname("");
        check.filllastname("Magdy");
        check.fillpostalcode("02134229");
        check.clickcontinue();
        Thread.sleep(2000);
        check.clickonerror();

    }

    @Test
    public void testwithemptylastname() throws InterruptedException {
        productpage.clickAddToCartBtn();
        productpage.clickCartIcon();
        AddPage.clickCheckOutBtn();
        check.fillfirstname("Mohamed");
        check.filllastname("");
        check.fillpostalcode("02134229");
        check.clickcontinue();
        Thread.sleep(2000);
        check.clickonerror();

    }

    @Test
    public void testwithemptypostalcode() throws InterruptedException {
        productpage.clickAddToCartBtn();
        productpage.clickCartIcon();
        AddPage.clickCheckOutBtn();
        check.fillfirstname("Mohamed");
        check.filllastname("Magdy");
        check.fillpostalcode("");
        check.clickcontinue();
        Thread.sleep(2000);
        check.clickonerror();


    }

    @Test
    public void testwithinvalidcode() throws InterruptedException {
        productpage.clickAddToCartBtn();
        productpage.clickCartIcon();
        AddPage.clickCheckOutBtn();
        check.fillfirstname("Mohamed");
        check.filllastname("Magdy");
        check.fillpostalcode("abc");
        check.clickcontinue();


    }

    @Test
    public void testvalidinputs() throws InterruptedException {
        productpage.clickAddToCartBtn();
        productpage.clickCartIcon();
        AddPage.clickCheckOutBtn();
        check.fillfirstname("Mohamed");
        check.filllastname("Magdy");
        check.fillpostalcode("02134229");
        check.clickcontinue();

    }

    @Test
    public void testwithinvalidcode2() throws InterruptedException {
        productpage.clickAddToCartBtn();
        productpage.clickCartIcon();
        AddPage.clickCheckOutBtn();
        check.fillfirstname("Mohamed");
        check.filllastname("Magdy");
        check.fillpostalcode("1234567890");
        check.clickcontinue();

    }


}
