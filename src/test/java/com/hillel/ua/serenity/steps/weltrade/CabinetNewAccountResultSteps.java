package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.page_object.pages.weltrade.CabinetNewAccountResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class CabinetNewAccountResultSteps extends ScenarioSteps {

    private CabinetNewAccountResultPage cabinetNewAccountResultPage;

    public CabinetNewAccountResultSteps(final Pages pages) {
        this.cabinetNewAccountResultPage = pages.getPage(CabinetNewAccountResultPage.class);
    }

    @Step
    public String getTypeAccount() {
        return cabinetNewAccountResultPage.getTypeAccountText();
    }

    @Step
    public String getPlatform() {
        return cabinetNewAccountResultPage.getPlatformText();
    }

    @Step
    public String getLeverage() {
        return cabinetNewAccountResultPage.getLeverageText();
    }

    @Step
    public String getAccountNumber() {
        return cabinetNewAccountResultPage.getAccountNumber();
    }

    @Step
    public String getTradingPassword() {
        return cabinetNewAccountResultPage.getTradingPassword();
    }
}
