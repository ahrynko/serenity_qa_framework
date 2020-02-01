package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.common.helper.PropertyHelper;
import com.hillel.ua.page_object.model.sportchek.SportCheckProducts;
import com.hillel.ua.serenity.steps.sportchek.SportcheckSortedAlpineSkiingSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import java.util.List;

public class SportcheckSortedAlpineSkiingScenario {

    private PropertyHelper propertyHelper = new PropertyHelper();

    @Steps
    private SportcheckSortedAlpineSkiingSteps sportcheckSortedAlpineSkiingSteps;

    @Given("user opened 'Alpine Skiing Page'")
    public void openAlpineSkiingPage() {
        final String commonUrl = propertyHelper.readProperty("sportchek.site.url");
        sportcheckSortedAlpineSkiingSteps.openPageByPartialUrl(commonUrl);
    }

    @When("user clicks Sort By dropdown")
    public void clicksSortBy() {
        sportcheckSortedAlpineSkiingSteps.clicksSortBy();
    }

    @When("user clicks 'Rating High to Low' in SORT BY dropdown")
    public void chooseSortSelect() {
        sportcheckSortedAlpineSkiingSteps.clicksBySelect();
    }

//    @When("user chooses 'ATOMIC' brand at the product list")
//    public void chooseAtomic() {
//        sportcheckSortedAlpineSkiingSteps.chooseAtomic();
//    }

    @Then("products are sorted by the number of stars")
    public void orderByNumberStars() {
        sportcheckSortedAlpineSkiingSteps.getProducts();

    }

    @Then("products are only displayed with this brand: '$ATOMIC'")
    public void retrievedItemList(final List<String> expectedSearchList) {

    }
}
