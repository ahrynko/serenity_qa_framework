package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.common.data.EnvironmentProperties;
import com.hillel.ua.page_object.model.weltrade.ChangePassModel;
import com.hillel.ua.serenity.steps.weltrade.CabinetSettingsPageAuthorizationSteps;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;

public class CabinetSettingsPageAuthorizationScenario {

    @Steps
    private CabinetSettingsPageAuthorizationSteps settingsPageAuthorizationSteps;

    @When("user opened 'Settings Page Authorization' by url: '$url'")
    public void openSettingsPageAuthorization(final EnvironmentProperties environmentProperties) {
        final String commonUrl = environmentProperties.readProperty();
        settingsPageAuthorizationSteps.openPageByPartialUrl(commonUrl);
    }

    @When("user tries to typed passwords, using following info: $pass")
    public void changePass(final ExamplesTable pass) {

        final ChangePassModel passModel = pass.getRowsAs(ChangePassModel.class).get(0);
        settingsPageAuthorizationSteps. changePass(passModel);
    }

    @Then("following success toast displayed on the page Settings: '$toast'")
    public void verifySuccessToast(final String toast) {
       final String actualToast = settingsPageAuthorizationSteps.getSuccessToast();

       Assertions.assertThat(actualToast) // toast with site
        .as("There is incorrect success toast displayed!")
               .isEqualTo(toast);
    }
}
