package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.model.sportchek.SportCheckProducts;
import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class ProductListPanel extends AbstractPanel {

    private static final String LIST_PRODUCTS_RESULT = ".//span[@class='product-title-text']";
    private static final String LIST_PRODUCTS = ".//div[@class='product-grid__list-item-height']";

    private static final String PRODUCT_TITLE_LOCATOR = ".//span[@class='product-title-text']";
    private static final String RATING_VALUE_LOCATOR = ".//span[@class='rating__value']";

    public ProductListPanel(final WebElementFacade panelBaseLocation,final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public List<String> getListAtomicText() {
        return findAll(LIST_PRODUCTS_RESULT)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public List<SportCheckProducts> getSportCheckProducts(){
        return findAll(LIST_PRODUCTS)
                .stream()
                .map(product -> {
                    String title = product.findBy(PRODUCT_TITLE_LOCATOR).getText();
                    Integer number= Integer.valueOf(product.findBy(RATING_VALUE_LOCATOR).getAttribute("style"));
                    return new SportCheckProducts(title, number);
                }).collect(Collectors.toList());
    }

}
