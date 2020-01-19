package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.serenity.steps.weltrade.WeltradeCabinetSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;

public class WeltradeCabinetScenario {

    @Steps
    private WeltradeCabinetSteps weltradeCabinetSteps;

    @Then("user retrieved Weltrade site title")
    public void retrieveWeltradeSiteTitle() {
        final String actualTitle = weltradeCabinetSteps.getCurrentWeltradeTitle();
        Serenity.setSessionVariable("actual_title").to(actualTitle);
    }

    @Then("retrieved Weltrade site title value should be: '$expectedTitle'")
    public void verifyWeltradeSiteTitle (final String expectedTitle) {
       final Serenity savedWeltradeTitle = Serenity.sessionVariableCalled("actual_title");
        Assert.assertEquals("There is incorrect title displayed!",
                expectedTitle, savedWeltradeTitle);
    }

}
