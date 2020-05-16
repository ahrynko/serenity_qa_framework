package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.common.data.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

@PartialUrl(value = "trader/open-account")
public class WeltradeCabinetNewAccountPage extends AbstractPage {

    private static final String LIST_TYPE_ACCOUNT_RESULT = "//nav[@class='account-nav']";  //block
    private static final String LIST_TYPE_ACCOUNT = "//main//li";  //list
    private static final String PREMIUM_ACCOUNT = "//main//li[2]";  //Premium

    private static final String ACCOUNT_PANEL = "//div[@class='box main ng-star-inserted']"; //block
    private static final String PLATFORM_LOCATOR = "(//div[@class='mat-input-infix mat-form-field-infix'])[2]"; //platform
    private static final String MT4_PLATFORM = "(//span[@class='mat-option-text'])[1]"; //MT4
    private static final String MT5_PLATFORM = "(//span[@class='mat-option-text'])[2]"; //MT5
    private static final String PLATFORM_TEXT_LOCATOR = "(//div[@class='mat-select-value']/span/span)[2]";

    private static final String ACCOUNT_CURRENCY_LOCATOR = "(//div[@class='mat-input-infix mat-form-field-infix'])[3]"; //Account currency
    private static final String CURRENCY_USD = "(//span[@class='mat-option-text'])[1]"; //USD
    private static final String CURRENCY_EUR = "(//span[@class='mat-option-text'])[2]"; //EUR

    private static final String LEVERAGE_LOCATOR = "(//div[@class='mat-input-infix mat-form-field-infix'])[4]"; //Leverage
    private static final String LEVERAGE_1_33 = "(//span[@class='mat-option-text'])[1]"; //1:33
    private static final String LEVERAGE_1_50 = "(//span[@class='mat-option-text'])[2]"; //1:50
    private static final String LEVERAGE_1_100 = "(//span[@class='mat-option-text'])[3]"; //1:100
    private static final String LEVERAGE_TEXT_LOCATOR = "(//div[@class='mat-select-value']/span/span)[4]";

    private static final String NEW_ACCOUNT_BUTTON = "//button[@class='wt-btn green']";


    public WeltradeCabinetNewAccountPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public void choiceTypeAccount() {
        find(PREMIUM_ACCOUNT).waitUntilVisible().click();
    }

    public void choicePlatform() {
        find(PLATFORM_LOCATOR).waitUntilClickable().click();
        find(MT4_PLATFORM).waitUntilVisible().click();
    }

    public void choiceCurrency() {
        find(ACCOUNT_CURRENCY_LOCATOR).waitUntilClickable().click();
        find(CURRENCY_EUR).waitUntilVisible().click();
    }

    public void choiceLeverage() {
        find(LEVERAGE_LOCATOR).waitUntilClickable().click();
        find(LEVERAGE_1_100).waitUntilVisible().click();
    }

    public void clickButtonNewAccount() {
        find(NEW_ACCOUNT_BUTTON).click();
    }

    public String getTypeAccountText() {
        return find(PREMIUM_ACCOUNT).waitUntilVisible().getText().toLowerCase();
    }

    public String getPlatformText() {
        return find(PLATFORM_TEXT_LOCATOR).waitUntilVisible().getText();
    }

    public String getLeverageText() {
        return find(LEVERAGE_TEXT_LOCATOR).waitUntilVisible().getText();
    }
}
