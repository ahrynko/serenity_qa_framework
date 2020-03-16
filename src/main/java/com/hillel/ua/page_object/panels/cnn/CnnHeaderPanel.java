package com.hillel.ua.page_object.panels.cnn;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class CnnHeaderPanel extends AbstractPanel {

    private static final String SEARCH_BUTTON_LOCATOR = ".//button[@data-test='searchButton']";
    private static final String SEARCH_INPUT_LOCATOR = ".//input[@id='header-search-bar']";

    public CnnHeaderPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void clickSearchButton() {
        findBy(SEARCH_BUTTON_LOCATOR).waitUntilClickable().click();
    }

    public void searchInput(final String search) {
        findBy(SEARCH_INPUT_LOCATOR).waitUntilVisible().type(search).submit();
    }

}
