package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.serenity.steps.sportchek.ProductDetailSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class ProductDetailScenario {

    @Steps
    private ProductDetailSteps productDetailSteps;

    @When("user chooses (random) size")
    public void chooseRandomSize() {
        productDetailSteps.chooseRandomSize();
    }

    @When("user clicks 'Add To Cart' button")
    public void clickAddToCartButton() {
        productDetailSteps.clickAddToCartButton();

    }

}
