package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.common.data.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.weltrade.SettingsAuthorizationPanel;
import org.openqa.selenium.WebDriver;

@PartialUrl(value = "settings/authorization")
public class CabinetSettingsPageAuthorization extends AbstractPage {

    private static final String SETTING_AUTHOR_PANEL = ".//div[@class='box ng-star-inserted']";

    public CabinetSettingsPageAuthorization(final WebDriver webDriver) {
        super(webDriver);
    }

    public SettingsAuthorizationPanel getSettingsAuthorizationPanel() {
        return new SettingsAuthorizationPanel(find(SETTING_AUTHOR_PANEL), this);
    }

}
