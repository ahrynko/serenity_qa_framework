package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class BurgerMenuPanel extends AbstractPanel {

  private static final String MENU_ITEMS = ".//span[@class='main-menu__text']";

  public BurgerMenuPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
    super(panelBaseLocation, driverDelegate);
  }

  public List<String>getMenuItems(){
    return findAll(MENU_ITEMS)
            .stream()
            .map(item -> item.getText()) //WebElementFacade::getText (если приходит 1 парам)
            .collect(Collectors.toList());
  }
}
