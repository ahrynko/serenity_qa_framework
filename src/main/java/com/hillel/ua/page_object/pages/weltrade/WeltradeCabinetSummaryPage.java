package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.weltrade.CabHeaderPanel;
import com.hillel.ua.page_object.panels.weltrade.SummaryAccountsPanel;
import org.openqa.selenium.WebDriver;

public class WeltradeCabinetSummaryPage extends AbstractPage {

    private static final String ACCOUNTS_PANEL = ".//div[@class='box accounts ng-star-inserted']";
    private static final String HEADER_CAB_LOCATOR = "//header[@role='banner']";
    private static final String T2W_BANNER = "//div[@class='modal']/div/div/a";

    public WeltradeCabinetSummaryPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public CabHeaderPanel getCabHeaderPanel() {
        return new CabHeaderPanel(findBy(HEADER_CAB_LOCATOR), this);
    }

    public SummaryAccountsPanel getSummaryAccountsPanel() {
        return new SummaryAccountsPanel(find(ACCOUNTS_PANEL),this);
    }

    public String getCurrentTitle(){
        return getTitle();
    }

    public void closeT2WBanner() {
        find(T2W_BANNER).waitUntilClickable().click();
    }
}