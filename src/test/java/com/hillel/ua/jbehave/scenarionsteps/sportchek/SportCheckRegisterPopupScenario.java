package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.page_object.model.sportchek.RegisterErrorsModel;
import com.hillel.ua.page_object.model.sportchek.UserRegistrationModel;
import com.hillel.ua.serenity.steps.sportchek.SportCheckRegisterPopupSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.unitils.reflectionassert.ReflectionAssert;

public class SportCheckRegisterPopupScenario {

    @Steps
    private SportCheckRegisterPopupSteps sportCheckRegisterPopupSteps;

    @When("user tries to sign up, using following info: $info")
    public void registerNewUser(final ExamplesTable info) {  //object ExamplesTable (для подтягивания таблички из .story)
        final UserRegistrationModel registerInfo = info.getRowsAs(UserRegistrationModel.class).get(0);
        sportCheckRegisterPopupSteps.tryRegisterUser(registerInfo);
    }

    @Then("following error displayed: $errors")
    public void verifySignUpErrorsDisplayed(final ExamplesTable errors) {
        final RegisterErrorsModel expectedErrors = errors.getRowsAs(RegisterErrorsModel.class).get(0); //from the story
        final RegisterErrorsModel actualErrors = sportCheckRegisterPopupSteps.getDisplayedErrors();   //from the site
        ReflectionAssert.assertReflectionEquals("There are incorrect errors displayed!",
                expectedErrors, actualErrors);
    }
}
