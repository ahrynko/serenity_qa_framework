package com.hillel.ua.page_object.panels.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SettingsAuthorizationPanel extends AbstractPanel {

    private static final String CONTINUE_BUTTON = ".//button[@class='wt-btn blue confirmation-code-btn']";
    private static final String OLD_PASSWORD_INPUT = ".//input[@id='oldPassword']";
    private static final String NEW_PASSWORD_INPUT = ".//input[@id='newPassword']";
    private static final String CONFIRM_NEW_PASSWORD_INPUT = ".//input[@id='confirmNewPassword']";
    private static final String SUCCESS_TOAST_LOCATOR = ".//span[contains(text(),'Password changed')]";

    public SettingsAuthorizationPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void searchValidPasswordText(final String validPassword) {
        findBy(OLD_PASSWORD_INPUT).waitUntilVisible().type(validPassword);
    }

    public void searchNewPasswordText(final String newPassword) {
        findBy(NEW_PASSWORD_INPUT).waitUntilVisible().type(newPassword);
    }

    public void searchRepeatNewPasswordText(final String repeatNewPassword) {
        findBy(CONFIRM_NEW_PASSWORD_INPUT).waitUntilVisible().type(repeatNewPassword);
    }

    public void clickContinueButton() {
        findBy(CONTINUE_BUTTON).waitUntilClickable().click();
    }

    public String getSuccessToast() {
        return findBy(SUCCESS_TOAST_LOCATOR).waitUntilVisible().getText();
    }

}
