package com.hillel.ua.page_object.pages.sportchek;

import com.hillel.ua.common.data.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.sportchek.FilterByPanel;
import com.hillel.ua.page_object.panels.sportchek.ProductListPanel;
import org.openqa.selenium.WebDriver;

@PartialUrl(value = "categories/shop-by-sport/alpine-skiing/ski-packages.html?lastVisibleProductNumber=22")
public class SportcheckAlpineSkiingPage extends AbstractPage {

    private static final String SORT_SELECT_LOCATOR = "(//select[@data-module-type='FormDropdown']/option)[5]";
    private static final String SORT_BY_LOCATOR = "//div[@class='dropdown dropdown_ready dropdown_selected']";

    private static final String PRODUCT_lIST_PANEL = ".//div[@class='product-listing__grid']";
    private static final String FILTER_BY_PANEL = ".//div[@class='product-listing__facets']";


    public SportcheckAlpineSkiingPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public FilterByPanel getFilterByPanel() {
        return new FilterByPanel(findBy(FILTER_BY_PANEL), this);
    }

    public ProductListPanel getProductListPanel() {
        return new ProductListPanel(findBy(PRODUCT_lIST_PANEL), this);
    }

    public void clicksSortBy() {
        scrollToTop();
        findBy(SORT_BY_LOCATOR).waitUntilClickable().click();
    }

    public void clicksBySelect() {
        findBy(SORT_SELECT_LOCATOR).waitUntilVisible().click();
    }
}
