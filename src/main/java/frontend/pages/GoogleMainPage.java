package frontend.pages;

import org.openqa.selenium.WebDriver;

public class GoogleMainPage extends AbstractPage {

    private static final String GOOGLE_LOGO_LOCATOR = "//img[@id='hplogo']";


    public GoogleMainPage(final WebDriver driver) {
        super(driver);
    }

    public String getCurrentTitle() {
        return getTitle();
    }

    public Boolean getLogoVisibility(){
        return findBy(GOOGLE_LOGO_LOCATOR).isDisplayed();
    }


}
