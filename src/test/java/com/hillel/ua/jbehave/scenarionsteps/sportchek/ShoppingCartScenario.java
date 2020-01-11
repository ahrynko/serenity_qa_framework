package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.serenity.steps.sportchek.HeaderPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.SportCheckMainPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class ShoppingCartScenario {

    @Steps
    private SportCheckMainPageSteps sportCheckMainPageSteps;

    @Steps
    private HeaderPanelSteps headerPanelSteps;

    @Given("user opened site, using next url: '$url'")
    public void openSite(final String url) {
        sportCheckMainPageSteps.openPage(url);
    }

    @When("user moved the mouse to shopping cart")
    public void navigateToShoppingCart() {
        headerPanelSteps.movedToMouse();
    }

    @Then("following the shopping cart message is displayed: '$message'")
    public void verifyShoppingCartMessage(final String expectedShoppingCartMessage) {

        final String actualShoppingCartMessage = headerPanelSteps.retrieveCartMessage();

        Assert.assertEquals("There is incorrect shopping cart message displayed!",
                expectedShoppingCartMessage,actualShoppingCartMessage);
    }
}
