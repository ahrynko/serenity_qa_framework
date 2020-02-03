package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.common.helper.PropertyHelper;
import com.hillel.ua.logging.Logger;
import com.hillel.ua.serenity.steps.sportchek.SportcheckSortedAlpineSkiingSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import java.util.List;

public class SportcheckSortedAlpineSkiingScenario {

    private PropertyHelper propertyHelper = new PropertyHelper();
    private Logger logger = new Logger();

    @Steps
    private SportcheckSortedAlpineSkiingSteps sportcheckSortedAlpineSkiingSteps;

    @Given("user opened 'Alpine Skiing Page'")
    public void openAlpineSkiingPage() {
        final String commonUrl = propertyHelper.readProperty("sportchek.site.url");
        sportcheckSortedAlpineSkiingSteps.openPageByPartialUrl(commonUrl);
        logger.info(String.format("Opened following url '%s'",commonUrl));
    }

    @When("user clicks Sort By dropdown")
    public void clicksSortBy() {
        sportcheckSortedAlpineSkiingSteps.clicksSortBy();
    }

    @When("user clicks 'Rating High to Low' in SORT BY dropdown")
    public void chooseSortSelect() {
        sportcheckSortedAlpineSkiingSteps.clicksBySelect();
        logger.info("User clicks to 'Rating High to Low'");
    }

    @Then("products are sorted by the number of stars")
    public void orderByNumberStars() {
        sportcheckSortedAlpineSkiingSteps.getProducts();

    }
}
