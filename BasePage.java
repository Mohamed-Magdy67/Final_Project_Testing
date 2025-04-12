

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    public static long Wait = 60;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitTimeToBeClickable(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Wait);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitTimeToBeVisible(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Wait);
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
}
