package ui.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import ui.helpers.Links;
import ui.helpers.SharedData;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginSteps extends BaseSteps {

    public LoginSteps() {
        authenticationPage = SharedData.pageObjectManager.getAuthenticationPage();
        myAccountPage = SharedData.pageObjectManager.getMyAccountPage();
    }

    @Given("user is on authentication page")
    public void user_is_on_authentication_page() {
        SharedData.driver.get(Links.authenticationPage);
        assertTrue(authenticationPage.waitUntilElementShown(authenticationPage.getEmailFieldLogin()));
    }

    @When("user logs in with email {string} and password {string}")
    public void user_logs_in_with_email_and_password(String email, String password) {

        authenticationPage.login(email, password);
    }

    @Then("user should be navigated to my account page")
    public void user_should_be_navigated_to_my_account_page() {
        assertTrue(myAccountPage.isElementDisplayed(myAccountPage.getMyAccountLabel()));
    }

    @Then("first error message is shown with text {string}")
    public void first_error_message_is_shown_with_text(String text) {
        assertTrue(authenticationPage.isElementDisplayed(authenticationPage.getFirstErrorMessage()));
        assertEquals(authenticationPage.getFirstErrorMessage().getText(), text);
    }
}
