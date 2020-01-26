package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.page_object.model.weltrade.UserRegistartionErrorsModel;
import com.hillel.ua.page_object.model.weltrade.UserRegistrationModel;

import com.hillel.ua.serenity.steps.weltrade.WeltradeSignUpSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.unitils.reflectionassert.ReflectionAssert;

public class WeltradeSignUpScenario {

    @Steps
    private WeltradeSignUpSteps weltradeSignUpSteps;

    @When("user tries to sign up to Weltrade  site , using following info: $info")
    public void registerNewUser(final ExamplesTable info) {

        final UserRegistrationModel registerInfo = info.getRowsAs(UserRegistrationModel.class).get(0);
        weltradeSignUpSteps.tryRegisterUser(registerInfo);
    }

    @Then("following errors displayed to site Weltrade: $errors")
    public void verifySignUpErrorsDisplayed(final ExamplesTable errors) {

        final UserRegistartionErrorsModel expectedErrors = errors.getRowsAs(UserRegistartionErrorsModel.class).get(0);
        final UserRegistartionErrorsModel actualErrors = weltradeSignUpSteps.getDisplayedErrors(); //from the site

        ReflectionAssert.assertReflectionEquals("There are incorrect errors displayed!",
                expectedErrors, actualErrors);
    }
}
