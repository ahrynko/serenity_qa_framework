package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.pages.sportchek.SportcheckAlpineSkiingPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class ProductListSteps extends ScenarioSteps {

    private SportcheckAlpineSkiingPage sportcheckAlpineSkiingPage;

    public ProductListSteps(final Pages pages) {
        this.sportcheckAlpineSkiingPage = pages.getPage(SportcheckAlpineSkiingPage.class);
    }

    @Step
    public List<String> getAlpineSkiingListAtomicText() {
        return sportcheckAlpineSkiingPage.getProductListPanel().getListAtomicText();
    }
}
