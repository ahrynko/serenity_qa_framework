package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.common.data.UrlBuilder;
import com.hillel.ua.page_object.model.sportchek.SportCheckProducts;
import com.hillel.ua.page_object.pages.sportchek.SportcheckAlpineSkiingPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.List;

public class SportcheckSortedAlpineSkiingSteps extends ScenarioSteps {

    private SportcheckAlpineSkiingPage sportcheckAlpineSkiingPage;

    public SportcheckSortedAlpineSkiingSteps(final Pages pages) {
        this.sportcheckAlpineSkiingPage = pages.getPage(SportcheckAlpineSkiingPage.class);
    }

    @Step
    public void openPageByPartialUrl(final String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl, SportcheckAlpineSkiingPage.class);
        sportcheckAlpineSkiingPage.openUrl(fullNavUrl);
    }

    @Step
    public void clicksSortBy() {
        sportcheckAlpineSkiingPage.clicksSortBy();
    }

    @Step
    public void clicksBySelect() {
        sportcheckAlpineSkiingPage.clicksBySelect();
    }

    @Step
    public void getProducts() {
        List<SportCheckProducts> sortedSportCheckItemsList = sportcheckAlpineSkiingPage.getSportCheckProducts();
        ReflectionAssert.assertReflectionEquals("There is incorrect sorting found! ",
                "unsorted", sortedSportCheckItemsList);
    }

}
