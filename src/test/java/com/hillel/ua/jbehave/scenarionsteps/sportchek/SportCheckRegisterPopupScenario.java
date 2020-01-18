package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.page_object.model.UserRegistrationModel;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class SportCheckRegisterPopupScenario {

    @When("user tries to sign up, using following info: $info")
    public void registerNewUser(final UserRegistrationModel registerInfo) {  //object ExamplesTable (для подтягивания таблички из .story)

    }
}
