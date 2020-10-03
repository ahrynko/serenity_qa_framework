package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.common.data.UrlBuilder;
import com.hillel.ua.page_object.pages.weltrade.CabinetSettingsPage;
import com.hillel.ua.page_object.pages.weltrade.WeltradeCabinetNewAccountPage;
import com.hillel.ua.page_object.pages.weltrade.WeltradeCabinetSummaryPage;
import com.hillel.ua.page_object.panels.weltrade.ModalTabsAccountPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class WeltradeCabinetSummarySteps extends ScenarioSteps {

    private WeltradeCabinetSummaryPage weltradeCabinetSummaryPage;

    public WeltradeCabinetSummarySteps(final Pages pages) {
        this.weltradeCabinetSummaryPage = pages.getPage(WeltradeCabinetSummaryPage.class);
    }

    @Step
    public String getCurrentWeltradeTitle() {
        return weltradeCabinetSummaryPage.getCurrentTitle();
    }

    @Step
    public void navigateToTrader() {
        weltradeCabinetSummaryPage.getCabHeaderPanel().movedMouseToTrader();
    }

    @Step
    public void closeT2WBanner() {
        weltradeCabinetSummaryPage.closeT2WBanner();
    }

    @Step
    public Class<WeltradeCabinetNewAccountPage> clickNewAccount() {
        weltradeCabinetSummaryPage.getCabHeaderPanel().getSubMenuTraderPanel().openNewAccountPage();
        return WeltradeCabinetNewAccountPage.class;
    }

    @Step
    public Class<ModalTabsAccountPanel> clickSettingsOperations() {
        weltradeCabinetSummaryPage.getSummaryAccountsPanel().clickSettingsOperations();
        return ModalTabsAccountPanel.class;
    }

    @Step
    public void choiceLeverage() {
        weltradeCabinetSummaryPage.getSummaryAccountsPanel().getModalTabsAccountPanel().choiceLeverage();
    }

    @Step
    public void clickChangeButton() {
        weltradeCabinetSummaryPage.getSummaryAccountsPanel().getModalTabsAccountPanel().clickChangeButton();
    }

    @Step
    public String getLeverageText() {
        return weltradeCabinetSummaryPage.getSummaryAccountsPanel().getModalTabsAccountPanel().getLeverageText();
    }

    @Step
    public String getLeverageAccountText() {
        return weltradeCabinetSummaryPage.getSummaryAccountsPanel().getLeverageAccountText();
    }

    @Step
    public void openPageByPartialUrl(String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl, WeltradeCabinetSummaryPage.class);
        weltradeCabinetSummaryPage.openUrl(fullNavUrl);
    }

    @Step
    public void navigateToMyProfile() {
        weltradeCabinetSummaryPage.getCabHeaderPanel().movedMouseToMyProfile();
    }

    @Step
    public Class<CabinetSettingsPage> clickSettings() {
        weltradeCabinetSummaryPage.getCabHeaderPanel().getMyProfilePanel().openSettingsPage();
        return CabinetSettingsPage.class;
    }

    @Step
    public boolean isLogoVisible() {
        return weltradeCabinetSummaryPage.isLogoVisible();
    }

    @Step
    public void clickLogOut() {
        weltradeCabinetSummaryPage.getCabHeaderPanel().getMyProfilePanel().clickLogOut();
    }
}
