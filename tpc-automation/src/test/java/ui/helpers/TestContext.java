package ui.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestContext {
    public WebDriver driver;
    public WebDriverWait wait;
    public PageObjectManager pageObjectManager;

    public TestContext() {
        driver = WebDriverFactory.createWebDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

        pageObjectManager = new PageObjectManager(driver, wait);
    }
}
