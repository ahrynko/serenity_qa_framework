package com.hillel.ua.page_object.panels.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.interactions.Actions;

public class SubMenuTraderPanel extends AbstractPanel {

    private static final String SUB_MENU_OPEN_ACCOUNT = ".//a[@routerlink='/trader/open-account']";  //header//li[1]//ul[1]//li[3]//a[1]
    private static final String LOGO_LOCATOR = ".//a[@class='d-none d-lg-block']//img";

    public SubMenuTraderPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public void OpenNewAccountPage() {
        findBy(SUB_MENU_OPEN_ACCOUNT).waitUntilClickable().click();
        Actions builder = new Actions(getDriverDelegate().getDriver());
        builder.moveToElement(findBy(LOGO_LOCATOR)).build().perform();
    }
}
