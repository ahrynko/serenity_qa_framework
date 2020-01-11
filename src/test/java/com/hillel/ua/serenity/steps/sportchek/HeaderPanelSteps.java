package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.pages.sportchek.SportchekMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class HeaderPanelSteps extends ScenarioSteps {

    private SportchekMainPage sportchekMainPage; //create page object

    public HeaderPanelSteps(final Pages pages) {
        this.sportchekMainPage = pages.getPage(SportchekMainPage.class); //pages - initialized page object
    }

    @Step
    public void openBurgerMenu() {
        sportchekMainPage.getHeaderPanel().clickBurgerMenuButton();
    }
}
