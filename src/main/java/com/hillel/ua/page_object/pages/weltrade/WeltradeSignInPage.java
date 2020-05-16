package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.common.data.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.weltrade.WeltradeAuthorizationPanel;
import com.hillel.ua.page_object.panels.weltrade.WeltradeLoginViaSocialMediaPanel;
import org.openqa.selenium.WebDriver;

@PartialUrl(value = "auth/login")
public class WeltradeSignInPage extends AbstractPage {

    private static final String AUTHORIZATION_PANEL = ".//div[@class='box mt-5']";
    private static final String LOGIN_SOCIAL_MEDIA_PANEL = ".//div[@class='box']";


    public WeltradeSignInPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public WeltradeAuthorizationPanel getAuthorizPanel() {
        return new WeltradeAuthorizationPanel(findBy(AUTHORIZATION_PANEL).waitUntilVisible(),this );
    }

    public WeltradeLoginViaSocialMediaPanel getLoginSocialMediaPanel() {
        return new WeltradeLoginViaSocialMediaPanel(findBy(LOGIN_SOCIAL_MEDIA_PANEL).waitUntilVisible(),this );
    }
}
