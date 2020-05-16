package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.common.data.UrlBuilder;
import com.hillel.ua.page_object.model.weltrade.QuotesDTO;
import com.hillel.ua.page_object.pages.weltrade.WeltradeCurrencyQuotesPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class CurrencyQuotesSteps extends ScenarioSteps {

    private WeltradeCurrencyQuotesPage weltradeCurrencyQuotesPage;

    public CurrencyQuotesSteps (final Pages pages) {
        this.weltradeCurrencyQuotesPage = pages.getPage(WeltradeCurrencyQuotesPage.class);
    }

    @Step
    public void openPageByPartialUrl(final String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl, WeltradeCurrencyQuotesPage.class);
        weltradeCurrencyQuotesPage.openUrl(fullNavUrl);
    }

    @Step
    public List<QuotesDTO> getQuotesItems() {
        return weltradeCurrencyQuotesPage.getArticleItemsUsingStreamApi();
    }
}
