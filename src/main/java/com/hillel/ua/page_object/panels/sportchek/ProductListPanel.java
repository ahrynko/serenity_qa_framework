package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.model.sportchek.SportCheckProducts;
import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class ProductListPanel extends AbstractPanel {

    private static final String LIST_PRODUCTS_RESULT = ".//span[@class='product-title-text']";

    private static final String RATING_SKIN_RESULT = "//div[@class='product-grid__list-item-height']";
    private static final String RATING_VALUE_LOCATOR = "//span[@class='rating__value']";

    public ProductListPanel(final WebElementFacade panelBaseLocation,final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public List<String> getListAtomicText() {
        return findAll(LIST_PRODUCTS_RESULT)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public List<SportCheckProducts> getRatingForAllSkin(){
        return findAll(RATING_SKIN_RESULT)
                .stream()
                .map(product -> {
                    Integer number= Integer.valueOf(product.findBy(RATING_VALUE_LOCATOR).waitUntilVisible()
                            .getAttribute("style")
                            .replaceAll("\\D",""));

                    return new SportCheckProducts(number);
                }).collect(Collectors.toList());
    }

}
