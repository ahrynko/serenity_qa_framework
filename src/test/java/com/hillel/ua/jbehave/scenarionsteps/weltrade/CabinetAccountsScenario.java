package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.common.data.EnvironmentProperties;
import com.hillel.ua.serenity.steps.weltrade.CabinetAccountsSteps;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class CabinetAccountsScenario {

    @Steps
    private CabinetAccountsSteps cabinetAccountsSteps;

    @When("user opened 'Accounts Page' by url: '$url'")
    public void openSummaryPage(final EnvironmentProperties environmentProperties) {
        final String commonUrl = environmentProperties.readProperty();
        cabinetAccountsSteps.openPageByPartialUrl(commonUrl);
    }

    @When("user deleted new Premium trade account")
    public void deletePremiumAccount() {
        cabinetAccountsSteps.clickSettingsOperations();
        cabinetAccountsSteps.clickCloseAccount();
        cabinetAccountsSteps.clickCloseAccountButton();
    }

    @When("user tries to reset filter the trade accounts")
    public void resetFilter() {
        cabinetAccountsSteps.clickResetFilterButton();
    }

    @Then("following message to accounts information displayed: '$message'")
    public void verifyAccountInformationMessage(final String accountInfoMessage) {

        final String actualAccountInformationMessage = cabinetAccountsSteps.getAccountInformationMessage();

        Assertions.assertThat(actualAccountInformationMessage) // title with site
                .as("There is incorrect Account Information displayed!")
                .isEqualTo(accountInfoMessage);  // we expect see
    }
}
