package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.page_object.model.weltrade.WeltradeUserAutorizationModel;
import com.hillel.ua.page_object.pages.weltrade.WeltradeMainPage;
import com.hillel.ua.page_object.pages.weltrade.WeltradeSignInPage;
import com.hillel.ua.page_object.panels.weltrade.WeltradeAuthorizationPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class WeltradeSignInSteps {

    private WeltradeMainPage weltradeMainPage;
    private WeltradeSignInPage weltradeSignInPage;

    public WeltradeSignInSteps(final Pages pages) {
        this.weltradeMainPage = pages.getPage(WeltradeMainPage.class);
    }

    @Step
    public void tryRegisterUser(final WeltradeUserAutorizationModel autorizationModel) {
        final WeltradeAuthorizationPanel weltradeAuthorizationPanel = weltradeSignInPage.getAuthorizPanel();

        weltradeAuthorizationPanel.searchLoginText(autorizationModel.getEmail());
        weltradeAuthorizationPanel.searchPasswordText(autorizationModel.getPassword());
        weltradeAuthorizationPanel.clickSignInButton();

//        return WeltradeCabinetPage.class;
    }
}
