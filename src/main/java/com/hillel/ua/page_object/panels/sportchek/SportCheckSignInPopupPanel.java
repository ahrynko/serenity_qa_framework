package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SportCheckSignInPopupPanel extends AbstractPanel {

    private static final String REGISTER_NOW_BUTTON = ".//a[@data-action='register']";

    public SportCheckSignInPopupPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void clickRegisterNowButton() {  // только кликаем RegisterNow
        findBy(REGISTER_NOW_BUTTON).waitUntilClickable().click();
    }
}
