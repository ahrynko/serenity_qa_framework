package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class HeaderPanel extends AbstractPanel {

  private static final String BURGER_MENU_BUTTON = ".//button[@class='menu-toggle']";  // -.// поиск в пределах панели
  private static final String BURGER_MENU_PANEL = ".//div[@data-module-type='MainNavigation']";

  public HeaderPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
    super(panelBaseLocation, driverDelegate);
  }

  public void clickBurgerMenuButton() {
    findBy(BURGER_MENU_BUTTON).waitUntilClickable().click();
  }

  public BurgerMenuPanel getBurgerMenuPanel() {
    return new BurgerMenuPanel(findBy(BURGER_MENU_PANEL).waitUntilVisible(),getDriverDelegate());

  }
}
