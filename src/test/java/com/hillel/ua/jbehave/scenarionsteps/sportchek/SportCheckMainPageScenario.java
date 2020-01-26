package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.serenity.steps.sportchek.SportCheckMainPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;

public class SportCheckMainPageScenario {

    @Steps
    private SportCheckMainPageSteps sportCheckMainPageSteps;

    @Given("user opened page Sportcheck site using following url: '$url'")
    public void openSite(final String url) {
        sportCheckMainPageSteps.openPage(url);
    }
}
