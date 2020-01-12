package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

import java.util.List;
import java.util.stream.Collectors;

public class SearchInputPanel extends AbstractPanel {

    private static final String  SEARCH_ITEMS  = ".//li[@data-type='keyphrase']//a";

    public SearchInputPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public List<String>getSearchItems() {
        return findAll(SEARCH_ITEMS)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }
}
