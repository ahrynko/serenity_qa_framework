package com.hillel.ua.page_object.pages;

import com.hillel.ua.page_object.panels.SportmasterSearchPanel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class SportmasterMainPage extends AbstractPage {

  public SportmasterMainPage( final WebDriver webDriver) {
    super(webDriver);
  }

  private static final String SEARCH_PANEL_LOCATOR = "//div[@class='new-nav-header']";

  private static final String  MODAL_BUTTON_RED_LOCATOR = "//button[@id='set_town']";

  public void clickModalButton (){
    findBy(MODAL_BUTTON_RED_LOCATOR).click();
    JavascriptExecutor jsx = (JavascriptExecutor)getDriver();
    jsx.executeScript("window.scrollBy(0,100)", "");
  }

  public SportmasterSearchPanel getSearchPanel(){
    return new SportmasterSearchPanel(findBy(SEARCH_PANEL_LOCATOR), this);
  }

}
