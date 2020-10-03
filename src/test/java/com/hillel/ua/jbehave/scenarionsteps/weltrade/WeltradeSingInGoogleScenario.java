package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.serenity.steps.weltrade.WeltradeSingInGoogleSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class WeltradeSingInGoogleScenario {

    @Steps
    private WeltradeSingInGoogleSteps weltradeSingInGoogleSteps;

    @When("user tries to login to Weltrade site via Google: '$email'")
    public void loginViaGoogle(final String email) {
        weltradeSingInGoogleSteps.loginViaGoogle(email);
        weltradeSingInGoogleSteps.clickNextButton();
    }

    @When("user tries to login to Weltrade site: '$pass'")
    public void loginViaGooglePass(final String pass) {
        weltradeSingInGoogleSteps.loginViaGooglePass(pass);
        weltradeSingInGoogleSteps.clickPassNextButton();
    }


}


