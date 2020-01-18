package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.model.RegisterErrorsModel;
import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SportCheckRegistrationPopupPanel extends AbstractPanel {

    private static final String EMAIL_INPUT = ".//input[@name='login']";
    private static final String CONFIRM_EMAIL_INPUT = ".//input[@name='loginConfirmation']";
    private static final String PASSWORD_INPUT = ".//input[@name='password']";
    private static final String CONFIRM_PASSWORD_INPUT = ".//input[@name='confirmPassword']";

    private static final String EMAIL_ERROR = ".//span[@for='login']";
    private static final String CONFIRM_EMAIL_ERROR = ".//span[@for='loginConfirmation']";
    private static final String PASSWORD_ERROR = ".//span[@for='password']";
    private static final String CONFIRM_PASSWORD_ERROR = ".//span[@for='confirmPassword']";

    public SportCheckRegistrationPopupPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void typeEmail(final String typeEmail) {
        findBy(EMAIL_INPUT).type(typeEmail);
    }
    public void typeConfirmEmail(final String typeConfirmEmail) {
        findBy(CONFIRM_EMAIL_INPUT).type(typeConfirmEmail);
    }
    public void typePassword(final String typePassword) {
        findBy(PASSWORD_INPUT).type(typePassword);
    }
    public void typeConfirmPassword(final String typeConfirmPassword) {
        findBy(CONFIRM_PASSWORD_INPUT).type(typeConfirmPassword);
    }

    public RegisterErrorsModel getRegisterErrors() {
        final String emailErrorText = findBy(EMAIL_ERROR).getText();
        final String confirmEmailErrorText = findBy(CONFIRM_EMAIL_ERROR).getText();
        final String passwordErrorText = findBy(PASSWORD_ERROR).getText();
        final String confirmPasswordErrorText = findBy(CONFIRM_PASSWORD_ERROR).getText();

//        return new RegisterErrorsModel(emailErrorText, confirmEmailErrorText, passwordErrorText, confirmPasswordErrorText);
        final RegisterErrorsModel errorsModel = new RegisterErrorsModel(
                emailErrorText, confirmEmailErrorText,
                passwordErrorText, confirmPasswordErrorText
        );

        return errorsModel;
    }
}
