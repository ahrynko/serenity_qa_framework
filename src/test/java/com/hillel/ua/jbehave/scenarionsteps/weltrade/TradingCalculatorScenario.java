package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.common.data.EnvironmentProperties;
import com.hillel.ua.serenity.steps.weltrade.TradingCalculatorSteps;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class TradingCalculatorScenario {

    @Steps
    private TradingCalculatorSteps tradingCalculatorSteps;

    @Given("user opened 'Trading Calculator Page' by url: '$url'")
    public void openTradingCalculatorPage(final EnvironmentProperties environmentProperties) {

        final String commonUrl = environmentProperties.readProperty();
        tradingCalculatorSteps.openPageByPartialUrl(commonUrl);
    }

    @When("user chooses 'Demo' account type")
    public void chooseDemoAccount() {
        tradingCalculatorSteps.chooseDemo();
    }

    @When("user chooses AUDCAD tool")
    public void chooseTool() {
        tradingCalculatorSteps.chooseTool();
    }

    @When("user typed to search input: '$input'")
    public void enterTextToInput(final String input) {
        tradingCalculatorSteps.inputSearchFor(input);
    }

    @When("user chooses 1:10 Leverage")
    public void chooseLeverage() {
        tradingCalculatorSteps.chooseLeverage();
    }

    @When("user clicks 'Calculate' button")
    public void clicksCalculateButton() {
        tradingCalculatorSteps.clicksCalculateButton();

    }

    @Then("following displayed Contract size with value: '$expectedContractSize'")
    public void isContractSize(final String expectedContractSize) {

        final String actualContractSize = tradingCalculatorSteps.getContractSize();

        Assertions.assertThat(actualContractSize) //  with site
                .as("There is incorrect Contract Size displayed!")
                .isEqualTo(expectedContractSize);  // we expect see
    }
}
