package com.hillel.ua.page_object.pages.sportchek;

import com.hillel.ua.common.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import org.openqa.selenium.WebDriver;

@PartialUrl(value = "shopping-cart.html")
public class ShoppingCartPage extends AbstractPage {

    private static final String EMPTY_SHOPPING_CART_MESSAGE = "//div[@class='sc-product-list']/p";

    public ShoppingCartPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public String  getEmptyShoppingCartMessage() {
        return findBy(EMPTY_SHOPPING_CART_MESSAGE).getText();
    }
}
