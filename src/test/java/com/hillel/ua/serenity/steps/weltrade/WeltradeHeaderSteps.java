package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.page_object.pages.weltrade.WeltradeMainPage;
import com.hillel.ua.page_object.pages.weltrade.WeltradeSignInPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class WeltradeHeaderSteps {

    private WeltradeMainPage weltradeMainPage;

    public WeltradeHeaderSteps(final Pages pages) {
        this.weltradeMainPage = pages.getPage(WeltradeMainPage.class);
    }

    @Step
    public Class<WeltradeSignInPage> openSignInPage() {
        weltradeMainPage.getHeaderPanel().clickLoginButton();
        return WeltradeSignInPage.class;
    }

}
