package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.logging.Logger;
import com.hillel.ua.serenity.steps.weltrade.WeltradePubMainPageSteps;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;

public class WeltradePubMainPageScenario {

    @Steps
    private WeltradePubMainPageSteps weltradePubMainPageSteps;

    @Given("user opened Weltrade site, by following url: '$url'")
    public void openSite(final String url) {
        weltradePubMainPageSteps.openPageByUrl(url);
    }

    @Then("following current Url Page displayed: '$url'")
    public void isCurrentUrl(final String expectedUrl) {
        final String actualUrl = weltradePubMainPageSteps.getCurrentUrl();

        Assertions.assertThat(actualUrl) //url with site
                .as("There is incorrect current url displayed!")
                .isEqualTo(expectedUrl);

        Logger.out.info("There is current public url with site : " + actualUrl);
        Logger.out.info("There is current public url with story : " + expectedUrl);
    }

}
