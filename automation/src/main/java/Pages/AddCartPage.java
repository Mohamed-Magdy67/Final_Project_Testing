package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddCartPage extends Base_Page {

	public AddCartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	// identify elements
	private By pageTitle = By.xpath("//div[@class='subheader' and text()='Your Cart']");
	private By cartItemQuantity  = By.xpath("//div[@class='cart_quantity']");
	private By Remove_eBtn = By.xpath("(//button[normalize-space()='REMOVE'])[1]");
	private By checkOut_Btn = By.cssSelector(".btn_action.checkout_button");
	private By continueShopping_Btn = By.cssSelector(".btn_action.checkout_button");
	
	//method
	public void verifyRedirectedToPage() {
		isElementVisible(pageTitle);
	}
	
	public Boolean checkQuantity(String quantity) {
		return isTextEqual(cartItemQuantity , quantity);
	}
	

	public void clickRemoveBtn() {
		clickOnElement(Remove_eBtn);
	}
	
	public void clickCheckOutBtn() {
		clickOnElement(checkOut_Btn);
	}
	
	public void clickContinueShoppingBtn() {
		clickOnElement(continueShopping_Btn);
	}
	

}
