package com.hillel.ua.serenity.steps.sportmaster;

import com.hillel.ua.page_object.pages.sportmaster.SportmasterMainPage;
import com.hillel.ua.page_object.panels.sportmaster.SportmasterSearchPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportmasterMainPageSteps extends ScenarioSteps {

  private SportmasterMainPage sportmasterMainPage;

  public SportmasterMainPageSteps(final Pages pages){
    this.sportmasterMainPage = pages.getPage(SportmasterMainPage.class);
  }

  @Step
  public void openPageByUrl(final String link) {
    sportmasterMainPage.openUrl(link);
  }

  @Step
  public void clickModalButton(){
    sportmasterMainPage.clickModalButton();
  }

  @Step
  public void searchFor(final String item){
    final SportmasterSearchPanel sportmasterSearchPanel = sportmasterMainPage.getSearchPanel();
    sportmasterSearchPanel.inputSearchText(item);
  }

}
