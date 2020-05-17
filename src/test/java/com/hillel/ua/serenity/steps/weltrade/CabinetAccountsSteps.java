package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.common.data.UrlBuilder;
import com.hillel.ua.page_object.pages.weltrade.CabinetAccountsPage;
import com.hillel.ua.page_object.panels.weltrade.ModalTabsAccountPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class CabinetAccountsSteps extends ScenarioSteps {

    private CabinetAccountsPage cabinetAccountsPage;

    public CabinetAccountsSteps(final Pages pages) {
        this.cabinetAccountsPage = pages.getPage(CabinetAccountsPage.class);
    }

    @Step
    public void openPageByPartialUrl(String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl, CabinetAccountsPage.class);
        cabinetAccountsPage.openUrl(fullNavUrl);
    }

    @Step
    public Class<ModalTabsAccountPanel> clickSettingsOperations() {
        cabinetAccountsPage.getAccountsInformationPanel().clickSettingsOperations();
        return ModalTabsAccountPanel.class;
    }

    @Step
    public void clickCloseAccount() {
        cabinetAccountsPage.getAccountsInformationPanel().getModalTabsAccountPanel().clickCloseAccount();
    }

    @Step
    public void clickCloseAccountButton() {
        cabinetAccountsPage.getAccountsInformationPanel().getModalTabsAccountPanel().clickCloseAccountButton();
    }

    @Step
    public void clickResetFilterButton() {
        cabinetAccountsPage.getAccountsInformationPanel().clickResetFilterButton();
    }

    @Step
    public String getAccountInformationMessage() {
        return cabinetAccountsPage.getAccountsInformationPanel().getAccountInformationMessage();
    }
}
