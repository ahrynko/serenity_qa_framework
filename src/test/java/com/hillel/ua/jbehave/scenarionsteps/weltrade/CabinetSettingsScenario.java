package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.page_object.model.weltrade.ChooseCityModel;
import com.hillel.ua.serenity.steps.weltrade.CabinetSettingsSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.junit.Assert;
import org.unitils.reflectionassert.ReflectionAssert;

public class CabinetSettingsScenario {

    @Steps
    private CabinetSettingsSteps cabinetSettingsSteps;

    @When("user changed the city random")
    public void enterTextToInputCity() {
        cabinetSettingsSteps.enterTextToInputCity();
        cabinetSettingsSteps.clickSaveButton();
    }

    @When("user typed several character in city input field: '$symbols'")
    public void enterTextToInputField(final String symbols) {
        cabinetSettingsSteps.searchCityErrorMessage(symbols);
        cabinetSettingsSteps.clickPersonalDataNav();
    }

    @When("user typed 51 characters in city input field: $city")
    public void chooseCity(final ExamplesTable city) {
        final ChooseCityModel cityModel = city.getRowsAs(ChooseCityModel.class).get(0);  //ChooseCityModel
        cabinetSettingsSteps.chooseCity(cityModel);
    }

    @Then("following success toast displayed: '$toast'")
    public void verifySuccessToast(final String toast) {

        final String actualToast = cabinetSettingsSteps.getSuccessToast();
        final String city = Serenity.sessionVariableCalled("random_city");

        Assertions.assertThat(actualToast) // toast with site
                .as("There is incorrect success toast displayed!")
                .isEqualTo(toast);  // we expect see
    }

    @Then("following message is displayed in City input field: '$message'")
    public void isErrorMessageCity(final String expectedErrorMessageCity) {
        final String actualErrorMessageCity = cabinetSettingsSteps.errorMessageCity();

        ReflectionAssert.assertReflectionEquals("There is incorrect error message city displayed!",
                expectedErrorMessageCity, actualErrorMessageCity);
    }

    @Then("the 'Save' button is inactive")
    public void isAttributePresent() {
       boolean check =  cabinetSettingsSteps.isAttributePresent();

        Assert.assertTrue("The 'Save' button is active", check);
    }

    @Then("the 'Save' button is inactive with the introduction of spaces: $spaces")
    public void enterSpacesToCity(final ExamplesTable city) {
        final ChooseCityModel cityModel = city.getRowsAs(ChooseCityModel.class).get(0);  //ChooseCityModel
        cabinetSettingsSteps.enterSpacesToCity(cityModel);
        boolean check =  cabinetSettingsSteps.isAttributePresent();

        Assert.assertTrue("The 'Save' button is active", check);
    }
}
