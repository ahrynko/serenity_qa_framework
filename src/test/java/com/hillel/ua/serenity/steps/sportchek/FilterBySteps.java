package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.pages.sportchek.SportcheckAlpineSkiingPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class FilterBySteps extends ScenarioSteps {

    private SportcheckAlpineSkiingPage sportcheckAlpineSkiingPage;

    public FilterBySteps(final Pages pages) {
        this.sportcheckAlpineSkiingPage = pages.getPage(SportcheckAlpineSkiingPage.class);
    }

    @Step
    public void chooseAtomic() {
        sportcheckAlpineSkiingPage.getFilterByPanel().chooseAtomic();
    }

    @Step
    public void chooseTecnoPro() {
        sportcheckAlpineSkiingPage.getFilterByPanel().chooseTecnoPro();
    }

    @Step
    public void clickClearAllButton() {
        sportcheckAlpineSkiingPage.getFilterByPanel().clickClearAllButton();
    }
}
