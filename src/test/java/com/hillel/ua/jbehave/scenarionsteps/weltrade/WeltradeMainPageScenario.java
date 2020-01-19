package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.page_object.pages.weltrade.WeltradeSignInPage;
import com.hillel.ua.serenity.steps.weltrade.WeltradeMainPageSteps;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

public class WeltradeMainPageScenario {

    @Steps
    private WeltradeMainPageSteps weltradeMainPageSteps;

    @Given("user opened Weltrade site, by following url: '$url'")
    public void openSite(final String url) {
        weltradeMainPageSteps.openPageByUrl(url);
    }

}
