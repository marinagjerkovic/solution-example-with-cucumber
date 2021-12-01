package ui.steps;

import io.cucumber.java.After;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import ui.helpers.TestContext;
import ui.helpers.WebDriverFactory;

public class Hooks extends BaseSteps {

    public Hooks(TestContext testContext) {
        super(testContext);
    }

    @BeforeAll
    public static void setupDriver() {
        WebDriverFactory.setupDriver();
    }

    // no need to do anything in before method because testState object is already instantiated by PicoContainer
    // and it implicitly instantiated driver, wait and pageObjectManager
//    @Before("@UI")
//    public void setup() {
//
//    }

    @After("@UI")
    public void teardown(Scenario scenario) {
        if (testContext.driver != null) {
            if (scenario.isFailed()) {
                byte[] screenshot = ((TakesScreenshot) testContext.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", scenario.getName());
            }

            testContext.driver.quit();
        }
    }
}
