package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.common.data.UrlBuilder;
import com.hillel.ua.page_object.model.weltrade.AwardsModel;
import com.hillel.ua.page_object.pages.weltrade.WeltradeOurAwardsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class OurAwardsSteps extends ScenarioSteps {

    private WeltradeOurAwardsPage weltradeOurAwardsPage;

    public OurAwardsSteps(final Pages pages) {
        this.weltradeOurAwardsPage = pages.getPage(WeltradeOurAwardsPage.class);
    }

    public void openPageByPartialUrl(final String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl, WeltradeOurAwardsPage.class);
        weltradeOurAwardsPage.openUrl(fullNavUrl);
    }

    @Step
    public List<AwardsModel> parseOurAwardsPageSources(final String pageSources) {
        return weltradeOurAwardsPage.parseOurAwardsPageSources(pageSources);
    }

    @Step
    public List<AwardsModel> getAllAwards() {
        return weltradeOurAwardsPage.getAllAwardsUsingStreamApi();

    }
}
