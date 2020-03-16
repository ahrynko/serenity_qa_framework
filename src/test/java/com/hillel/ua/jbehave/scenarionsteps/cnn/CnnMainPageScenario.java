package com.hillel.ua.jbehave.scenarionsteps.cnn;


import com.hillel.ua.serenity.steps.cnn.CnnMainPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class CnnMainPageScenario {

    @Steps
    private CnnMainPageSteps cnnMainPageSteps;

    @Given("user opened site '$url'")
    public void openCnnInternationalPage(final String url) {
        cnnMainPageSteps.openPageByUrl(url);
    }



    @Then("compared two List with site and Rest Request")
    public void verifyCompareLists() {

    }

}
