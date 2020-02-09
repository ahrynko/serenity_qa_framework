package com.hillel.ua.page_object.pages.sportchek;

import com.hillel.ua.common.data.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.sportchek.ShoppingCartPanel;
import org.openqa.selenium.WebDriver;

@PartialUrl(value = "shopping-cart.html")
public class ShoppingCartPage extends AbstractPage {

    private static final String EMPTY_SHOPPING_CART_MESSAGE = "//div[@class='sc-product-list']/p";
    private static final String SHOPPING_CART_PANEL = ".//div[@class='sc-product-list']";


    public ShoppingCartPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public ShoppingCartPanel getShoppingCartPanel() {
        return new ShoppingCartPanel(find(SHOPPING_CART_PANEL), this);
    }

    public String  getEmptyShoppingCartMessage() {
        return findBy(EMPTY_SHOPPING_CART_MESSAGE).getText();
    }

}
