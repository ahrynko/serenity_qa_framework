package frontend.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage extends PageObject {

    public AbstractPage(final WebDriver driver) {
        super(driver);
        driver.manage().window().maximize();
    }
}
