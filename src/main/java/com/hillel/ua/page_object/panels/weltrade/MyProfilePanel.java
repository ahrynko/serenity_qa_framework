package com.hillel.ua.page_object.panels.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;

public class MyProfilePanel extends AbstractPanel {

    private static final String SETTINGS_LOCATOR = ".//a[@class='settings-link']";
    private static final String LOGO_LOCATOR = ".//a[@class='d-none d-lg-block']//img";

    public MyProfilePanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void openSettingsPage() {
        findBy(SETTINGS_LOCATOR).waitUntilClickable().click();
        Actions builder = new Actions(getDriverDelegate().getDriver());
        builder.moveToElement(findBy(LOGO_LOCATOR)).build().perform();
    }
}
