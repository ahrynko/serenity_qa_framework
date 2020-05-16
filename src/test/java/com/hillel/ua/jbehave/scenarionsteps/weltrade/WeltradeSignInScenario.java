package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.common.data.EnvironmentProperties;
import com.hillel.ua.page_object.model.weltrade.UserAutorizationModel;
import com.hillel.ua.serenity.steps.weltrade.WeltradeSignInSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class WeltradeSignInScenario {

    @Steps
    private WeltradeSignInSteps weltradeSignInSteps;

    @Given("user opened 'Authorization Page' by url: '$url'")
    public void openLoginPage(final EnvironmentProperties environmentProperties) {

        final String commonUrl = environmentProperties.readProperty();
        weltradeSignInSteps.openPageByPartialUrl(commonUrl);

    }

    @When("user tries to sign in to Weltrade site , using following info: $info")
    public void authorizationUser(final ExamplesTable info) {

        final UserAutorizationModel userCredentialInfo = info.getRowsAs(UserAutorizationModel.class).get(0);
        weltradeSignInSteps.tryRegisterUser(userCredentialInfo);
    }

    @When("user clicks 'Login via Google' button")
    public void openGoogleForm() {
        weltradeSignInSteps.openGoogleForm();
    }

}
