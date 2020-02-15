package com.hillel.ua.page_object.panels.sportchek;

import com.hillel.ua.page_object.model.sportchek.SportCheckProducts;
import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.AbstractPanel;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

public class ProductListPanel extends AbstractPanel {

    private static final String LIST_PRODUCTS_RESULT = ".//span[@class='product-title-text']";

    private static final String RATING_SKIN_RESULT = "//div[@class='product-grid__list-item-height']";
    private static final String RATING_VALUE_LOCATOR = "//span[@class='rating__value']";
    private static final String TOP_BUTTON = ".//div[@class='top-button__inner']";

    public ProductListPanel(final WebElementFacade panelBaseLocation,final AbstractPage driverDelegate) {
        super(panelBaseLocation, driverDelegate);
    }

    public List<String> getListAtomicText() {
        return findAll(LIST_PRODUCTS_RESULT)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public List<SportCheckProducts> getRatingForAllSkin(){
        return findAll(RATING_SKIN_RESULT)
                .stream()
                .map(product -> {
                    Integer number= Integer.valueOf(product.findBy(RATING_VALUE_LOCATOR).waitUntilVisible()
                            .getAttribute("style")
                            .replaceAll("\\D",""));

                    return new SportCheckProducts(number);
                }).collect(Collectors.toList());
    }

    public List<String> getListTecnoProText() {
        return findAll(LIST_PRODUCTS_RESULT)
                .stream()
                .map(WebElementFacade::getText)
                .limit(50)
                .collect(Collectors.toList());
    }

    public List<String> getListAllProducts() {
        return findAll(LIST_PRODUCTS_RESULT)
                .stream()
                .map(WebElementFacade::getTextValue)
                .limit(50)
                .collect(Collectors.toList());
    }

    public void clickTopButton() {
        findBy(TOP_BUTTON).waitUntilClickable().click();
    }

    public void moveToTop() {
        JavascriptExecutor jsx = (JavascriptExecutor)getDriverDelegate().getDriver();
        jsx.executeScript("window.scrollBy(0,700)", "");
    }
}
