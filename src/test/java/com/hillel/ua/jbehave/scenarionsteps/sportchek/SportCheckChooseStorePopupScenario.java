package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.page_object.model.sportchek.ChooseStoreModel;
import com.hillel.ua.serenity.steps.sportchek.SportCheckChooseStorePopupSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.unitils.reflectionassert.ReflectionAssert;

public class SportCheckChooseStorePopupScenario {

    @Steps
    private SportCheckChooseStorePopupSteps sportCheckChooseStorePopupSteps;

    @When("user typed the one store, in modal input field: $store")
    public void chooseStore(final ExamplesTable store) {
       final ChooseStoreModel chooseStore = store.getRowsAs(ChooseStoreModel.class).get(0);
       sportCheckChooseStorePopupSteps.chooseYourStore(chooseStore);
    }

    @Then("following error displayed at modal choose input: '$error'")
    public void verifyChooseErrorsDisplayed(final String expectedError) {

       final String actualError = sportCheckChooseStorePopupSteps.getDisplayedError();

        ReflectionAssert.assertReflectionEquals("There are incorrect errors displayed!" ,
                expectedError, actualError);
    }

}
