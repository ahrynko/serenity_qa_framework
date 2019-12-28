package frontend;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class WebDriverAdaptor implements WebDriver {

    private WebDriver driver;
    private WebElement webElement;

    public WebDriverAdaptor(final WebElement wrappedElement, final WebDriver wrappedDriver){
        this.driver=wrappedDriver;
        this.webElement=wrappedElement;

    }

    @Override
    public void get(final String s) {
        driver.get(s);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List<WebElement> findElements(final By by) {
        return null;
    }

    @Override
    public WebElement findElement(final By by) {
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();

    }

    @Override
    public void quit() {
        driver.quit();

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return null;
    }

    @Override
    public Options manage() {
        return null;
    }
}
