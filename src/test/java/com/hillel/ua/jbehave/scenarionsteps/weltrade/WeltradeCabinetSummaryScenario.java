package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.common.data.EnvironmentProperties;
import com.hillel.ua.logging.Logger;
import com.hillel.ua.serenity.steps.weltrade.WeltradeCabinetSummarySteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.unitils.reflectionassert.ReflectionAssert;

public class WeltradeCabinetSummaryScenario {

    @Steps
    private WeltradeCabinetSummarySteps weltradeCabinetSummarySteps;

    @When("user closed the T2W banner")
    public void closeT2WBanner() {
        weltradeCabinetSummarySteps.closeT2WBanner();
    }

    @When("user opened 'New Account Page'")
    public void openNewAccountPage() {
        weltradeCabinetSummarySteps.navigateToTrader();
        weltradeCabinetSummarySteps.clickNewAccount();
    }

    @When("user changed the random leverage of the first trading account")
    public void chooseRandomLeverage() {
        weltradeCabinetSummarySteps.clickSettingsOperations();
        weltradeCabinetSummarySteps.choiceLeverage();
        weltradeCabinetSummarySteps.clickChangeButton();

        final String actualLeverageText = weltradeCabinetSummarySteps.getLeverageText();
        Serenity.setSessionVariable("actual_leverage").to(actualLeverageText);
    }

    @When("user opened 'Summary Page' by url: '$url'")
    public void openSummaryPage(final EnvironmentProperties environmentProperties) {
        final String commonUrl = environmentProperties.readProperty();
        weltradeCabinetSummarySteps.openPageByPartialUrl(commonUrl);
    }

    @When("user opened 'Settings Page'")
    public void openSettingsPage() {
        weltradeCabinetSummarySteps.navigateToMyProfile();
        weltradeCabinetSummarySteps.clickSettings();
    }

    @Then("user retrieved Weltrade site title")
    public void retrieveWeltradeSiteTitle() {
        final String actualTitle = weltradeCabinetSummarySteps.getCurrentWeltradeTitle();
        Serenity.setSessionVariable("actual_title").to(actualTitle);
    }

    @Then("retrieved Weltrade site title value should be: '$expectedTitle'")
    public void verifyWeltradeSiteTitle (final String expectedTitle) {

       final String savedWeltradeTitle = Serenity.sessionVariableCalled("actual_title");

       ReflectionAssert.assertReflectionEquals("There is incorrect title displayed!",
               expectedTitle, savedWeltradeTitle);
    }

    @Then("new leverage trading accounts changed")
    public void getNewLeverageCorrectly() {

        final String actualLeverageText = Serenity.sessionVariableCalled("actual_leverage");
        final String expectedLeverageText = weltradeCabinetSummarySteps.getLeverageAccountText();

        final SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(actualLeverageText)
                .as("There is incorrect leverage!")
                .isEqualTo(expectedLeverageText);

        softAssertions.assertAll();

        Logger.out.info("Random leverage of a trading account " + actualLeverageText);
        Logger.out.info("Leverage of the trading account in the Accounts block " + expectedLeverageText);
    }
}
