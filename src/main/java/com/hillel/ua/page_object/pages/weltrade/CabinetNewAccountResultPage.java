package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CabinetNewAccountResultPage extends AbstractPage {

    private static final String PLATFORM_LOCATOR = "//span[@class='mt-icon d-inline-block']"; //mtm
    private static final String ACCOUNT_LOCATOR = "//span[@class='account']";
    private static final String LEVERAGE_LOCATOR = "//div[@class='col-lg-6 col-12']//div[2]//div[2]";
    private static final String ACCOUNT_NUMBER_LOCATOR = "//div[@class='col-sm-6 d-flex align-items-center justify-content-sm-start justify-content-between']//span[1]"; //Account number
    private static final String TRADING_PASS_LOCATOR = "//div[@class='col-sm-6 title d-flex align-items-center justify-content-sm-start justify-content-between']//span[1]"; //Trading password

    public CabinetNewAccountResultPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public String getTypeAccountText() {
        return findBy(ACCOUNT_LOCATOR).waitUntilVisible().getText().toLowerCase();
    }

    public String getPlatformText() {
        return findBy(PLATFORM_LOCATOR).waitUntilVisible().getText();
    }

    public String getLeverageText() {
        return findBy(LEVERAGE_LOCATOR).waitUntilVisible().getText();
    }

    public String getAccountNumber() {
        return findBy(ACCOUNT_NUMBER_LOCATOR).waitUntilVisible().getText();
    }

    public String getTradingPassword() {
        return findBy(TRADING_PASS_LOCATOR).waitUntilVisible().getText();
    }

}
