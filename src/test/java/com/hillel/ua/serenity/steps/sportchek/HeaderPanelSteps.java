package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.pages.sportchek.SportchekMainPage;
import com.hillel.ua.page_object.panels.sportchek.SearchInputPanel;
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

    @Step
    public void movedToMouse() {
        sportchekMainPage.getHeaderPanel().movedMouseToShoppingCart();
    }

    @Step
    public String retrieveCartMessage() {
       return sportchekMainPage.getHeaderPanel().retrieveHeaderCartMessage();
    }

    @Step
    public void inputSearchFor(final String text) {
        sportchekMainPage.getHeaderPanel().inputSearchText(text);
    }

    @Step
    public void openSignInPopup() {
        sportchekMainPage.getHeaderPanel().clickSignInButton();
    }
}
