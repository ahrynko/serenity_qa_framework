package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.common.data.EnvironmentProperties;
import com.hillel.ua.serenity.steps.weltrade.WeltradeCabinetNewAccountSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class WeltradeCabinetNewAccountScenario {

    @Steps
    private WeltradeCabinetNewAccountSteps weltradeCabinetNewAccountSteps;

    @When("user opened 'New Account Page' by url: '$url'")
    public void openNewAccountPage(final EnvironmentProperties environmentProperties) {
        final String commonUrl = environmentProperties.readProperty();
        weltradeCabinetNewAccountSteps.openNewAccountPageByPartialUrl(commonUrl);
    }

    @When("user opened new Premium trade account")
    public void openPremiumAccount() {
        weltradeCabinetNewAccountSteps.choiceTypeAccount();
        weltradeCabinetNewAccountSteps.choicePlatform();
        weltradeCabinetNewAccountSteps.choiceCurrency();
        weltradeCabinetNewAccountSteps.choiceLeverage();

        final String expectedTypeAccountText = weltradeCabinetNewAccountSteps.getTypeAccountText();
        final String expectedPlatformText =  weltradeCabinetNewAccountSteps.getPlatformText();
        final String expectedLeverageText =  weltradeCabinetNewAccountSteps.getLeverageText();

        Serenity.setSessionVariable("expected_type_account").to(expectedTypeAccountText);
        Serenity.setSessionVariable("expected_platform").to(expectedPlatformText);
        Serenity.setSessionVariable("expected_leverage").to(expectedLeverageText);

        weltradeCabinetNewAccountSteps.clickButtonNewAccount();
    }

}
