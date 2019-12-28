package com.hillel.ua.page_object.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class WebdDriverAdaptor implements WebDriver {

    private WebElement wrappedElement;
    private WebDriver wrappedDriver;

    public WebdDriverAdaptor(final WebElement wrappedElement, final WebDriver wrappedDriver) {
        this.wrappedElement = wrappedElement;
        this.wrappedDriver = wrappedDriver;
    }

    @Override
    public void get(String s) {
        wrappedDriver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return wrappedDriver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return wrappedDriver.getTitle();
    }

    @Override
    public List<WebElement> findElements(By by) {
        return wrappedDriver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return wrappedDriver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return wrappedDriver.getPageSource();
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return wrappedDriver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return wrappedDriver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return wrappedDriver.navigate();
    }

    @Override
    public Options manage() {
        return wrappedDriver.manage();
    }
}
