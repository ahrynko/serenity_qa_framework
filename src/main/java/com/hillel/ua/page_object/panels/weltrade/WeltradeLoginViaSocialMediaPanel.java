package com.hillel.ua.page_object.panels.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class WeltradeLoginViaSocialMediaPanel extends AbstractPanel {

    private static final String LOGIN_GOOGLE_BUTTON = ".//a[@class='wt-btn google d-flex justify-content-center align-items-center']";


    public WeltradeLoginViaSocialMediaPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void clickLoginGoogleButton() {
        findBy(LOGIN_GOOGLE_BUTTON).waitUntilClickable().click();
    }

}
