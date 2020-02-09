package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.common.data.EnvironmentProperties;
import com.hillel.ua.serenity.steps.sportchek.ColumbiaBoysSandyShoresBoardshortSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.When;

public class ColumbiaBoysSandyShoresBoardshortScenario {

    @Steps
    private ColumbiaBoysSandyShoresBoardshortSteps columbiaBoysSandyShoresBoardshortSteps;

    @Given("user opened 'Columbia Boys' Sandy Shores Boardshort' by url: '$url'")
    public void openColumbiaBoysSandyShoresPage(final EnvironmentProperties environmentProperties) {

        final String commonUrl = environmentProperties.readProperty();
        columbiaBoysSandyShoresBoardshortSteps.openPageByPartialUrl(commonUrl);
    }

}
