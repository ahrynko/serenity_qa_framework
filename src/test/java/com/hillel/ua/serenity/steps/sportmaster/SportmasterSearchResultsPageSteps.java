package com.hillel.ua.serenity.steps.sportmaster;

import com.hillel.ua.page_object.pages.sportmaster.SportmasterSearchResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportmasterSearchResultsPageSteps extends ScenarioSteps {

  private SportmasterSearchResultPage sportmasterSearchResultsPage;

  public SportmasterSearchResultsPageSteps (final Pages pages){
    sportmasterSearchResultsPage= pages.getPage(SportmasterSearchResultPage.class);
  }

  @Step
  public String getDisplayedSearchMessage(){
    return sportmasterSearchResultsPage.getSearchMessage();
  }

}
