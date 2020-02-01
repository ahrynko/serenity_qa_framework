package com.hillel.ua.serenity.steps.sportchek;

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

    @Step
    public void chooseAtomic() {
        sportcheckAlpineSkiingPage.chooseAtomic();
    }

}
