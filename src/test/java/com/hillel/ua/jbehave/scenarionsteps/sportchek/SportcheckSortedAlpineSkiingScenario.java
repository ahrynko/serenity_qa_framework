package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.serenity.steps.sportchek.SportcheckSortedAlpineSkiingSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.List;

public class SportcheckSortedAlpineSkiingScenario {

    @Steps
    private SportcheckSortedAlpineSkiingSteps sportcheckSortedAlpineSkiingSteps;

    @Given("user opened Sportcheck site using following url: '$url'")
    public void openAlpineSkiingPage(final String url) {
        sportcheckSortedAlpineSkiingSteps.openPageByUrl(url);
    }

    @When("user chooses 'Rating High to Low' in dropdown SORT BY")
    public void chooseSortSelect(final String text) {
        sportcheckSortedAlpineSkiingSteps.orderBySelect("Rating High to Low");
    }

    @When("user chooses 'ATOMIC' brand at the product list")
    public void chooseAtomic() {
        sportcheckSortedAlpineSkiingSteps.chooseAtomic();
    }

    @Then("products are sorted by the number of stars")
    public void orderByNumberStars() {
        sportcheckSortedAlpineSkiingSteps.getProducts();

    }

    @Then("products are only displayed with this brand: '$ATOMIC'")
    public void retrievedItemList(final List<String> expectedSearchList) {

    }
}
