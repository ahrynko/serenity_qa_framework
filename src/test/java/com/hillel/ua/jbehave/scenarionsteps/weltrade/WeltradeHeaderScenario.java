package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.serenity.steps.weltrade.WeltradeHeaderSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;

public class WeltradeHeaderScenario {

    @Steps
    private WeltradeHeaderSteps weltradeHeaderSteps;

    @When("user clicks 'Login' button")
    public void clickLoginButton() {
        weltradeHeaderSteps.openSignInPage();
    }
}
