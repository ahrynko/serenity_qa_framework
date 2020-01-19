package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.model.UserRegistrationModel;
import com.hillel.ua.page_object.pages.sportchek.SportchekMainPage;
import com.hillel.ua.page_object.panels.sportchek.SportCheckRegistrationPopupPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportCheckRegisterPopupSteps extends ScenarioSteps {

    private SportchekMainPage sportchekMainPage;

    public SportCheckRegisterPopupSteps(final Pages pages) {
        this.sportchekMainPage = pages.getPage(SportchekMainPage.class);
    }

    @Step
    public void tryRegisterUser(final UserRegistrationModel registrationModel) {

        final SportCheckRegistrationPopupPanel sportCheckRegistrationPopupPanel = sportchekMainPage.getsportCheckRegistrationPopupPanel();

        sportCheckRegistrationPopupPanel.typeEmail(registrationModel.getEmail());
        sportCheckRegistrationPopupPanel.typeConfirmEmail(registrationModel.getConfirmEmail());
        sportCheckRegistrationPopupPanel.typePassword(registrationModel.getPassword());
        sportCheckRegistrationPopupPanel.typeConfirmPassword(registrationModel.getConfirmPassword());

        sportCheckRegistrationPopupPanel.clickRegisterButton();
    }

}
