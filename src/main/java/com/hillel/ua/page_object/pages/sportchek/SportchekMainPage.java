package com.hillel.ua.page_object.pages.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.sportchek.HeaderPanel;
import com.hillel.ua.page_object.panels.sportchek.SportCheckSignInPopupPanel;
import com.hillel.ua.page_object.panels.sportmaster.SportmasterSearchPanel;
import org.openqa.selenium.WebDriver;

public class SportchekMainPage extends AbstractPage {

  private static final String HEADER_LOCATOR = "//header[@class='page-header']"; //- относительно страницы

  public SportchekMainPage(final WebDriver webDriver) {
    super(webDriver);
  }

  public HeaderPanel getHeaderPanel() {
    return new HeaderPanel(find(HEADER_LOCATOR),this);  // 1 -webelement, 2- root page
  }

  public SportCheckSignInPopupPanel getSignInPopupPanel() {
    return new SportCheckSignInPopupPanel(findBy(HEADER_LOCATOR), this);
  }

}
