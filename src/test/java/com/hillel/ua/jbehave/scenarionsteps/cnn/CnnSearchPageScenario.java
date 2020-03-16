package com.hillel.ua.jbehave.scenarionsteps.cnn;

import com.hillel.ua.page_object.model.cnn.Article;
import com.hillel.ua.serenity.steps.cnn.CnnSearchPageSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.When;
import java.util.List;

public class CnnSearchPageScenario {

    @Steps
    private CnnSearchPageSteps cnnSearchPageSteps;

    @When("user retrieved items to list with site")
    public void retrievedItemList() {

        final List<Article> actualArticleList = cnnSearchPageSteps.getArticleItems();
        Serenity.setSessionVariable("actual_article_list").to(actualArticleList);
    }

    @When("user executed Rest Request with the word '$animals'")
    public void getRestRequest(final String animals) {

        final List<Article> expectedArticleList = Serenity.sessionVariableCalled("actual_article_list"); //link to object
        System.out.println(expectedArticleList);
    }

}
