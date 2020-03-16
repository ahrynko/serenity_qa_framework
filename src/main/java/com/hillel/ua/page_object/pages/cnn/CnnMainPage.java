package com.hillel.ua.page_object.pages.cnn;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.cnn.CnnHeaderPanel;
import com.hillel.ua.page_object.panels.sportmaster.SportmasterSearchPanel;
import org.openqa.selenium.WebDriver;

public class CnnMainPage extends AbstractPage {

    private static final String HEADER_LOCATOR = " //header[@id='header-nav-container']";

    public CnnMainPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public CnnHeaderPanel getCnnHeaderPanel(){
        return new CnnHeaderPanel(findBy(HEADER_LOCATOR), this);
    }

}
