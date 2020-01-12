package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.serenity.steps.sportchek.HeaderPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.RegisterPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.SignInPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.SportCheckMainPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class ErrorMassagesScenario {

    @Steps
    private SportCheckMainPageSteps sportCheckMainPageSteps;

    @Steps
    private HeaderPanelSteps headerPanelSteps;

    @Steps
    private SignInPanelSteps signInPanelSteps;

    @Steps
    private RegisterPanelSteps registerPanelSteps;

    @Given("user opened page using following url: '$url'")
    public void openSite(final String url) {
        sportCheckMainPageSteps.openPage(url);
    }

    @Given("user clicks Sign In/Create Account button")
    public void openSignIn() {
        signInPanelSteps.openSignInForm();
    }

    @Given("user clicks Register Now button")
    public void openRegisterNowForm() {
        registerPanelSteps.openRegisterForm();
    }

    @When("user typed one character in each input field: '$item" )
    public void enterTextToInputField(final String item) {
        
    }

    @Then("following message is displayed in Email input field: '$message'")
    public void isErrorMessageEmail(final String message) {

    }

    @Then("following message is displayed in Confirm Email input field: '$message2'")
    public void isErrorMessageConfirmEmail(final String message2) {

    }

    @Then("following message is displayed in Password input field: '$message3'")
    public void isErrorMessagePassword(final String message3) {

    }

    @Then("following message is displayed in Confirm Password input field: '$message4'")
    public void isErrorMessageConfirmPassword(final String message4) {

    }

}
