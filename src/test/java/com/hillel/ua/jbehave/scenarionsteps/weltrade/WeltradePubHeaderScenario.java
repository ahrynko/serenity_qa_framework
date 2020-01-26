package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.serenity.steps.weltrade.WeltradePubHeaderSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class WeltradePubHeaderScenario {

    @Steps
    private WeltradePubHeaderSteps weltradePubHeaderSteps;

    @When("user clicks 'Login' button")
    public void clickLoginButton() {
        weltradePubHeaderSteps.openSignInPage();
    }

    @When("user clicks 'Registration' button")
    public void clickRegistrationButton() {
        weltradePubHeaderSteps.openSignUpPage();
    }
}
