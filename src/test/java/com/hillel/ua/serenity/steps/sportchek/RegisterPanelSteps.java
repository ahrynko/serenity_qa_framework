package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.pages.sportchek.SportchekMainPage;
import com.hillel.ua.page_object.panels.sportchek.RegisterPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class RegisterPanelSteps extends ScenarioSteps {

    private SportchekMainPage sportchekMainPage;

    public RegisterPanelSteps(final Pages pages) {
        this.sportchekMainPage = pages.getPage(SportchekMainPage.class); //pages - initialized page object
    }

    @Step
    public void openRegisterForm() {
        sportchekMainPage.getHeaderPanel().getSignInPanel().clickRegisterButton();
    }

    @Step
    public RegisterPanel getRegisterForm() {
       return sportchekMainPage.getHeaderPanel().getSignInPanel().getRegisterPanel();
    }

    @Step
    public void searchLoginErrorMessage(final String item) {
        sportchekMainPage.getHeaderPanel().getSignInPanel().getRegisterPanel().searchLoginText(item);
    }

    @Step
    public void searchConfirmLoginMessage(final String item) {
        sportchekMainPage.getHeaderPanel().getSignInPanel().getRegisterPanel().searchConfirmLoginText(item);
    }

    @Step
    public void searchPasswordErrorMessage(final String item) {
        sportchekMainPage.getHeaderPanel().getSignInPanel().getRegisterPanel().searchPasswordText(item);
    }

    @Step
    public void searchConfirmPasswordMessage(final String item) {
        sportchekMainPage.getHeaderPanel().getSignInPanel().getRegisterPanel().searchConfirmPasswordText(item);
    }

    @Step
    public String errorMessageEmail() {
        return sportchekMainPage.getHeaderPanel().getSignInPanel().getRegisterPanel().retrieveErrorMessageEmail();
    }

    @Step
    public String errorMessageConfirmEmail() {
        return sportchekMainPage.getHeaderPanel().getSignInPanel().getRegisterPanel().retrieveErrorMessageConfirmEmail();
    }

    @Step
    public String errorMessagePassword() {
        return sportchekMainPage.getHeaderPanel().getSignInPanel().getRegisterPanel().retrieveErrorMessagePassword();
    }

    @Step
    public String errorMessageConfirmPassword() {
        return sportchekMainPage.getHeaderPanel().getSignInPanel().getRegisterPanel().retrieveErrorMessageConfirmPassword();
    }

}
