package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.common.data.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import java.util.Random;

@PartialUrl(value = "settings/personal-data")
public class CabinetSettingsPage extends AbstractPage {

    private static final String  CITY_INPUT = "//input[@id='userCity']";
    private static final String  SAVE_BUTTON = "//button[@class='wt-btn green']";
    private static final String  SAVE_BUTTON_DISABLED = "//button[@class='wt-btn green disabled']";
    private static final String  SUCCESS_TOAST_LOCATOR = "//div[@class='toast success ng-star-inserted']/span"; //Operation completed
    private static final String  ERROR_MESSAGE_CITY = "//div[@class='error-txt ng-star-inserted']";
    private static final String  PERSONAL_DATA_LOCATOR = "//a[@class='active']";

    public CabinetSettingsPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public void changeRandomCity() {
        String[] city = {"Warsaw", "Barcelona", "Vienna", "Berlin", "Rome", "Paris"};
        Random random = new Random();
        find(CITY_INPUT).waitUntilVisible().clear();
        find(CITY_INPUT).type(city[random.nextInt(city.length)]);
    }

    public void clickSaveButton() {
        find(SAVE_BUTTON).waitUntilClickable().click();
    }

    public String getSuccessToast() {
       return find(SUCCESS_TOAST_LOCATOR).waitUntilVisible().getText();
    }

    public void searchCityText(final String symbols) {
        findBy(CITY_INPUT).waitUntilVisible().type(symbols);
    }

    public String retrieveErrorMessageCity() {
        return findBy(ERROR_MESSAGE_CITY).waitUntilVisible().getText().trim();
    }

    public void clickPersonalDataNav() {
        findBy(PERSONAL_DATA_LOCATOR).waitUntilClickable().click();
    }

    public void typeCity(final String city) {
        findBy(CITY_INPUT).typeAndEnter(city);
    }

    public boolean isAttributePresent() {
        boolean result = false;
        try {
            String value = findBy(SAVE_BUTTON_DISABLED).getAttribute("class");
            if (value != null){
                result = true;
            }
        } catch (Exception e) {
            throw new NoSuchElementException("An Exception occurred while executing!", e);
        }

        return result;
    }

    public void enterSpacesToCity(final String city) {
        find(CITY_INPUT).waitUntilVisible().clear();
        findBy(CITY_INPUT).typeAndEnter(city);
    }

}
