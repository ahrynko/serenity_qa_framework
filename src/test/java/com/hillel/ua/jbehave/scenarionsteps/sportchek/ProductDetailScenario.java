package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.serenity.steps.sportchek.ProductDetailSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class ProductDetailScenario {

    @Steps
    private ProductDetailSteps productDetailSteps;

    @When("user chooses (random) size")
    public void chooseRandomSize() {
        productDetailSteps.chooseRandomSize();

        final String expectedTitleItemText = productDetailSteps.getPageTitleText();
        final String expectedSizeItemText =  productDetailSteps.getRandomSizeText();
        Serenity.setSessionVariable("expected_title").to(expectedTitleItemText);
        Serenity.setSessionVariable("expected_size").to(expectedSizeItemText);
    }

    @When("user clicks 'Add To Cart' button")
    public void clickAddToCartButton() {
        productDetailSteps.clickAddToCartButton();
    }

}
