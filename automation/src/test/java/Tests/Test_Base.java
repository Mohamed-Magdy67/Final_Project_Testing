package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.Alert;


import java.time.Duration;

public class Test_Base {
    public static WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--start-maximized"); // Start maximized
        options.addArguments("--incognito");



        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1)); // Set implicit wait
        driver.get("https://www.saucedemo.com/v1/");
        System.out.println("Current URL: " + driver.getCurrentUrl());
    }

    @AfterClass
    public void closeBrowser() {
    	System.out.println("Closing Browser");
        if (driver != null) {
            try {
                driver.quit(); // Clean shutdown
            } catch (Exception e) {
                System.out.println("Failed to quit driver: " + e.getMessage());
            }
        }
    }
}