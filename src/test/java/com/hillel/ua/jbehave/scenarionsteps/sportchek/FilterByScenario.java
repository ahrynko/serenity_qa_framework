package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.serenity.steps.sportchek.FilterBySteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FilterByScenario {

    @Steps
    private FilterBySteps filterBySteps;

    @When("user chooses 'ATOMIC' brand at the product list")
    public void chooseAtomic() {
        filterBySteps.chooseAtomic();
    }

    @When("user chooses 'TECNO PRO' filter brand at the product list")
    public void chooseTecnoPro() {
        filterBySteps.chooseTecnoPro();
    }

    @Then("user clicks on the 'Clear All' button")
    public void clickClearAllButton() {
        filterBySteps.clickClearAllButton();
    }
}
