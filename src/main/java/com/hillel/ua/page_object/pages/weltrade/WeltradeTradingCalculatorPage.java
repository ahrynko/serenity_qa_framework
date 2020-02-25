package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.common.data.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

@PartialUrl(value = "tools/calculator")
public class WeltradeTradingCalculatorPage extends AbstractPage {

    private static final String DEMO_SELECT_LOCATOR = "//select[@id='select-account-type']";
    private static final String TOOL_SELECT_LOCATOR = "//select[@id='select-instrumental']";
    private static final String INPUT_LOT_LOCATOR = "//input[@id='select-lot']";
    private static final String LEVERAGE_SELECT_LOCATOR = "//select[@id='select-leverage']";
    private static final String CALCULATE_BUTTON = "//button[@class='wt-btn blue']";
    private static final String CONTRACT_SIZE_LOCATOR = "(//p[@class='ng-binding'])[1]";

    public WeltradeTradingCalculatorPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public void chooseDemo(String text) {
        Select select = new Select(findBy(DEMO_SELECT_LOCATOR));
        select.selectByVisibleText(text);
    }

    public void chooseTool(String text) {
        Select select = new Select(findBy(TOOL_SELECT_LOCATOR));
        select.selectByVisibleText(text);
    }

    public void inputSearchText(final String digit) {
        findBy(INPUT_LOT_LOCATOR).waitUntilVisible().type(digit);
    }

    public void chooseLeverage(String text) {
        Select select = new Select(findBy(LEVERAGE_SELECT_LOCATOR));
        select.selectByVisibleText(text);
    }

    public void clicksCalculateButton() {
        findBy(CALCULATE_BUTTON).waitUntilClickable().click();
    }

    public String getContractSize() {
        return findBy(CONTRACT_SIZE_LOCATOR).getText();
    }
}
