package com.hillel.ua.page_object.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class AbstarctPage extends PageObject {

    public AbstarctPage (final WebDriver webDriver){
        super(webDriver);
        getDriver().manage().window().maximize();
        waitForAngularRequestsToFinish();
    }
}