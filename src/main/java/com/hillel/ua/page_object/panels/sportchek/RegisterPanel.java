package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class RegisterPanel extends AbstractPanel {

    private static final String  SEARCH_EMAIL_INPUT = ".//input[@placeholder='Email (e.g. name@example.com)']";
    private static final String  SEARCH_CONFIRM_EMAIL_INPUT = ".//input[@placeholder='Confirm Email']";
    private static final String  SEARCH_PASSWORD_INPUT = ".//input[@placeholder='Password (8 characters minimum)']";
    private static final String  SEARCH_CONFIRM_PASSWORD_INPUT = ".//input[@placeholder='Confirm Password']";

    private static final String  ERROR_MESSAGE_EMAIL = ".//div[@class='register modal-content-wrapper first']//span[1]";
    private static final String  ERROR_MESSAGE_CONFIRM_EMAIL = ".//div[@class='register modal-content-wrapper first']//span[2]";
    private static final String  ERROR_MESSAGE_PASSWORD = ".//div[@class='register modal-content-wrapper first']//span[3]";
    private static final String  ERROR_MESSAGE_CONFIRM_PASSWORD = ".//div[@class='register modal-content-wrapper first']//span[4]";

    public RegisterPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void searchLoginText(final String text) {
        findBy(SEARCH_EMAIL_INPUT).waitUntilVisible().type(text);
    }

    public void searchConfirmLoginText(final String text) {
        findBy(SEARCH_CONFIRM_EMAIL_INPUT).waitUntilVisible().type(text);
    }

    public void searchPasswordText(final String text) {
        findBy(SEARCH_PASSWORD_INPUT).waitUntilVisible().type(text);
    }

    public void searchConfirmPasswordText(final String text) {
        findBy(SEARCH_CONFIRM_PASSWORD_INPUT).waitUntilVisible().typeAndEnter(text);
    }

    public String retrieveErrorMessageEmail() {
        return findBy(ERROR_MESSAGE_EMAIL).waitUntilVisible().getText();
    }

    public String retrieveErrorMessageConfirmEmail() {
        return findBy(ERROR_MESSAGE_CONFIRM_EMAIL).waitUntilVisible().getText();
    }

    public String retrieveErrorMessagePassword() {
        return findBy(ERROR_MESSAGE_PASSWORD).waitUntilVisible().getText();
    }

    public String retrieveErrorMessageConfirmPassword() {
        return findBy(ERROR_MESSAGE_CONFIRM_PASSWORD).waitUntilVisible().getText();
    }

}
