package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.common.data.UrlBuilder;
import com.hillel.ua.page_object.model.weltrade.ChangePassModel;
import com.hillel.ua.page_object.pages.weltrade.CabinetSettingsPageAuthorization;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class CabinetSettingsPageAuthorizationSteps extends ScenarioSteps {

    private CabinetSettingsPageAuthorization cabinetSettingsPageAuthorization;

    public CabinetSettingsPageAuthorizationSteps(final Pages pages) {
        this.cabinetSettingsPageAuthorization = pages.getPage(CabinetSettingsPageAuthorization.class);
    }

    @Step
    public void openPageByPartialUrl(String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl, CabinetSettingsPageAuthorization.class);
        cabinetSettingsPageAuthorization.openUrl(fullNavUrl);
    }

    @Step
    public void changePass(final ChangePassModel passModel) {
        cabinetSettingsPageAuthorization.getSettingsAuthorizationPanel().searchValidPasswordText(passModel.getValidPassword());
        cabinetSettingsPageAuthorization.getSettingsAuthorizationPanel().searchNewPasswordText(passModel.getNewPassword());
        cabinetSettingsPageAuthorization.getSettingsAuthorizationPanel().searchRepeatNewPasswordText(passModel.getRepeatNewPassword());
        cabinetSettingsPageAuthorization.getSettingsAuthorizationPanel().clickContinueButton();
    }

    @Step
    public String getSuccessToast() {
        return cabinetSettingsPageAuthorization.getSettingsAuthorizationPanel().getSuccessToast();
    }

    @Step
    public String getErrorToast() {
        return cabinetSettingsPageAuthorization.getSettingsAuthorizationPanel().getErrorToast();
    }
}
