package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.model.sportchek.ChooseStoreModel;
import com.hillel.ua.page_object.pages.sportchek.SportchekMainPage;
import com.hillel.ua.page_object.panels.sportchek.SportCheckChooseStorePopupPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportCheckChooseStorePopupSteps extends ScenarioSteps {

    private SportchekMainPage sportchekMainPage;

    public SportCheckChooseStorePopupSteps(final Pages pages) {
        this.sportchekMainPage = pages.getPage(SportchekMainPage.class);
    }

    @Step
    public void chooseYourStore(final ChooseStoreModel chooseStore) {
        final SportCheckChooseStorePopupPanel checkChooseStorePopupPanel = sportchekMainPage.getSportCheckChooseStorePopupPanel();

        checkChooseStorePopupPanel.typeStore(chooseStore.getStore());
    }

    @Step
    public String getDisplayedError() {
        return sportchekMainPage.getSportCheckChooseStorePopupPanel().getChooseStoreError();
    }
}
