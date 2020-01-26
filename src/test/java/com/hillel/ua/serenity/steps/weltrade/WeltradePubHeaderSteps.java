package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.page_object.pages.weltrade.WeltradePubMainPage;
import com.hillel.ua.page_object.pages.weltrade.WeltradeSignInPage;
import com.hillel.ua.page_object.pages.weltrade.WeltradeSignUpPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class WeltradePubHeaderSteps {

    private WeltradePubMainPage weltradePubMainPage;

    public WeltradePubHeaderSteps(final Pages pages) {
        this.weltradePubMainPage = pages.getPage(WeltradePubMainPage.class);
    }

    @Step
    public Class<WeltradeSignInPage> openSignInPage() {
        weltradePubMainPage.getHeaderPanel().clickLoginButton();
        return WeltradeSignInPage.class;
    }

    @Step
    public Class<WeltradeSignUpPage> openSignUpPage() {
        weltradePubMainPage.getHeaderPanel().clickRegistrationButton();
        return WeltradeSignUpPage.class;
    }
}
