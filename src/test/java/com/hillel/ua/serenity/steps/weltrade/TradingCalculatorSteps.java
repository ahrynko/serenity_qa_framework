package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.common.data.UrlBuilder;
import com.hillel.ua.page_object.pages.weltrade.WeltradeTradingCalculatorPage;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class  TradingCalculatorSteps extends ScenarioSteps {

    private WeltradeTradingCalculatorPage weltradeTradingCalculator;

    public TradingCalculatorSteps(final Pages pages) {
        this.weltradeTradingCalculator = pages.getPage(WeltradeTradingCalculatorPage.class);
    }

    public void openPageByPartialUrl(final String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl, WeltradeTradingCalculatorPage.class);
        weltradeTradingCalculator.openUrl(fullNavUrl);
    }

    public void chooseDemo() {
        weltradeTradingCalculator.chooseDemo("demo");
    }

    public void chooseTool() {
        weltradeTradingCalculator.chooseTool("AUDCAD");
    }

    public void inputSearchFor(final String digit) {
        weltradeTradingCalculator.inputSearchText(digit);
    }

    public void chooseLeverage() {
        weltradeTradingCalculator.chooseLeverage("1:10");
    }

    public void clicksCalculateButton() {
        weltradeTradingCalculator.clicksCalculateButton();
    }

    public String getContractSize() {
        return weltradeTradingCalculator.getContractSize();
    }
}
