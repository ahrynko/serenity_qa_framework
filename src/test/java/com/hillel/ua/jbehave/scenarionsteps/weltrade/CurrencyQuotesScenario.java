package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.common.data.EnvironmentProperties;
import com.hillel.ua.page_object.model.cnn.ArticleDTO;
import com.hillel.ua.page_object.model.weltrade.QuotesDTO;
import com.hillel.ua.serenity.steps.weltrade.CurrencyQuotesSteps;
import com.hillel.ua.web_services.weltrade.RestTemplate;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.List;

public class CurrencyQuotesScenario {

    @Steps
    private CurrencyQuotesSteps currencyQuotesSteps;

    @Given("user opened 'Currency Quotes Page' by url: '$url'")
    public void openCurrencyQuotesPage(final EnvironmentProperties environmentProperties) {

        final String commonUrl = environmentProperties.readProperty();
        currencyQuotesSteps.openPageByPartialUrl(commonUrl);
    }

    @When("user retrieved quotes to list with site")
    public void retrievedItemList() {
        final List<QuotesDTO> expectedQuotesList = currencyQuotesSteps.getQuotesItems();
        Serenity.setSessionVariable("expected_quotes_list").to(expectedQuotesList);
    }

    @When("user executed Rest Request with the same quotes.json")
    public void getRestRequest() {
        RestTemplate restTemplate = new RestTemplate();
        final List<QuotesDTO> actualQuotesList = restTemplate.retrieveQuotesFromApi();
        Serenity.setSessionVariable("actual_quotes_list").to(actualQuotesList);
    }

    @Then("compared two List with site and With Rest Request")
    public void verifyCompareLists() {

        final List<QuotesDTO> expectedQuotesList = Serenity.sessionVariableCalled("expected_quotes_list");
        final List<QuotesDTO> actualQuotesList = Serenity.sessionVariableCalled("actual_quotes_list");

        ReflectionAssert.assertReflectionEquals("There is incorrect quotes displayed!",
                expectedQuotesList , actualQuotesList );

    }


}
