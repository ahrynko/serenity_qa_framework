package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.serenity.steps.sportchek.FilterBySteps;
import com.hillel.ua.serenity.steps.sportchek.ProductListSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.List;

public class FilterByScenario {

    @Steps
    private FilterBySteps filterBySteps;

    @Steps
    private ProductListSteps productListSteps;

    @When("user chooses 'ATOMIC' brand at the product list")
    public void chooseAtomic() {
        filterBySteps.chooseAtomic();
    }

    @When("user chooses 'TECNO PRO' filter brand at the product list")
    public void chooseTecnoPro() {

        productListSteps.clickTopButton();

        final List<String> expectedListProducts = productListSteps.getListAllProducts();
        Serenity.setSessionVariable("expected_filters_before_reset").to(expectedListProducts);

        filterBySteps.chooseTecnoPro();
    }

    @Then("user clicks on the 'Clear All' button")
    public void clickClearAllButton() {

        filterBySteps.clickClearAllButton();
        productListSteps.moveToTop();

        final List<String> actualListProducts = productListSteps.getListAllProducts();
        Serenity.setSessionVariable("actual_filters_after_reset").to(actualListProducts);
    }
}
