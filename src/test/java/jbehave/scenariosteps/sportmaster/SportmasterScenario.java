package jbehave.scenariosteps.sportmaster;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;
import serenity.steps.google.sportmaster.SportmasterMainPageSteps;
import serenity.steps.google.sportmaster.SportmasterSearchResultsPageSteps;

public class SportmasterScenario {

    @Steps
    private SportmasterMainPageSteps sportmasterMainPageSteps;

    @Steps
    private SportmasterSearchResultsPageSteps sportmasterSearchResultsPageSteps;

    @Given("user opens page using following link: '$link'")
    public void openMainPage(final String Link){

    }

    @When("search for next item: '$item'")
    public void searchFor(final String item){

        sportmasterMainPageSteps.searchFor(item);

    }

    @Then("following message is displayed : '$message'")
    public void isMessageDisplayed(final String expectedSearchMessage){
        final String actualSearchMessage = sportmasterSearchResultsPageSteps.getDisplayedSearchMessage();
        Assert.assertEquals("there is incorrect msg!", actualSearchMessage, expectedSearchMessage);

    }
}
