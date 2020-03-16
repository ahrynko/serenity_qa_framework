package com.hillel.ua.serenity.steps.cnn;

import com.hillel.ua.page_object.pages.cnn.CnnMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class CnnMainPageSteps extends ScenarioSteps {

    private CnnMainPage cnnMainPage;

    public CnnMainPageSteps(final Pages pages) { //create page object
        this.cnnMainPage = pages.getPage(CnnMainPage.class); //pages - initialized page object
    }

    @Step
    public void openPageByUrl(final String commonUrl) {
        cnnMainPage.openUrl(commonUrl);
    }

}
