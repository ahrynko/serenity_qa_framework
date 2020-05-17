package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.common.data.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.weltrade.AccountsInformationPanel;
import org.openqa.selenium.WebDriver;

@PartialUrl(value = "trader/account-info")
public class CabinetAccountsPage extends AbstractPage {

    private static final String ALL_ACCOUNTS_PANEL = ".//div[@class='box box-main']";

    public CabinetAccountsPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public AccountsInformationPanel getAccountsInformationPanel() {
        return new AccountsInformationPanel(find(ALL_ACCOUNTS_PANEL),this);
    }

}
