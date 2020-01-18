package com.hillel.ua.page_object.pages.google;

import com.hillel.ua.page_object.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class GoogleMainPage extends AbstractPage {

  private static final String LOGO_LOCATOR = "//img[@id='hplogo']";

  public GoogleMainPage(final WebDriver webDriver) {
    super(webDriver);
  }

  public String getCurrentTitle(){
    return getTitle();
  }

  public boolean isLogoVisible() {
    return findBy(LOGO_LOCATOR).isCurrentlyVisible();
  }
}
