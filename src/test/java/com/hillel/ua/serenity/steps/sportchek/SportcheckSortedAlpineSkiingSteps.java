package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.pages.sportchek.SportcheckAlpineSkiingPage;
import com.hillel.ua.page_object.pages.sportchek.SportchekMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportcheckSortedAlpineSkiingSteps extends ScenarioSteps {

    private SportchekMainPage sportchekMainPage;
    private SportcheckAlpineSkiingPage sportcheckAlpineSkiingPage;

    public SportcheckSortedAlpineSkiingSteps(final Pages pages) {
        this.sportchekMainPage = pages.getPage(SportchekMainPage.class);
    }

    @Step
    public void orderBySelect(String text) {
        sportcheckAlpineSkiingPage.orderBy(text);
    }

    @Step
    public void getProducts() {
        sportcheckAlpineSkiingPage.getProducts();
    }

    @Step
    public void openPageByUrl(final String url) {
        sportcheckAlpineSkiingPage.openUrl(url);
    }
}
