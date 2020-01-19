package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.page_object.pages.weltrade.WeltradeMainPage;
import com.hillel.ua.page_object.pages.weltrade.WeltradeSignInPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class WeltradeMainPageSteps extends ScenarioSteps {

    private WeltradeMainPage weltradeMainPage;

    public WeltradeMainPageSteps(final Pages pages) {
        this.weltradeMainPage = pages.getPage(WeltradeMainPage.class);
    }

    @Step
    public void openPageByUrl(final String url) {
        weltradeMainPage.openUrl(url);
    }

}
