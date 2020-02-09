package com.hillel.ua.page_object.pages.sportchek;

import com.hillel.ua.common.data.PartialUrl;
import com.hillel.ua.page_object.pages.AbstractPage;
import com.hillel.ua.page_object.panels.sportchek.ProductDetailPanel;
import org.openqa.selenium.WebDriver;

@PartialUrl(value = "categories/kids/boys/shorts/product/columbia-boys-sandy-shores-boardshort-332695277.html#332695277%5Bcolor%5D=332695277_04")
public class ColumbiaBoysSandyShoresBoardshortPage extends AbstractPage {

    private static final String PRODUCT_DETAIL_PANEL = ".//div[@class='product-detail__background-wrapper']";


    public ColumbiaBoysSandyShoresBoardshortPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public ProductDetailPanel getProductDetailPanel() {
        return new ProductDetailPanel(find(PRODUCT_DETAIL_PANEL), this);
    }

}
