package com.hillel.ua.page_object.panels.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class AccountsInformationPanel extends AbstractPanel {

    private static final String MODAL_ACCOUNT_PANEL = ".//div[@class='modal-tabs-body']";
    private static final String ACCOUNT_SETTINGS_LOCATOR = "//span[@class='icon icon-wt-settings ml-2']";
    private static final String RESET_FILTER_BUTTON = "//button[@class='wt-btn blue mt-3']";
    private static final String ACCOUNT_INFO_MESSAGE = "//div[@class='not-accounts text-center ng-star-inserted']//h3";

    public AccountsInformationPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public ModalTabsAccountPanel getModalTabsAccountPanel() {
        return new ModalTabsAccountPanel(findBy(MODAL_ACCOUNT_PANEL).waitUntilVisible(),getDriverDelegate());
    }

    public void clickSettingsOperations() {
        findBy(ACCOUNT_SETTINGS_LOCATOR).waitUntilClickable().click();
    }

    public void clickResetFilterButton() {
        findBy(RESET_FILTER_BUTTON).waitUntilClickable().click();
    }

    public String getAccountInformationMessage() {
        return findBy(ACCOUNT_INFO_MESSAGE).waitUntilVisible().getText();
    }

}
