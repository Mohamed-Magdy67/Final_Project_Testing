package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{

    private final By inventoryContainer = By.id("inventory_container");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInventoryDisplayed() {
        return isElementVisible(inventoryContainer);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}