package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.Random;


public class ProductDetailPanel extends AbstractPanel {

    private static final String SIZE_ITEMS_LOCATOR = ".//div[@class='option-tiles']//a";
    private static final String SIZE_ITEM_RANDOM_LOCATOR = ".//div[@class='product-detail__size dropdown-wrapper']//a[2]";
    private static final String ADD_TO_CART_BUTTON_LOCATOR = ".//button[@class='add-cart product-detail__button product-detail__button-icon']";
    private static final String PAGE_TITLE_LOCATOR = ".//h1[@class='global-page-header__title']";


    public ProductDetailPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void chooseRandomSize() {
        //TODO
        Random randomSize = new Random();
        final String sizeChart = findBy(SIZE_ITEMS_LOCATOR).waitUntilClickable().getText();

    }

    public void chooseSize() {
        findBy(SIZE_ITEM_RANDOM_LOCATOR).waitUntilClickable().click();
    }


    public void clickAddToCartButton() {
        findBy(ADD_TO_CART_BUTTON_LOCATOR).waitUntilClickable().click();
    }
}
