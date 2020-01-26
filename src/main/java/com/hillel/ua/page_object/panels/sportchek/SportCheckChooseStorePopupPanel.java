package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SportCheckChooseStorePopupPanel extends AbstractPanel {

    private static final String CHOOSE_INPUT = ".//input[@id='pickup-modal-choose__input']";
    private static final String CHOOSE_ERROR = ".//p[@class='pickup-stores__empty']";


    public SportCheckChooseStorePopupPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void typeStore(final String typeStore ) {
        findBy(CHOOSE_INPUT).typeAndEnter(typeStore);
    }

    public String getChooseStoreError() {
        return findBy(CHOOSE_ERROR).waitUntilVisible().getText();
    }
}
