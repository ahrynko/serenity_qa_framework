package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.pages.sportchek.SportcheckAlpineSkiingPage;
import com.hillel.ua.page_object.pages.sportchek.SportchekMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class FilterBySteps extends ScenarioSteps {

    private SportcheckAlpineSkiingPage sportcheckAlpineSkiingPage;

    public FilterBySteps(final Pages pages) {
        this.sportcheckAlpineSkiingPage = pages.getPage(SportcheckAlpineSkiingPage.class);
    }

    @Step
    public void chooseAtomic() {
        sportcheckAlpineSkiingPage.getFilterByPanel().chooseAtomic();
    }

}
