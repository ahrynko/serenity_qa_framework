package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.page_object.pages.weltrade.WeltradePubMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class WeltradePubMainPageSteps extends ScenarioSteps {

    private WeltradePubMainPage weltradePubMainPage;

    public WeltradePubMainPageSteps(final Pages pages) {
        this.weltradePubMainPage = pages.getPage(WeltradePubMainPage.class);
    }

    @Step
    public void openPageByUrl(final String url) {
        weltradePubMainPage.openUrl(url);
    }

    @Step
    public String getCurrentUrl() {
        return weltradePubMainPage.getCurrentUrl();
    }

}
