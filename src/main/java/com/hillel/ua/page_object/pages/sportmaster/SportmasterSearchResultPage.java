package com.hillel.ua.page_object.pages.sportmaster;

import com.hillel.ua.page_object.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.stream.Collectors;

public class SportmasterSearchResultPage extends AbstractPage {

  public SportmasterSearchResultPage(WebDriver webDriver) {
    super(webDriver);
  }

  private static  String SEARCH_MESSAGE_LOCATOR ="//h1";

  public String getSearchMessage(){
    return findAll(SEARCH_MESSAGE_LOCATOR)
            .stream()
            .map(WebElementFacade::getText)
            .collect(Collectors.joining(" "));
  }

}
