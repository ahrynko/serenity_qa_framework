package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.page_object.pages.weltrade.WeltradeMainPage;
import net.thucydides.core.pages.Pages;

public class WeltradeSignInSteps {

    private WeltradeMainPage weltradeMainPage;

    public WeltradeSignInSteps(final Pages pages) {
        this.weltradeMainPage = pages.getPage(WeltradeMainPage.class);
    }

}
