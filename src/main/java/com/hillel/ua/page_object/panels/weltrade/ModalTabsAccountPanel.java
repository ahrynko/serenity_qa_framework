package com.hillel.ua.page_object.panels.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import java.util.List;
import java.util.Random;

public class ModalTabsAccountPanel  extends AbstractPanel {

    private static final String LEVERAGE_LOCATOR = "(//div[@class='mat-input-infix mat-form-field-infix'])[8]";
    private static final String LIST_LEVERAGE_LOCATOR = ".//div[@class='mat-select-content ng-trigger ng-trigger-fadeInContent']/mat-option";
    private static final String CHANGE_BUTTON = ".//form[@class='ng-touched ng-dirty ng-valid']//button[@class='wt-btn green']";
    private static final String LEVERAGE_TEXT_LOCATOR = "(//div[@class='mat-select-value']//span/span)[6]";

    public ModalTabsAccountPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void choiceLeverage() {
        findBy(LEVERAGE_LOCATOR).waitUntilClickable().click();

        List<WebElementFacade> list = findAll(LIST_LEVERAGE_LOCATOR);
        Random random = new Random();
        int randomValue = random.nextInt(list.size());
        list.get(randomValue).click();
    }

    public void clickChangeButton() {
        findBy(CHANGE_BUTTON).waitUntilClickable().click();
    }

    public String getLeverageText() {
        return findBy(LEVERAGE_TEXT_LOCATOR).waitUntilVisible().getText();
    }

}
