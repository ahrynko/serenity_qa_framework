package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.common.data.EnvironmentProperties;
import com.hillel.ua.logging.Logger;
import com.hillel.ua.serenity.steps.sportchek.SportcheckSortedAlpineSkiingSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

public class SportcheckSortedAlpineSkiingScenario {

    private Logger logger = new Logger();

    @Steps
    private SportcheckSortedAlpineSkiingSteps sportcheckSortedAlpineSkiingSteps;

    @Given("user opened 'Alpine Skiing Page'")
    public void openAlpineSkiingPage() {

        final String commonUrl = EnvironmentProperties.SPORTCHEK_BASE_URL.readProperty();
        sportcheckSortedAlpineSkiingSteps.openPageByPartialUrl(commonUrl);
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
}
