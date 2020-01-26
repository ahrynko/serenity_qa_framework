package com.hillel.ua.page_object.panels.weltrade;

import com.hillel.ua.page_object.model.weltrade.UserRegistartionErrorsModel;
import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class WeltradeRegistrationPanel extends AbstractPanel {

    private static final String FIRST_NAME_INPUT = ".//input[@formcontrolname='NAME']";
    private static final String LAST_NAME_INPUT = ".//input[@formcontrolname='LAST_NAME']";
    private static final String EMAIL_INPUT = ".//input[@formcontrolname='EMAIL']";
    private static final String PHONE_NUMBER_INPUT  = ".//input[@class='ng-untouched ng-pristine ng-valid']";
    private static final String CHECKBOX_INPUT = ".//mat-checkbox[@id='mat-checkbox-1']";

    private static final String FIRST_NAME_ERROR = ".(//div[@class='error-txt'])[1]";
    private static final String LAST_NAME_ERROR = ".(//div[@class='error-txt'])[2]";
    private static final String EMAIL_ERROR = ".(//div[@class='error-txt'])[3]";
    private static final String PHONE_NUMBER_ERROR = ".(//div[@class='error-txt'])[4]";

    public WeltradeRegistrationPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void typeFirstName(final String typeFirstName ) {
        findBy(FIRST_NAME_INPUT).type(typeFirstName);
    }

    public void typeLastName(final String typeLastName) {
        findBy(LAST_NAME_INPUT).type(typeLastName);
    }

    public void typeEmail(final String typeEmail) {
        findBy(EMAIL_INPUT).type(typeEmail);
    }

    public void typePhoneNumber(final String typePhoneNumber) {
        findBy(PHONE_NUMBER_INPUT).type(typePhoneNumber);
    }

    public void checkedCheckbox() {
        findBy(CHECKBOX_INPUT).waitUntilClickable().click();
    }

    public UserRegistartionErrorsModel getRegisterErrors() {
        final String fistNameErrorText = findBy(FIRST_NAME_ERROR).getText();
        final String lastNameErrorText = findBy(LAST_NAME_ERROR).getText();
        final String emailErrorText = findBy(EMAIL_ERROR).getText();
        final String phoneNumberErrorText = findBy(PHONE_NUMBER_ERROR).getText();

        return new UserRegistartionErrorsModel(fistNameErrorText, lastNameErrorText, emailErrorText, phoneNumberErrorText);
    }

}
