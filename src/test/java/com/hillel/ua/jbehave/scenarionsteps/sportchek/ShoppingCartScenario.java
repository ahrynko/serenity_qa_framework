package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.common.data.EnvironmentProperties;
import com.hillel.ua.serenity.steps.sportchek.HeaderPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.ShoppingCartSteps;
import com.hillel.ua.serenity.steps.sportchek.SportCheckMainPageSteps;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class ShoppingCartScenario {

    @Steps
    private SportCheckMainPageSteps sportCheckMainPageSteps;

    @Steps
    private HeaderPanelSteps headerPanelSteps;

    @Steps
    private ShoppingCartSteps shoppingCartSteps;

    @Given("user opened site, using next url: '$url'")
    public void openSite(final String url) {
        sportCheckMainPageSteps.openPage(url);
    }

    @Given("user opened 'Shopping Cart Page' by url: '$url'")
    public void openShoppingCartPage(final EnvironmentProperties environmentProperties) {

        final String commonUrl = environmentProperties.readProperty();
        shoppingCartSteps.openPageByPartialUrl(commonUrl);
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

    @Then("following empty cart message displayed: '$message'")
    public void verifyEmptyCartMessage(final String emptyCartMessage) {

        final String actualEmptyCartMessage = shoppingCartSteps.getEmptyCartMessage();

        Assertions.assertThat(actualEmptyCartMessage) // title with site
                .as("There is incorrect empty Shopping Cart message displayed!")
                .isEqualTo(emptyCartMessage);  // we expect see
    }

    @Then("the product your added is in the shopping cart")
    public void verifyAddToShoppingCart () {

    }
}
