package ui.steps;

import ui.helpers.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.pages.AuthenticationPage;
import ui.pages.MyAccountPage;

import static org.testng.Assert.*;

public class LoginSteps {
    private TestContext testContext;
    private AuthenticationPage authenticationPage;
    private MyAccountPage myAccountPage;

    public LoginSteps(TestContext testContext) {
        this.testContext = testContext;
        authenticationPage = testContext.pageObjectManager.getAuthenticationPage();
        myAccountPage = testContext.pageObjectManager.getMyAccountPage();
    }

    @Given("user is on authentication page")
    public void user_is_on_authentication_page() {
        testContext.driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        assertTrue(authenticationPage.waitUntilElementShown(authenticationPage.getEmailFieldLogin()));
    }

    @When("user logs in with email {string} and password {string}")
    public void user_logs_in_with_email_and_password(String email, String password) {
        authenticationPage.login(email, password);
    }

    @Then("user is navigated to my account page")
    public void user_is_navigated_to_my_account_page() {
        assertTrue(myAccountPage.getMyAccountLabel().isDisplayed());
    }

    @Then("first error message is shown with text {string}")
    public void first_error_message_is_shown_with_text(String text) {
        assertTrue(authenticationPage.getFirstErrorMessage().isDisplayed());
        assertEquals(authenticationPage.getFirstErrorMessage().getText(), text);
    }
}
