package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.logging.Logger;
import com.hillel.ua.serenity.steps.weltrade.CabinetNewAccountResultSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.jbehave.core.annotations.Then;

public class CabinetNewAccountResultScenario {

    @Steps
    private CabinetNewAccountResultSteps cabinetNewAccountResultSteps;

    @Then("new Premium trade account opened with correct params")
    public void verifyAccountParams() {
        final String actualTypeAccountText = cabinetNewAccountResultSteps.getTypeAccount();
        final String actualPlatformText = cabinetNewAccountResultSteps.getPlatform();
        final String actualLeverageText = cabinetNewAccountResultSteps.getLeverage();

        final String expectedTypeAccountText = Serenity.sessionVariableCalled("expected_type_account");  //Premium
        final String expectedPlatformText = Serenity.sessionVariableCalled("expected_platform");
        final String expectedLeverageText = Serenity.sessionVariableCalled("expected_leverage");

        String accountNumber = cabinetNewAccountResultSteps.getAccountNumber();
        String tradingPassword = cabinetNewAccountResultSteps.getTradingPassword();

        final SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualTypeAccountText)
                .as("There is incorrect type account!")
                .isEqualTo(expectedTypeAccountText);

        softAssertions.assertThat(actualPlatformText)
                .as("There is incorrect platform!")
                .isEqualTo(expectedPlatformText);

        softAssertions.assertThat(actualLeverageText)
                .as("There is incorrect leverage!")
                .isEqualTo(expectedLeverageText);

        softAssertions.assertAll();

        Logger.out.info(actualTypeAccountText);
        Logger.out.info(actualPlatformText);
        Logger.out.info(actualLeverageText);
        Logger.out.info(expectedTypeAccountText);
        Logger.out.info(expectedPlatformText);
        Logger.out.info(expectedLeverageText);

        Logger.out.info(accountNumber);
        Logger.out.info(tradingPassword);
    }
}
