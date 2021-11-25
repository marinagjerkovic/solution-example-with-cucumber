package ui.steps;

import ui.helpers.TestContext;
import ui.pages.AuthenticationPage;
import ui.pages.HeaderMenuPage;
import ui.pages.MyAccountPage;

public class BaseSteps {
    TestContext testContext;

    AuthenticationPage authenticationPage;
    MyAccountPage myAccountPage;
    HeaderMenuPage headerMenuPage;

    public BaseSteps(TestContext testContext) {
        this.testContext = testContext;
    }
}
