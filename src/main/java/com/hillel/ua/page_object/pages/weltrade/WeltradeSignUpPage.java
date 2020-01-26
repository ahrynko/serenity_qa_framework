package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.weltrade.WeltradeRegistrationPanel;
import org.openqa.selenium.WebDriver;

public class WeltradeSignUpPage extends AbstractPage {

    private static final String REGISTRATION_PANEL = ".//div[@class='box']";

    public WeltradeSignUpPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public WeltradeRegistrationPanel getRegistrPanel() {
        return new WeltradeRegistrationPanel(findBy(REGISTRATION_PANEL).waitUntilVisible(),this);
    }

}
