package com.hillel.ua.page_object.pages.sportchek;

import com.hillel.ua.common.data.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.sportchek.SportCheckProductsPanel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

@PartialUrl(value = "categories/shop-by-sport/alpine-skiing/ski-packages.html?lastVisibleProductNumber=22")
public class SportcheckAlpineSkiingPage extends AbstractPage {

    private static final String SORT_SELECT_LOCATOR = "(//select[@data-module-type='FormDropdown']/option)[5]";
    private static final String LIST_PRODUCTS = "//div[@class='product-grid__list-item-height']";

    private static final String SORT_BY_LOCATOR = "//div[@class='dropdown dropdown_ready dropdown_selected']";
    private static final String PRODUCT_lIST_PANEL = "//div[@class='product-listing__grid']";

    public SportcheckAlpineSkiingPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public void orderBy(String text){   //метод сортировки по тексту
      findBy(SORT_SELECT_LOCATOR).waitUntilVisible().getSelectedVisibleTextValue();
    }

    public void clicksSortBy() {
        scrollToTop();
        findBy(SORT_BY_LOCATOR).waitUntilClickable().click();
    }

    public void clicksBySelect() {
        findBy(SORT_SELECT_LOCATOR).waitUntilVisible().click();
    }

    public SportCheckProductsPanel getSportCheckProductsPanelpPanel() {//метод который отдаст модалку Popup
        return new SportCheckProductsPanel(findBy(PRODUCT_lIST_PANEL), this);
    }



    public List<String> getProducts(){
        return findAll(LIST_PRODUCTS)
                .stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }

}
