package ui.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {
    private static String browser = System.getProperty("browser");

    public static void setupDriver() {
        if (browser == null) browser = "chrome";
        switch (browser) {
            case "edge":
                WebDriverManager.edgedriver().setup();
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
            default:
                WebDriverManager.chromedriver().setup();
        }
    }

    public static WebDriver createWebDriver() {
        if (browser == null) browser = "chrome";
        switch (browser) {
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
    }
}
