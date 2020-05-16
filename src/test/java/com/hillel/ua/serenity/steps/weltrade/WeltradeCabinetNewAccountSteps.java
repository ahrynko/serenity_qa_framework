package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.common.data.UrlBuilder;
import com.hillel.ua.page_object.pages.weltrade.CabinetNewAccountResultPage;
import com.hillel.ua.page_object.pages.weltrade.WeltradeCabinetNewAccountPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class WeltradeCabinetNewAccountSteps extends ScenarioSteps {

    private WeltradeCabinetNewAccountPage weltradeCabinetNewAccountPage;

    public WeltradeCabinetNewAccountSteps(final Pages pages) {
        this.weltradeCabinetNewAccountPage = pages.getPage(WeltradeCabinetNewAccountPage.class);
    }

    @Step
    public void openNewAccountPageByPartialUrl(final String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl, WeltradeCabinetNewAccountPage.class);
        weltradeCabinetNewAccountPage.openUrl(fullNavUrl);
    }

    @Step
    public void choiceTypeAccount() {
        weltradeCabinetNewAccountPage.choiceTypeAccount();
    }

    @Step
    public void choicePlatform() {
        weltradeCabinetNewAccountPage.choicePlatform();
    }

    @Step
    public void choiceCurrency() {
        weltradeCabinetNewAccountPage.choiceCurrency();
    }

    @Step
    public void choiceLeverage() {
        weltradeCabinetNewAccountPage.choiceLeverage();
    }

    @Step
    public Class<CabinetNewAccountResultPage> clickButtonNewAccount() {
        weltradeCabinetNewAccountPage.clickButtonNewAccount();
        return CabinetNewAccountResultPage.class;
    }

    @Step
    public String getTypeAccountText() {
        return weltradeCabinetNewAccountPage.getTypeAccountText();
    }


    @Step
    public String getPlatformText() {
        return weltradeCabinetNewAccountPage.getPlatformText();
    }

    @Step
    public String getLeverageText() {
        return weltradeCabinetNewAccountPage.getLeverageText();
    }

}
