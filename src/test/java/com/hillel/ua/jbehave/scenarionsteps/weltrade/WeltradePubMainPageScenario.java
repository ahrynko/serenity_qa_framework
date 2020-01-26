package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.serenity.steps.weltrade.WeltradePubMainPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;

public class WeltradePubMainPageScenario {

    @Steps
    private WeltradePubMainPageSteps weltradePubMainPageSteps;

    @Given("user opened Weltrade site, by following url: '$url'")
    public void openSite(final String url) {
        weltradePubMainPageSteps.openPageByUrl(url);
    }

}
