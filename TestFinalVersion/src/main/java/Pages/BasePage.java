package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public static final long WAIT_TIME = 60;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME));

    }

    private void waitForElement(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));

    }

    public void waitTimeToBeClickable(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }

    public void sendKeys(By element, String value) {
        waitForElement(element);
        driver.findElement(element).sendKeys(value);
    }

    public void clickOnElement(By element) {
        waitForElement(element);
        waitTimeToBeClickable(element);
        driver.findElement(element).click();
    }

    public String getTextSafely(By locator) {
        try {
            waitForElement(locator);
            return driver.findElement(locator).getText().trim();
        } catch (Exception e) {
            return null;
        }
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }


    public boolean isElementVisible(By locator) {
        try {
            waitForElement(locator);
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementInvisible(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isTextEqual(By locator, String expectedText) {
        try {
            String actualText = driver.findElement(locator).getText().trim();
            return actualText.equals(expectedText.trim());
        } catch (Exception e) {
            System.out.println("Text comparison failed: " + e.getMessage());
            return false;
        }
    }

    public String getElementText(By locator) {
        try {
            return driver.findElement(locator).getText();
        } catch (NotFoundException e) {
            System.out.println("Not Found Element" + locator);
            return null;
        }
    }
}
