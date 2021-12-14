package ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import ui.pages.BasePage;

@Getter
public class AuthenticationPage extends BasePage {
    public AuthenticationPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email_create")
    WebElement emailFieldCreateAccount;

    @FindBy(id = "SubmitCreate")
    WebElement createAccountButton;

    @FindBy(id = "email")
    WebElement emailFieldLogin;

    @FindBy(id = "passwd")
    WebElement passwordFieldLogin;

    @FindBy(linkText = "Forgot your password?")
    WebElement forgotPassword;

    @FindBy(id = "SubmitLogin")
    WebElement loginButton;

    @FindBy(css = "#center_column > div.alert.alert-danger > ol > li")
    WebElement firstErrorMessage;

    public void login(String email, String password) {
        enterText(emailFieldLogin, email);
        enterText(passwordFieldLogin, password);
        clickElement(loginButton);
    }

}
