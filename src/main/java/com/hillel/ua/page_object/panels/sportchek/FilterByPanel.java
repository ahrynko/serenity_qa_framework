package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;

public class FilterByPanel extends AbstractPanel {

    private static final String ATOMIC_CHECKBOX = ".//span[contains(text(),'ATOMIC (14)')]";
    private static final String TECNO_PRO_CHECKBOX = ".//span[contains(text(),'TECNO PRO (4)')]";
    private static final String CLEAR_ALL_BUTTON = ".//a[@class='facets-side__footer-link facets-side__clear-link']";

    private static final String LIST_BRANDS = ".//div[@class='product-listing__facets']//li[3]";


    public FilterByPanel(WebElementFacade panelBaseLocation, AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void chooseAtomic() {
        Actions builder = new Actions(getDriverDelegate().getDriver());
        builder.moveToElement(findBy(ATOMIC_CHECKBOX)).build().perform();

        findBy(ATOMIC_CHECKBOX).waitUntilClickable().click();
    }

    public void chooseTecnoPro() {
        Actions builder = new Actions(getDriverDelegate().getDriver());
        builder.moveToElement(findBy(LIST_BRANDS)).build().perform();

        findBy(TECNO_PRO_CHECKBOX).waitUntilClickable().click();
    }

    public void clickClearAllButton() {
        Actions builder = new Actions(getDriverDelegate().getDriver());
        builder.moveToElement(findBy(LIST_BRANDS)).build().perform();

        findBy(CLEAR_ALL_BUTTON).waitUntilClickable().click();
    }

}
