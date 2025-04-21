package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.Alert;



import java.time.Duration;

public class Base_Page {
    protected WebDriver driver; // Changed to protected
    protected WebDriverWait wait;

    public static long Wait = 60;

    public Base_Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(Wait)); // Updated for Selenium 4
    }


    public void waitTimeToBeClickable(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitTimeToBeVisible(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void sendKeys(By element, String value) {
        waitTimeToBeVisible(element);
        driver.findElement(element).sendKeys(value);
    }

    public void clickOnElement(By element) {
        waitTimeToBeVisible(element);
        waitTimeToBeClickable(element);
        driver.findElement(element).click();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
    }

    public void selectFromDropDownList(By element, String option) {
        waitTimeToBeVisible(element);
        Select options = new Select(driver.findElement(element));
        options.selectByVisibleText(option);
    }

    public boolean isElementVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)) != null;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isElementInvisible(By locator) {
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (Exception e) {
            return false; // لو حصل exception يعتبره لسه ظاهر
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
}