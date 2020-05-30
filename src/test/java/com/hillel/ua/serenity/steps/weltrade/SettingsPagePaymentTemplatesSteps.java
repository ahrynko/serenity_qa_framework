package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.common.data.UrlBuilder;
import com.hillel.ua.page_object.pages.weltrade.SettingsPagePaymentTemplatesPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class SettingsPagePaymentTemplatesSteps extends ScenarioSteps {

    private SettingsPagePaymentTemplatesPage paymentTemplatesPage;

    public SettingsPagePaymentTemplatesSteps(final Pages pages) {
        this.paymentTemplatesPage = pages.getPage(SettingsPagePaymentTemplatesPage.class);
    }

    @Step
    public void openPageByPartialUrl(String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl,SettingsPagePaymentTemplatesPage.class);
        paymentTemplatesPage.openUrl(fullNavUrl);
    }

    @Step
    public void choosePaymentSystem() {
        paymentTemplatesPage.getSettingsPaymentTemplatesPanel().choosePaymentSystem();
    }

    @Step
    public void chooseQiwi() {
        paymentTemplatesPage.getSettingsPaymentTemplatesPanel().chooseQiwi();
    }

    @Step
    public void chooseCurrency() {
        paymentTemplatesPage.getSettingsPaymentTemplatesPanel().chooseCurrency();
    }

    @Step
    public void chooseEurCurrency() {
        paymentTemplatesPage.getSettingsPaymentTemplatesPanel().chooseEurCurrency();
    }

    @Step
    public void typePurseNumber(final String purse) {
        paymentTemplatesPage.getSettingsPaymentTemplatesPanel().typePurseNumber(purse);
    }

    @Step
    public void clickAddButton() {
        paymentTemplatesPage.getSettingsPaymentTemplatesPanel().clickAddButton();
    }

    @Step
    public String getSuccessToast() {
        return paymentTemplatesPage.getSettingsPaymentTemplatesPanel().getSuccessToast();
    }

    @Step
    public List<String> getListTemplatesTitleText() {
        return paymentTemplatesPage.getSettingsPaymentTemplatesPanel().getListTemplatesTitleText();
    }

    @Step
    public List<String> getListPurseTitleText() {
        return paymentTemplatesPage.getSettingsPaymentTemplatesPanel().getListPurseTitleText();
    }

    @Step
    public List<String> getListCurrencyTitleText() {
        return paymentTemplatesPage.getSettingsPaymentTemplatesPanel().getListCurrencyTitleText();
    }

    @Step
    public void deletePaymentTemplate() {
        paymentTemplatesPage.getSettingsPaymentTemplatesPanel().deletePaymentTemplate();
    }

    @Step
    public boolean isTemplatesTitlePresent() {
        return paymentTemplatesPage.getSettingsPaymentTemplatesPanel().isTemplatesTitlePresent();
    }
}
