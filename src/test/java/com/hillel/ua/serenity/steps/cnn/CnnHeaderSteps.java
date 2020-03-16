package com.hillel.ua.serenity.steps.cnn;

import com.hillel.ua.page_object.pages.cnn.CnnMainPage;
import com.hillel.ua.page_object.pages.cnn.CnnSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class CnnHeaderSteps extends ScenarioSteps {

    private CnnMainPage cnnMainPage;

    public CnnHeaderSteps(final Pages pages) { //create page object
        this.cnnMainPage = pages.getPage(CnnMainPage.class); //pages - initialized page object
    }

    @Step
    public void clickSearchButton() {
        cnnMainPage.getCnnHeaderPanel().clickSearchButton();
    }

    @Step
    public Class<CnnSearchPage> searchFor(final String item) {
        cnnMainPage.getCnnHeaderPanel().searchInput(item);
        return CnnSearchPage.class;
    }

}
