package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SignInPanel extends AbstractPanel {

    private static final String REGISTER_BUTTON_LOCATOR = ".//a[@class='header-account__sign-in__register__link']";
    private static final String REGISTER_PANEL = ".//section[@id='auth-modal']";

    public SignInPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void clickRegisterButton() {
        findBy(REGISTER_BUTTON_LOCATOR).waitUntilVisible().click();
    }

    public RegisterPanel getRegisterPanel() {
        return new RegisterPanel(findBy(REGISTER_PANEL).waitUntilVisible(),getDriverDelegate());
    }

}
