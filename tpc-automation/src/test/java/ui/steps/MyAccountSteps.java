package ui.steps;

import ui.helpers.TestContext;
import io.cucumber.java.en.Then;
import ui.pages.HeaderMenuPage;

import static org.testng.Assert.assertEquals;

public class MyAccountSteps {
    private TestContext testContext;
    private HeaderMenuPage headerMenuPage;

    public MyAccountSteps(TestContext testContext) {
        this.testContext = testContext;
        headerMenuPage = testContext.pageObjectManager.getHeaderMenuPage();
    }

    @Then("user\'s name {string} and lastname {string} are shown in header")
    public void name_and_lastname_are_shown_in_header(String name, String lastname) {
        assertEquals(headerMenuPage.getMyAccountButton().getText(), name + " " + lastname);
    }

    @Then("page title has text {string}")
    public void page_title_has_text(String text) {
        assertEquals(testContext.driver.getTitle(), text);
    }
}
