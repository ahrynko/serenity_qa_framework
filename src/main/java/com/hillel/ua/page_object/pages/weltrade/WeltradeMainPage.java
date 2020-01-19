package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.weltrade.WeltradePubHeaderPanel;
import org.openqa.selenium.WebDriver;

public class WeltradeMainPage extends AbstractPage {

    private static final String HEADER_LOCATOR = "//header[@class='wt-main-header js-header']";

    public WeltradeMainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public WeltradePubHeaderPanel getHeaderPanel() {
        return new WeltradePubHeaderPanel(findBy(HEADER_LOCATOR), this);
    }

}
