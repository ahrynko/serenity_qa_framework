package com.hillel.ua.page_object.panels.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;

public class CabHeaderPanel extends AbstractPanel {

    private static final String MENU_TRADER_LOCATOR = ".//a[@class='active']";
    private static final String SUB_MENU_TRADER_LOCATOR = ".//header//li[1]//ul[1]";

    public CabHeaderPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public SubMenuTraderPanel getSubMenuTraderPanel() {
        return new SubMenuTraderPanel(findBy(SUB_MENU_TRADER_LOCATOR).waitUntilVisible(),getDriverDelegate());
    }

    public void movedMouseToTrader() {
        Actions builder = new Actions(getDriverDelegate().getDriver());
        builder.moveToElement(findBy(MENU_TRADER_LOCATOR)).build().perform();
    }

}
