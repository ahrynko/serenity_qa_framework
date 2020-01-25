package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.serenity.steps.sportchek.SignInPopupSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class SportCheckSignInPopupScenario {

    @Steps
    private SignInPopupSteps signInPopupSteps;

    @When("user clicks 'Register Now' button")
    public void clickRegisterNowButton() {
        signInPopupSteps.openRegisterNowPopup();
    }

}
