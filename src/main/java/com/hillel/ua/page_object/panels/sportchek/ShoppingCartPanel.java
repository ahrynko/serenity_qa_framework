package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class ShoppingCartPanel extends AbstractPanel {

    private static final String PRODUCT_TITLE_LOCATOR = ".//a[@class='sc-product__title-link']";
    private static final String SIZE_ITEM_LOCATOR = ".//span[contains(text(),'Size:')]";   //span[@class='sc-product__property__name']


    public ShoppingCartPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public String getSizeItemText() {
        return findBy(SIZE_ITEM_LOCATOR).waitUntilVisible().getText();
    }

    public String getTitleItemText() {
        return findBy(PRODUCT_TITLE_LOCATOR).waitUntilVisible().getText();
    }

}
