package com.hillel.ua.page_object.pages;

import org.openqa.selenium.WebDriver;

public class GoogleMainPage extends AbstractPage{

  public GoogleMainPage(final WebDriver webDriver) {
    super(webDriver);
  }

  public String getCurrentTitle(){
    return getTitle();
  }

}
