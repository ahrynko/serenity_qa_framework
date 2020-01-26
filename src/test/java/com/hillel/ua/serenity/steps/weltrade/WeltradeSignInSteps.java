package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.page_object.model.weltrade.UserAutorizationModel;
import com.hillel.ua.page_object.pages.weltrade.WeltradePubMainPage;
import com.hillel.ua.page_object.pages.weltrade.WeltradeSignInPage;
import com.hillel.ua.page_object.panels.weltrade.WeltradeAuthorizationPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class WeltradeSignInSteps {

    private WeltradePubMainPage weltradePubMainPage;
    private WeltradeSignInPage weltradeSignInPage;

    public WeltradeSignInSteps(final Pages pages) {
        this.weltradePubMainPage = pages.getPage(WeltradePubMainPage.class);
    }

    @Step
    public void tryRegisterUser(final UserAutorizationModel autorizationModel) {
        final WeltradeAuthorizationPanel weltradeAuthorizationPanel = weltradeSignInPage.getAuthorizPanel();

        weltradeAuthorizationPanel.searchLoginText(autorizationModel.getEmail());
        weltradeAuthorizationPanel.searchPasswordText(autorizationModel.getPassword());
        weltradeAuthorizationPanel.clickSignInButton();

//        return WeltradeCabinetPage.class;
    }
}
