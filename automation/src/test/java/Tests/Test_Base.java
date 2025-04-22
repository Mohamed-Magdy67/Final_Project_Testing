package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class Test_Base {
    public static WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
            "--no-sandbox",
            "--disable-dev-shm-usage",
            "--start-maximized",
            "--incognito"
        );
        
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        System.out.println("Browser opened");

        // Navigate to the site after opening the browser
        driver.get("https://www.saucedemo.com/v1");  // Replace with the URL you want to visit
        System.out.println("Navigated to the site: https://www.saucedemo.com/v1");
    }

    @AfterMethod
    public void closeBrowser() {
        System.out.println("Closing browser...");
        if (driver != null) {
            try {
                driver.quit();
                System.out.println("Browser closed successfully");
            } catch (Exception e) {
                System.out.println("Failed to close browser: " + e.getMessage());
            }
        }
    }
}
