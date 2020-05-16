package com.hillel.ua.page_object.panels.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class WeltradeAuthorizationPanel extends AbstractPanel {

    private static final String EMAIL_INPUT = ".//input[@type='text']";
    private static final String PASSWORD_INPUT = ".//input[@type='password']";
    private static final String SIGN_IN_BUTTON = ".//button[@class='wt-btn blue']";

    public WeltradeAuthorizationPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void searchLoginText(final String text) {
        findBy(EMAIL_INPUT).waitUntilVisible().type(text);
    }

    public void searchPasswordText(final String text) {
        findBy(PASSWORD_INPUT).waitUntilVisible().type(text);
    }

    public void clickSignInButton() {
        findBy(SIGN_IN_BUTTON).waitUntilClickable().click();
    }

}
