package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.serenity.steps.sportchek.FilterBySteps;
import com.hillel.ua.serenity.steps.sportchek.SportcheckSortedAlpineSkiingSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class FilterByScenario {

    @Steps
    private FilterBySteps filterBySteps;

    @When("user chooses 'ATOMIC' brand at the product list")
    public void chooseAtomic() {
        filterBySteps.chooseAtomic();
    }
}
