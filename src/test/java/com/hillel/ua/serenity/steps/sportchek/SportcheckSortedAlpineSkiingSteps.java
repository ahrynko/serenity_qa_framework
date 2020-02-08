package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.common.data.UrlBuilder;
import com.hillel.ua.page_object.pages.sportchek.SportcheckAlpineSkiingPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportcheckSortedAlpineSkiingSteps extends ScenarioSteps {

    private SportcheckAlpineSkiingPage sportcheckAlpineSkiingPage;

    public SportcheckSortedAlpineSkiingSteps(final Pages pages) {
        this.sportcheckAlpineSkiingPage = pages.getPage(SportcheckAlpineSkiingPage.class);
    }

    @Step
    public void openPageByPartialUrl(final String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl, SportcheckAlpineSkiingPage.class);
        sportcheckAlpineSkiingPage.openUrl(fullNavUrl);
    }

    @Step
    public void clicksSortBy() {
        sportcheckAlpineSkiingPage.clicksSortBy();
    }

    @Step
    public void clicksBySelect() {
        sportcheckAlpineSkiingPage.clicksBySelect();
    }
}
