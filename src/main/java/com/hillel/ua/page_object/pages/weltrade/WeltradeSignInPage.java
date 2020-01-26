package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.weltrade.WeltradeAuthorizationPanel;
import org.openqa.selenium.WebDriver;

public class WeltradeSignInPage extends AbstractPage {

    private static final String AUTHORIZATION_PANEL = ".//div[@class='box mt-5']";

    public WeltradeSignInPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public WeltradeAuthorizationPanel getAuthorizPanel() {
        return new WeltradeAuthorizationPanel(findBy(AUTHORIZATION_PANEL).waitUntilVisible(),this );
    }

}
