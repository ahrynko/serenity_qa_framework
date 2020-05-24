package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.page_object.model.weltrade.ChooseCityModel;
import com.hillel.ua.page_object.pages.weltrade.CabinetSettingsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class CabinetSettingsSteps extends ScenarioSteps {

    private CabinetSettingsPage cabinetSettingsPage;

    public CabinetSettingsSteps(final Pages pages) {
        this.cabinetSettingsPage = pages.getPage(CabinetSettingsPage.class);
    }

    @Step
    public void enterTextToInputCity() {
        cabinetSettingsPage.changeRandomCity();
    }

    @Step
    public void clickSaveButton() {
        cabinetSettingsPage.clickSaveButton();
    }

    @Step
    public String getSuccessToast() {
        return cabinetSettingsPage.getSuccessToast();
    }

    @Step
    public void searchCityErrorMessage(final String symbols) {
        cabinetSettingsPage.searchCityText(symbols);
    }

    @Step
    public String errorMessageCity() {
        return cabinetSettingsPage.retrieveErrorMessageCity();
    }

    @Step
    public void clickPersonalDataNav() {
        cabinetSettingsPage.clickPersonalDataNav();
    }

    @Step
    public void chooseCity(final ChooseCityModel cityModel) {
        cabinetSettingsPage.typeCity(cityModel.getCity());
    }

    @Step
    public boolean isAttributePresent() {
        return cabinetSettingsPage.isAttributePresent();
    }

    @Step
    public void enterSpacesToCity(final ChooseCityModel cityModel) {
        cabinetSettingsPage.enterSpacesToCity(cityModel.getCity());
    }
}
