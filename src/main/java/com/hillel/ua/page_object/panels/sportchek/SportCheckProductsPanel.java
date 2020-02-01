package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SportCheckProductsPanel extends AbstractPanel {

    private static final String PRODUCT_TITLE_LOCATOR = ".//span[@class='product-title-text']";
    private static final String RATING_VALUE_LOCATOR = ".//span[@class='rating__value']";

    public SportCheckProductsPanel(final WebElementFacade panelBaseLocation,final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

}
