package com.hillel.ua.page_object.panels;

import com.hillel.ua.page_object.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;

public class SportmasterSearchPanel extends AbstractPanel{

  private static final String SEARCH_INPUT_LOCATOR = ".//input[@name='search_str']";

  public SportmasterSearchPanel(final WebElementFacade panelBaseLocation, final AbstractPage rootPage) {
    super(panelBaseLocation, rootPage);
  }

  public void inputSearchText (final String text){
    getRootPage().findBy(SEARCH_INPUT_LOCATOR).typeAndEnter(text);
  }

}
