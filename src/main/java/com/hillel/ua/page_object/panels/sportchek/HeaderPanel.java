package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;

public class HeaderPanel extends AbstractPanel {

  private static final String BURGER_MENU_BUTTON = ".//button[@class='menu-toggle']";  // -.// поиск в пределах панели
  private static final String BURGER_MENU_PANEL = ".//div[@data-module-type='MainNavigation']";
  private static final String SHOPPING_CART_LOCATOR = ".//a[@class='header-cart__trigger drawer-ui__toggle']";
  private static final String HEADER_CART_MESSAGE_LOCATOR = ".//div[@class='header-cart__empty-message']";

  public HeaderPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
    super(panelBaseLocation, driverDelegate);
  }

  public void clickBurgerMenuButton() {
    findBy(BURGER_MENU_BUTTON).waitUntilClickable().click();
  }

  public BurgerMenuPanel getBurgerMenuPanel() {
    return new BurgerMenuPanel(findBy(BURGER_MENU_PANEL).waitUntilVisible(),getDriverDelegate());
  }

  public void movedMouseToShoppingCart() {
    Actions builder = new Actions(getDriverDelegate().getDriver());
    builder.moveToElement(findBy(SHOPPING_CART_LOCATOR)).build().perform();
  }

  public String retrieveHeaderCartMessage() {
   return findBy(HEADER_CART_MESSAGE_LOCATOR).waitUntilVisible().getText();
  }

}
