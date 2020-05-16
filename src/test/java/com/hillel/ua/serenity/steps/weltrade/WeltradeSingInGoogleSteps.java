package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.page_object.pages.weltrade.WeltradeSingInGooglePage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class WeltradeSingInGoogleSteps extends ScenarioSteps {

    private WeltradeSingInGooglePage weltradeSingInGooglePage;

    public WeltradeSingInGoogleSteps(final Pages pages) {
        this.weltradeSingInGooglePage = pages.getPage(WeltradeSingInGooglePage.class);
    }

    @Step
    public void loginViaGoogle(final String text) {
        weltradeSingInGooglePage.inputEmailText(text);
    }

    @Step
    public void clickNextButton() {
        weltradeSingInGooglePage.clickNextButton();
    }

    @Step
    public void loginViaGooglePass(final String pass) {
        weltradeSingInGooglePage.inputPasswordText(pass);
    }

    @Step
    public void clickPassNextButton() {
        weltradeSingInGooglePage.clickPassNextButton();
    }
}
