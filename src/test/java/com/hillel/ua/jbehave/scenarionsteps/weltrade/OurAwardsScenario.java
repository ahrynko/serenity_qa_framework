package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.common.data.EnvironmentProperties;
import com.hillel.ua.logging.Logger;
import com.hillel.ua.page_object.model.weltrade.AwardsModel;
import com.hillel.ua.serenity.steps.weltrade.OurAwardsSteps;
import io.restassured.RestAssured;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.List;

public class OurAwardsScenario {

    @Steps
    private OurAwardsSteps ourAwardsSteps;

    @Given("user opened 'Our Awards' by url: '$url'")
    public void openTradingCalculatorPage(final EnvironmentProperties environmentProperties) {

        final String commonUrl = environmentProperties.readProperty();
        ourAwardsSteps.openPageByPartialUrl(commonUrl);
    }

    @When("user retrieved all awards to list with site")
    public void retrievedAllAwards() {

        final List<AwardsModel> expectedAllAwards = ourAwardsSteps.getAllAwards();
        Serenity.setSessionVariable("expected_all_awards").to(expectedAllAwards);
    }


    @When("user parsed and printed the text of each award articles in the console with Jsoup library")
    public void parseAndPrintAwardsTextBlocks() {

        RestAssured.baseURI = "https://www.weltrade.com";
        final String pageSources = RestAssured.get("/company/awards").asString();
        final List<AwardsModel> actualAllAwards = ourAwardsSteps.parseOurAwardsPageSources(pageSources);
        Serenity.setSessionVariable("actual_all_awards").to(actualAllAwards);

        actualAllAwards.forEach(award -> Logger.out.info(String.format("** [Text Block Title] ** %s\n ** [Text Block Body] ** %s\n",
                award.getTitle(), award.getBody())));

    }

    @When("user printed the text of each award articles in the console with site")
    public void PrintAwardsTextBlocksSite() {

        final List<AwardsModel> expectedAllAwards = Serenity.sessionVariableCalled("expected_all_awards");
        expectedAllAwards.forEach(awardsModel -> Logger.out.info(String.format("** [Text Block Title] ** %s\n ** [Text Block Body] ** %s\n",
                awardsModel.getTitle(), awardsModel.getBody())));
    }


    @Then("user compared two List with site and with Jsoup library")
    public void verifyCompareLists() {

        final List<AwardsModel> expectedAllAwards = Serenity.sessionVariableCalled("expected_all_awards");
        final List<AwardsModel> actualAllAwards = Serenity.sessionVariableCalled("actual_all_awards");

        ReflectionAssert.assertReflectionEquals("There is incorrect awards articles displayed!",
                expectedAllAwards , actualAllAwards );

        Logger.out.info(expectedAllAwards.equals(actualAllAwards));

    }
}
