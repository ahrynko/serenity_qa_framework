package com.hillel.ua.page_object.panels.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.NoSuchElementException;

import java.util.List;
import java.util.stream.Collectors;

public class SettingsPaymentTemplatesPanel extends AbstractPanel {

    private static final String PAYMENT_SYSTEM_LOCATOR = "(//div[@class='mat-input-wrapper mat-form-field-wrapper'])[2]";
    private static final String CURRENCY_LOCATOR = "(//div[@class='mat-input-wrapper mat-form-field-wrapper'])[3]";
    private static final String QIWI_PAYMENT_SYSTEM = "//span[@class='mat-option-text'][contains(text(),'QIWI')]";
    private static final String EUR_CURRENCY = "//span[@class='mat-option-text'][contains(text(),'EUR')]";
    private static final String PURSE_INPUT = "//input[@placeholder='79721234567']";

    private static final String ADD_BUTTON = "//button[@class='wt-btn blue']";
    private static final String TOAST_LOCATOR = "//div[@class='toast success ng-star-inserted']";
    private static final String ADD_BUTTON_DISABLED = "//button[@class='wt-btn disabled']";

    private static final String LIST_TEMPLATES_TITLE = "//div[@class='row align-items-center ng-star-inserted']/div/span[@class='templates-title']";
    private static final String LIST_PURSE_TITLE = "//div[@class='templates-title-wr']//span[@class='templates-title']";
    private static final String LIST_CURRENCY = "//div[@class='templates-title-wr']//span[@class='currency']";
    private static final String DELETE_BUTTON = "(//button[@class='delete ng-star-inserted'])[1]";


    public SettingsPaymentTemplatesPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void choosePaymentSystem() {
        findBy(PAYMENT_SYSTEM_LOCATOR).waitUntilVisible().click();
    }

    public void chooseQiwi() {
        findBy(QIWI_PAYMENT_SYSTEM).waitUntilVisible().click();
    }

    public void chooseCurrency() {
        findBy(CURRENCY_LOCATOR).waitUntilVisible().click();
    }

    public void chooseEurCurrency() {
        findBy(EUR_CURRENCY).waitUntilVisible().click();
    }

    public void typePurseNumber(final String purse) {
        findBy(PURSE_INPUT).type(purse);
    }

    public void clickAddButton() {
        findBy(ADD_BUTTON).waitUntilClickable().click();
    }

    public String getSuccessToast() {
        return findBy(TOAST_LOCATOR).waitUntilVisible().getText();
    }

    public List<String> getListTemplatesTitleText() {
        return findAll(LIST_TEMPLATES_TITLE)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public List<String> getListPurseTitleText() {
        return findAll(LIST_PURSE_TITLE)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public List<String> getListCurrencyTitleText() {
        return findAll(LIST_CURRENCY)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public void deletePaymentTemplate() {
        findBy(DELETE_BUTTON).waitUntilVisible().click();
    }

    public boolean isTemplatesTitlePresent() {
        try {
            findBy(LIST_TEMPLATES_TITLE).isPresent();
        } catch (NoSuchElementException e) {
            return true;
        }
        return false;
    }

}
