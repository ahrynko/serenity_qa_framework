package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.common.data.UrlBuilder;
import com.hillel.ua.page_object.pages.sportchek.ColumbiaBoysSandyShoresBoardshortPage;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class ColumbiaBoysSandyShoresBoardshortSteps extends ScenarioSteps {

    private ColumbiaBoysSandyShoresBoardshortPage columbiaBoysSandyShoresBoardshortPage;

    public ColumbiaBoysSandyShoresBoardshortSteps(final Pages pages) {
        this.columbiaBoysSandyShoresBoardshortPage = pages.getPage(ColumbiaBoysSandyShoresBoardshortPage.class); //create page object
    }

    public void openPageByPartialUrl(final String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl, ColumbiaBoysSandyShoresBoardshortPage.class);
        columbiaBoysSandyShoresBoardshortPage.openUrl(fullNavUrl);
    }
}
