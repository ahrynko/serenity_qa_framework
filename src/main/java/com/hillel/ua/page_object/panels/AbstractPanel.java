package com.hillel.ua.page_object.panels;

import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.webdriver.WebDriverAdaptor;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.locators.SmartElementLocatorFactory;
import net.thucydides.core.annotations.locators.SmartFieldDecorator;
import net.thucydides.core.webdriver.MobilePlatform;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public abstract class AbstractPanel {

  private long waitForTimeoutInMilliseconds = 5000;
  private AbstractPage driverDelegate;
  private WebDriverAdaptor panelToWebDriver;

  public AbstractPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate){
    initPanel(panelBaseLocation, driverDelegate);
  }

  private void initPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate){
    this.driverDelegate = driverDelegate;
    waitForTimeoutInMilliseconds = driverDelegate.waitForTimeoutInMilliseconds();
    panelToWebDriver = new WebDriverAdaptor(panelBaseLocation, getDriver()); //Adaptor -подружить два элемента (webDriver/ webElement)
    final ElementLocatorFactory finder = new SmartElementLocatorFactory(panelToWebDriver, MobilePlatform.NONE); //finder- ищет элементы на странице по локатору
    final FieldDecorator decorator = new SmartFieldDecorator(finder, getDriver(), driverDelegate); //decorator - связка кнопки с webElement
    PageFactory.initElements(decorator, this); //serenity _decorator
  }
}