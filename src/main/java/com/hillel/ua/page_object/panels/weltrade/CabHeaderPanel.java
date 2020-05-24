package com.hillel.ua.page_object.panels.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;

public class CabHeaderPanel extends AbstractPanel {

    private static final String MENU_TRADER_LOCATOR = ".//a[@class='active']";
    private static final String SUB_MENU_TRADER_PANEL = ".//header//li[1]//ul[1]";
    private static final String MY_PROFILE_LOCATOR = ".//div[@class='user-info-profile']";
    private static final String MY_PROFILE_PANEL = ".//div[@class='profile-drop-down']";


    public CabHeaderPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public SubMenuTraderPanel getSubMenuTraderPanel() {
        return new SubMenuTraderPanel(findBy(SUB_MENU_TRADER_PANEL).waitUntilVisible(), getDriverDelegate());
    }

    public MyProfilePanel getMyProfilePanel() {
        return new MyProfilePanel(findBy(MY_PROFILE_PANEL).waitUntilVisible(), getDriverDelegate());
    }

    public void movedMouseToTrader() {
        Actions builder = new Actions(getDriverDelegate().getDriver());
        builder.moveToElement(findBy(MENU_TRADER_LOCATOR)).build().perform();
    }

    public void movedMouseToMyProfile() {
        Actions builder = new Actions(getDriverDelegate().getDriver());
        builder.moveToElement(findBy(MY_PROFILE_LOCATOR)).build().perform();
    }

}
