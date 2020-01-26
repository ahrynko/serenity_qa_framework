package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.serenity.steps.sportchek.HeaderPanelSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class SportCheckHeaderScenario {

    @Steps
    private HeaderPanelSteps headerPanelSteps;

    @When("user clicks 'Sign In' button")
    public void clickSignInButton() {
        headerPanelSteps.openSignInPopup();
    }

    @When("user clicks 'Choose store now' button")
    public void clickChooseStoreNowButton() {
        headerPanelSteps.openChooseStorePopup();
    }
}
