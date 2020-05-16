package com.hillel.ua.page_object.panels.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;

public class SummaryAccountsPanel extends AbstractPanel {

    private static final String MODAL_ACCOUNT_PANEL = ".//div[@class='box accounts ng-star-inserted']";
    private static final String ACCOUNT_SETTINGS_LOCATOR = "(//i[@class='icon icon-wt-settings'])[1]";
    private static final String LEVERAGE_TEXT_LOCATOR = "//app-control-account//tr[1]//td[3]";
    private static final String SWITCHER_CHECKBOX_LOCATOR = "(//app-switcher)[1]";

    public SummaryAccountsPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void clickSettingsOperations() {
        findBy(ACCOUNT_SETTINGS_LOCATOR).waitUntilClickable().click();
    }

    public ModalTabsAccountPanel getModalTabsAccountPanel() {
        return new ModalTabsAccountPanel(findBy(MODAL_ACCOUNT_PANEL).waitUntilVisible(),getDriverDelegate());
    }

    public String getLeverageAccountText() {
        getDriverDelegate().reloadPage();     //ref
        return findBy(LEVERAGE_TEXT_LOCATOR).waitUntilVisible().getText();
    }

    public void switcherCheckboxDemo() {
        findBy(SWITCHER_CHECKBOX_LOCATOR).waitUntilClickable().click();
    }

    public void switcherCheckboxReal() {
        findBy(SWITCHER_CHECKBOX_LOCATOR).waitUntilClickable().click();
    }
}
