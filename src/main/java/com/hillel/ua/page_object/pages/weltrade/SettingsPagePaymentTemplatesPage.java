package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.common.data.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.weltrade.SettingsPaymentTemplatesPanel;
import org.openqa.selenium.WebDriver;

@PartialUrl(value = "settings/templates")
public class SettingsPagePaymentTemplatesPage extends AbstractPage {

    private static final String PAYMENT_TEMPLATES_PANEL = ".//div[@class='box ng-star-inserted']";

    public SettingsPagePaymentTemplatesPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public SettingsPaymentTemplatesPanel getSettingsPaymentTemplatesPanel() {
        return new SettingsPaymentTemplatesPanel(find(PAYMENT_TEMPLATES_PANEL), this);
    }
}
