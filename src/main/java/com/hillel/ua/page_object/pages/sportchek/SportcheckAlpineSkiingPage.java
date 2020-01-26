package com.hillel.ua.page_object.pages.sportchek;

import com.hillel.ua.page_object.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.stream.Collectors;

public class SportcheckAlpineSkiingPage extends AbstractPage {

    private static final String SORT_SELECT_LOCATOR = ".//select[@data-module-type='FormDropdown']";
    private static final String LIST_PRODUCTS = ".//div[@class='product-grid__list-item-height']";

    public SportcheckAlpineSkiingPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public void orderBy(String text){   //метод сортировки по тексту
      findBy(SORT_SELECT_LOCATOR).waitUntilVisible().getSelectedVisibleTextValue();
    }

    public List<String> getProducts(){
        return findAll(LIST_PRODUCTS)
                .stream()
                .map(item -> item.getText())
                .collect(Collectors.toList());
    }
}
