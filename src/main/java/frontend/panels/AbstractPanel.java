package frontend.panels;

import frontend.WebDriverAdaptor;
import frontend.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.locators.SmartElementLocatorFactory;
import net.thucydides.core.annotations.locators.SmartFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public abstract class AbstractPanel {

    private AbstractPage driver;
    private WebDriverAdaptor panelToWebDriver;


    public AbstractPanel(final WebElementFacade panelBaseLocation, final AbstractPage rootPage) {
        initPanel(panelBaseLocation, rootPage);
    }

    private void initPanel(final WebElementFacade panelBaseLocation, final AbstractPage driverDelegate) {
        this.driver = driverDelegate;

        panelToWebDriver = new WebDriverAdaptor(panelBaseLocation, getDriver());
        final ElementLocatorFactory finder = new SmartElementLocatorFactory(panelToWebDriver, null, 50);
        final FieldDecorator decorator = new SmartFieldDecorator(finder, getDriver(), driverDelegate);
        PageFactory.initElements(decorator, this);
    }

    public AbstractPage getRootPage(){
        return driver;
    }
}
