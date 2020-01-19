package com.hillel.ua.page_object.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public class AbstractPage extends PageObject {

    public AbstractPage(final WebDriver webDriver){  //dependency injection
        super(webDriver);
        getDriver().manage().window().maximize();
        waitForAngularRequestsToFinish();
        scrollToTop();
    }

    public void scrollToTop() {
        final String scrollScript = "window.scrollTo(0, -100);"; //js code which has scroll
        getJavascriptExecutorFacade().executeScript(scrollScript); //метод который умеет выполнять /js code
    }
}