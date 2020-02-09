package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.pages.sportchek.ColumbiaBoysSandyShoresBoardshortPage;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class ProductDetailSteps extends ScenarioSteps {

    private ColumbiaBoysSandyShoresBoardshortPage columbiaBoysSandyShoresBoardshortPage;

    public ProductDetailSteps(final Pages pages) {
        this.columbiaBoysSandyShoresBoardshortPage = pages.getPage(ColumbiaBoysSandyShoresBoardshortPage.class);
    }

    public void chooseRandomSize() {
        columbiaBoysSandyShoresBoardshortPage.getProductDetailPanel().chooseSize();
    }

    public void clickAddToCartButton() {
        columbiaBoysSandyShoresBoardshortPage.getProductDetailPanel().clickAddToCartButton();
    }

    public String getRandomSizeText() {
        return columbiaBoysSandyShoresBoardshortPage.getProductDetailPanel().getRandomSizeText();
    }

    public String getPageTitleText() {
        return columbiaBoysSandyShoresBoardshortPage.getProductDetailPanel().getPageTitleText();
    }
}
