package com.hillel.ua.page_object.pages.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.sportchek.HeaderPanel;
import com.hillel.ua.page_object.panels.sportchek.SportCheckChooseStorePopupPanel;
import com.hillel.ua.page_object.panels.sportchek.SportCheckRegistrationPopupPanel;
import com.hillel.ua.page_object.panels.sportchek.SportCheckSignInPopupPanel;
import org.openqa.selenium.WebDriver;

public class SportchekMainPage extends AbstractPage {

  private static final String HEADER_LOCATOR = "//header[@class='page-header']"; //- относительно страницы
  private static final String REGISTER_PANEL = ".//section[@id='register-modal']";
  private static final String CHOOSE_STORE_PANEL = ".//section[@id='pickup-store-modal']";


  public SportchekMainPage(final WebDriver webDriver) {
    super(webDriver);
  }

  public HeaderPanel getHeaderPanel() {
    return new HeaderPanel(find(HEADER_LOCATOR),this);  // 1 -webelement, 2- root page
  }

  public SportCheckSignInPopupPanel getSignInPopupPanel() {
    return new SportCheckSignInPopupPanel(findBy(HEADER_LOCATOR), this);
  }

  public SportCheckRegistrationPopupPanel getsportCheckRegistrationPopupPanel() {//метод который отдаст модалку Popup
    return new SportCheckRegistrationPopupPanel(findBy(REGISTER_PANEL), this);
  }

  public SportCheckChooseStorePopupPanel getSportCheckChooseStorePopupPanel() {
    return new SportCheckChooseStorePopupPanel(findBy(CHOOSE_STORE_PANEL), this);
  }

}
