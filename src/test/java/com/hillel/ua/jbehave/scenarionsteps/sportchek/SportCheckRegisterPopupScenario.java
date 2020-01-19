package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.page_object.model.UserRegistrationModel;
import com.hillel.ua.serenity.steps.sportchek.SportCheckRegisterPopupSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class SportCheckRegisterPopupScenario {

    @Steps
    private SportCheckRegisterPopupSteps sportCheckRegisterPopupSteps;

    @When("user tries to sign up, using following info: $info")
    public void registerNewUser(final ExamplesTable info) {  //object ExamplesTable (для подтягивания таблички из .story)
        final UserRegistrationModel registerInfo = info.getRowsAs(UserRegistrationModel.class).get(0);
        sportCheckRegisterPopupSteps.tryRegisterUser(registerInfo);
    }
}
