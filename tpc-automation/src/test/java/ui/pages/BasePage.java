package ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean waitUntilElementShown(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean clickElement(WebElement element) {
        try {
            element.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean enterText(WebElement element, String text) {
        try {
            element.sendKeys(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        boolean isDisplayed = false;
        try {
            isDisplayed = element.isDisplayed();
        } catch (Exception e) {
        }
        return isDisplayed;
    }
}
