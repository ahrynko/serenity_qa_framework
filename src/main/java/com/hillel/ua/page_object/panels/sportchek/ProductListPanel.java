package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class ProductListPanel extends AbstractPanel {

    private static final String LIST_PRODUCTS_RESULT = ".//span[@class='product-title-text']";

    public ProductListPanel(final WebElementFacade panelBaseLocation,final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public List<String> getListAtomicText() {
        return findAll(LIST_PRODUCTS_RESULT)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

}
