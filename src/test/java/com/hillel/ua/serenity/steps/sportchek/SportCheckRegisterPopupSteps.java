package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.model.UserRegistrationModel;
import com.hillel.ua.page_object.pages.sportchek.SportchekMainPage;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportCheckRegisterPopupSteps extends ScenarioSteps {

    private SportchekMainPage sportchekMainPage;

    public SportCheckRegisterPopupSteps(final Pages pages) {
        this.sportchekMainPage = pages.getPage(SportchekMainPage.class);
    }

    public void tryRegisterUser(final UserRegistrationModel registrationModel) {

    }

}
