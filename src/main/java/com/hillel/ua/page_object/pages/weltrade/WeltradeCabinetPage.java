package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

public class WeltradeCabinetPage extends AbstractPage {

    public WeltradeCabinetPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getCurrentTitle(){
        return getTitle();
    }
}
