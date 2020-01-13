package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.serenity.steps.sportchek.HeaderPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.RegisterPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.SignInPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.SportCheckMainPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.unitils.reflectionassert.ReflectionAssert;

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

    @When("user typed one character in each input field: '$item'")
    public void enterTextToInputField(final String item) {
        registerPanelSteps.searchLoginErrorMessage(item);
        registerPanelSteps.searchConfirmLoginMessage(item);
        registerPanelSteps.searchPasswordErrorMessage(item);
        registerPanelSteps.searchConfirmPasswordMessage(item);
    }

    @Then("following message is displayed in Email input field: '$message'")
    public void isErrorMessageEmail(final String expectedErrorMessageEmail) {
        final String actualErrorMessageEmail = registerPanelSteps.errorMessageEmail();

        ReflectionAssert.assertReflectionEquals("There is incorrect error message email displayed!",
                expectedErrorMessageEmail, actualErrorMessageEmail);
    }

    @Then("following message is displayed in Confirm Email input field: '$message2'")
    public void isErrorMessageConfirmEmail(final String expectedErrorMessageConfirmEmail) {
        final String actualErrorMessageConfirmEmail = registerPanelSteps.errorMessageConfirmEmail();

        ReflectionAssert.assertReflectionEquals("There is incorrect error message confirm email displayed!",
                expectedErrorMessageConfirmEmail, actualErrorMessageConfirmEmail);
    }

    @Then("following message is displayed in Password input field: '$message3'")
    public void isErrorMessagePassword(final String expectedErrorMessagePassword) {
        final String actualErrorMessagePassword = registerPanelSteps.errorMessagePassword();

        ReflectionAssert.assertReflectionEquals("There is incorrect error message password displayed!",
                expectedErrorMessagePassword, actualErrorMessagePassword);
    }

    @Then("following message is displayed in Confirm Password input field: '$message4'")
    public void isErrorMessageConfirmPassword(final String expectedErrorMessageConfirmPassword) {
        final String actualErrorMessageConfirmPassword = registerPanelSteps.errorMessageConfirmPassword();

        ReflectionAssert.assertReflectionEquals("There is incorrect error message confirm password displayed!",
                expectedErrorMessageConfirmPassword, actualErrorMessageConfirmPassword);
    }

}
