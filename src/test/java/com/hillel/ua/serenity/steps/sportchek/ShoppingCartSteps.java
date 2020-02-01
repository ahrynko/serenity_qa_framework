package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.common.data.UrlBuilder;
import com.hillel.ua.page_object.pages.sportchek.ShoppingCartPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class ShoppingCartSteps extends ScenarioSteps {

    private ShoppingCartPage shoppingCartPage;

    public ShoppingCartSteps(final Pages pages) {
        this.shoppingCartPage = pages.getPage(ShoppingCartPage.class); //create page object
    }

    @Step
    public String getEmptyCartMessage() {
        return shoppingCartPage.getEmptyShoppingCartMessage();
    }

    @Step
    public void openPageByPartialUrl(final String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl, ShoppingCartPage.class);
        shoppingCartPage.openUrl(fullNavUrl);
    }

}
