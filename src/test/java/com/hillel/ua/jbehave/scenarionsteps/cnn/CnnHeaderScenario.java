package com.hillel.ua.jbehave.scenarionsteps.cnn;

import com.hillel.ua.serenity.steps.cnn.CnnHeaderSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class CnnHeaderScenario {

    @Steps
    private CnnHeaderSteps cnnHeaderSteps;

    @When("user search the site for next item: '$item'")
    public void searchFor(final String item) {
        cnnHeaderSteps.clickSearchButton();
        cnnHeaderSteps.searchFor(item);
    }

}
