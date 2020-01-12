package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.pages.sportchek.SportchekMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.reports.adaptors.specflow.ScenarioStep;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class SearchInputPanelSteps extends ScenarioSteps {

    private SportchekMainPage sportchekMainPage; //create page object

    public SearchInputPanelSteps(final Pages pages) {
        this.sportchekMainPage = pages.getPage(SportchekMainPage.class); //pages - initialized page object}
    }

    @Step
    public List<String>getSearchItems() {
        return sportchekMainPage.getHeaderPanel()
                .getSearchInputPanel()
                .getSearchItems();
    }
}
