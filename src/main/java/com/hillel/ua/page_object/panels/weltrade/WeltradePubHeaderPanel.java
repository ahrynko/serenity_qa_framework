package com.hillel.ua.page_object.panels.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.pages.weltrade.WeltradeSignInPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class WeltradePubHeaderPanel extends AbstractPanel {

    private static final String LOGIN_BUTTON = ".//div[@class='secondary-menu']//a[2]";


    public WeltradePubHeaderPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void clickLoginButton() {
        findBy(LOGIN_BUTTON).waitUntilVisible().click();
    }

}
