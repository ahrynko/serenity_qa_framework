package com.hillel.ua.serenity.steps.cnn;

import com.hillel.ua.page_object.model.cnn.Article;
import com.hillel.ua.page_object.pages.cnn.CnnSearchPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class CnnSearchPageSteps extends ScenarioSteps {

    private CnnSearchPage cnnSearchPage;

    public CnnSearchPageSteps(final Pages pages) { //create page object
        this.cnnSearchPage = pages.getPage(CnnSearchPage.class); //pages - initialized page object
    }

    @Step
    public List<Article> getArticleItems() {
        return cnnSearchPage.getArticleItemsUsingStreamApi();
    }

    @Step
    public List<Article> parseCnnTextBlocks(final String htmlCode) {
        return cnnSearchPage.parseCnnTextBlocks(htmlCode);
    }
}