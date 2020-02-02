package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;

public class FilterByPanel extends AbstractPanel {

    private static final String ATOMIC_CHECKBOX = ".//span[contains(text(),'ATOMIC (14)')]";

    public FilterByPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void chooseAtomic() {
        Actions builder = new Actions(getDriverDelegate().getDriver());
        builder.moveToElement(findBy(ATOMIC_CHECKBOX)).build().perform();

        findBy(ATOMIC_CHECKBOX).waitUntilClickable().click();
    }

}
