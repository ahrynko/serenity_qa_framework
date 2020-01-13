package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.pages.sportchek.SportchekMainPage;
import com.hillel.ua.page_object.panels.sportchek.SignInPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SignInPanelSteps extends ScenarioSteps {

    private SportchekMainPage sportchekMainPage;

    public SignInPanelSteps(final Pages pages) {
        this.sportchekMainPage = pages.getPage(SportchekMainPage.class); //pages - initialized page object
    }

    @Step
    public void openSignInForm() {
        sportchekMainPage.getHeaderPanel().clickSignInButton();
    }

    @Step
    public SignInPanel getSignInPanelForm () {
        return sportchekMainPage.getHeaderPanel().getSignInPanel();
    }

}
