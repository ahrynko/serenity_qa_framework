package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.pages.sportchek.SportchekMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class SignInPopupSteps {

    private SportchekMainPage sportchekMainPage;

    public SignInPopupSteps(final Pages pages) {
        this.sportchekMainPage = pages.getPage(SportchekMainPage.class); //create page object
    }

    @Step
    public void openRegisterNowPopup() {
        sportchekMainPage.getSignInPopupPanel().clickRegisterNowButton(); //открыто окно регистрации
    }
}
