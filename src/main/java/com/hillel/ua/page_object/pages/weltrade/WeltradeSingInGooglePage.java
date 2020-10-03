package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.page_object.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeltradeSingInGooglePage extends AbstractPage {

    private static final String EMAIL_INPUT_LOCATOR = ".//input[@id='identifierId']";
    private static final String PASSWORD_INPUT_LOCATOR = ".//input[@class='whsOnd zHQkBf']";
    private static final String NEXT_BUTTON = ".//div[@id='identifierNext']";
    private static final String PASS_NEXT_BUTTON = ".//div[@id='passwordNext']";
    private static final String FORGOT_PASSWORD_BUTTON = ".//div[@id='forgotPassword']";
    private static final String PROFILE = ".//div[@id='profileIdentifier']";

    public WeltradeSingInGooglePage(final WebDriver webDriver) {
        super(webDriver);
    }

    public void inputEmailText (final String text){
        findBy(EMAIL_INPUT_LOCATOR).waitUntilVisible().type(text);
    }

    public void clickNextButton() {
        find(NEXT_BUTTON).waitUntilClickable().click();
    }

    public void inputPasswordText (final String text){
        find(NEXT_BUTTON).waitUntilNotVisible();
        findBy(PASSWORD_INPUT_LOCATOR).waitUntilVisible().type(text);
    }

    public void clickPassNextButton() {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(findBy(PASS_NEXT_BUTTON)).build().perform();
        find(PASS_NEXT_BUTTON).waitUntilClickable().click();
    }

}
