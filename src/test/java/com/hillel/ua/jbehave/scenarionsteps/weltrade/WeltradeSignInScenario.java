package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.page_object.model.weltrade.WeltradeUserAutorizationModel;
import com.hillel.ua.serenity.steps.weltrade.WeltradeSignInSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class WeltradeSignInScenario {

    @Steps
    private WeltradeSignInSteps weltradeSignInSteps;

    @When("user tries to sign in to Weltrade site , using following info: $info")
    public void authorizationUser(final ExamplesTable info) {

        final WeltradeUserAutorizationModel userCredentialInfo = info.getRowsAs(WeltradeUserAutorizationModel.class).get(0);
        weltradeSignInSteps.tryRegisterUser(userCredentialInfo);
    }
}
