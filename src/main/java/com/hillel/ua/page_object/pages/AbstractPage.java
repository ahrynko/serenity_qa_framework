package com.hillel.ua.page_object.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class AbstractPage extends PageObject {

    public AbstractPage(final WebDriver webDriver){  //dependency injection
        super(webDriver);
        getDriver().manage().window().maximize();
        waitForAngularRequestsToFinish();
    }
}