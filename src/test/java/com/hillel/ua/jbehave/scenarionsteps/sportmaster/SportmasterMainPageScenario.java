package com.hillel.ua.jbehave.scenarionsteps.sportmaster;

import com.hillel.ua.serenity.steps.sportmaster.SportmasterMainPageSteps;
import com.hillel.ua.serenity.steps.sportmaster.SportmasterSearchResultsPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class SportmasterMainPageScenario {

  @Steps
  private SportmasterMainPageSteps sportmasterMainPageSteps;

  @Steps
  private SportmasterSearchResultsPageSteps sportmasterSearchResultsPageSteps;

  @Given("user opens page using following link: '$link'")
  public void openSportmasterMainPage(final String link){
    sportmasterMainPageSteps.openPageByUrl(link);
  }

  @When("search for next item: '$item'")
  public void searchFor(final String item){
    sportmasterMainPageSteps.clickModalButton();
    sportmasterMainPageSteps.searchFor(item);
  }

  @Then("following message is displayed : '$message'")
  public void isMessageDisplayed(final String expectedSearchMessage){

    final String actualSearchMessage = sportmasterSearchResultsPageSteps.getDisplayedSearchMessage();
    Assert.assertEquals("There is incorrect msg!", actualSearchMessage, expectedSearchMessage);
  }

}
