package com.hillel.ua.jbehave.scenarionsteps.google;

import com.hillel.ua.serenity.steps.google.GoogleMainPageSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.*;
import org.junit.Assert;

public class GoogleMainPageScenario {

  @Steps
  private GoogleMainPageSteps googleMainPageSteps;
  //private  String actualTitle; //can, but better session

  @Given("user opened following url: '$url'")
  @Aliases(values = {
          "user opened Google site, by next url: '$url'",
          "user opened Google site, by following url: '$url'",
          "user opened Google Main site, by next url: '$url'"
  })
  public void openGoogleMainPage(final String url){ //precondition, can be more 1
    googleMainPageSteps.openPageByUrl(url);
  }

  @When("user retrieved site title")
  public void retrieveSiteTitle(){ // smth doing
    final String actualTitle = googleMainPageSteps.getCurrentTitle();
    Serenity.setSessionVariable("actual_title").to(actualTitle);
  }

  @Then("retrieved title value should be: '$expectedTitle'")
  public void verifySiteTitle(final String expectedTitle){  //verify
    final String savedTitle = Serenity.sessionVariableCalled("actual_title");
    Assert.assertEquals("There is incorrect title displayed!",expectedTitle,savedTitle);
  }

  @Then("Google logo displayed")
  public void isLogoDisplayed() {
    Assert.assertTrue("There is no logo diplayed!", googleMainPageSteps.isLogoVisible());

  }

}
