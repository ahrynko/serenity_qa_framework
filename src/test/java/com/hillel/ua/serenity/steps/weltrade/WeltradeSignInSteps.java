package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.common.data.UrlBuilder;
import com.hillel.ua.page_object.model.weltrade.UserAutorizationModel;
import com.hillel.ua.page_object.pages.weltrade.WeltradeCabinetSummaryPage;
import com.hillel.ua.page_object.pages.weltrade.WeltradeSignInPage;
import com.hillel.ua.page_object.pages.weltrade.WeltradeSingInGooglePage;
import com.hillel.ua.page_object.panels.weltrade.WeltradeAuthorizationPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class WeltradeSignInSteps extends ScenarioSteps {

    private WeltradeSignInPage weltradeSignInPage;

    public WeltradeSignInSteps(final Pages pages) {
        this.weltradeSignInPage = pages.getPage(WeltradeSignInPage.class);
    }

    @Step
    public Class<WeltradeCabinetSummaryPage> tryRegisterUser(final UserAutorizationModel autorizationModel) {
        final WeltradeAuthorizationPanel weltradeAuthorizationPanel = weltradeSignInPage.getAuthorizPanel();

        weltradeAuthorizationPanel.searchLoginText(autorizationModel.getEmail());
        weltradeAuthorizationPanel.searchPasswordText(autorizationModel.getPassword());
        weltradeAuthorizationPanel.clickSignInButton();

       return WeltradeCabinetSummaryPage.class;
    }

    @Step
    public void openPageByPartialUrl(final String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl, WeltradeSignInPage.class);
        weltradeSignInPage.openUrl(fullNavUrl);
    }

    @Step
    public Class<WeltradeSingInGooglePage> openGoogleForm() {
        weltradeSignInPage.getLoginSocialMediaPanel().clickLoginGoogleButton();
        return WeltradeSingInGooglePage.class;
    }

}
