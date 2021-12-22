package ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.helpers.PageObjectManager;
import ui.helpers.SharedData;
import ui.helpers.WebDriverFactory;

import java.time.Duration;

public class Hooks {

    @BeforeAll
    public static void setupDriver() {
        WebDriverFactory.setupDriver();
    }

    @Before("@UI")
    public void setup() {
        SharedData.driver = WebDriverFactory.createWebDriver();
        SharedData.wait = new WebDriverWait(SharedData.driver, Duration.ofSeconds(10));
        SharedData.driver.manage().window().maximize();

        SharedData.pageObjectManager = new PageObjectManager(SharedData.driver, SharedData.wait);
    }

    @After("@UI")
    public void teardown(Scenario scenario) {
        if (SharedData.driver != null) {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) SharedData.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }

            SharedData.driver.quit();
        }
    }
}
