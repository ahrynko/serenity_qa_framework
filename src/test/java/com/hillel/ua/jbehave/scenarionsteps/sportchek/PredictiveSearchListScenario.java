package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.logging.Logger;
import com.hillel.ua.serenity.steps.sportchek.HeaderPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.SearchInputPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.SportCheckMainPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import java.util.List;

public class PredictiveSearchListScenario {

   private Logger logger = new Logger();

    @Steps
    private SportCheckMainPageSteps sportCheckMainPageSteps;

    @Steps
    private HeaderPanelSteps headerPanelSteps;

    @Steps
    private SearchInputPanelSteps searchInputPanelSteps;

    @Given("user opened site, using url: '$url'")
    public void openSite(final String url) {
        sportCheckMainPageSteps.openPage(url);
    }

    @When("user typed to search for next item: '$item'")
    public void enterTextToSearch(final String item) {
        headerPanelSteps.inputSearchFor(item);
    }

    @Then("retrieved item at list contains the word: $predictiveSearchList'")
    public void retrievedItemList(final List<String> expectedPredictiveSearchList) {

        final List<String> actualPredictiveSearchList = searchInputPanelSteps.getSearchItems();
        Assert.assertFalse("There are not item found! ", actualPredictiveSearchList.isEmpty());

        actualPredictiveSearchList.forEach(item -> {
                    Assert.assertTrue("There is not such item present!",
                            actualPredictiveSearchList.contains("NIKE"));
        });
        logger.info(actualPredictiveSearchList);
        logger.info(actualPredictiveSearchList.size());
    }
}
