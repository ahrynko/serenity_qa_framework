package com.hillel.ua.jbehave.scenarionsteps.cnn;

import com.hillel.ua.logging.Logger;
import com.hillel.ua.page_object.model.cnn.ArticleDTO;
import com.hillel.ua.serenity.steps.cnn.CnnSearchPageSteps;
import com.hillel.ua.web_services.RestTemplate;
import io.restassured.RestAssured;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.List;

public class CnnSearchPageScenario {

    @Steps
    private CnnSearchPageSteps cnnSearchPageSteps;

    @When("user retrieved items to list with site")
    public void retrievedItemList() {

        final List<ArticleDTO> expectedArticleList = cnnSearchPageSteps.getArticleItems();
        Serenity.setSessionVariable("expected_article_list").to(expectedArticleList);
    }

    @When("user executed Rest Request with the same word")
    public void getRestRequest() {

        RestTemplate restTemplate = new RestTemplate();
                                                                                   // refactor
        final List<ArticleDTO> actualArticleList = restTemplate.retrieveArticlesFromApi();
        Serenity.setSessionVariable("actual_article_list").to(actualArticleList);

    }

    @When("user retrieved all articles to list with site")
    public void retrievedAllArticles() {

        final List<ArticleDTO> expectedAllArticles = cnnSearchPageSteps.getAllArticles();
        Serenity.setSessionVariable("expected_all_articles").to(expectedAllArticles);
    }

    @When("user printed the text of each articles in the console with site")
    public void PrintArticlesTextBlocksSite() {

        final List<ArticleDTO> expectedAllArticles = Serenity.sessionVariableCalled("expected_all_articles");
        expectedAllArticles.forEach(articleSite -> Logger.out.info(String.format("** [Text Block Site Title] ** %s\n ** [Text Block Site Body] ** %s\n",
                articleSite.getTitle(), articleSite.getBody())));
    }

    @Then("compared two List with site and Rest Request")
    public void verifyCompareLists() {

        final List<ArticleDTO> expectedArticleList = Serenity.sessionVariableCalled("expected_article_list");
        final List<ArticleDTO> actualArticleList = Serenity.sessionVariableCalled("actual_article_list");

        ReflectionAssert.assertReflectionEquals("There is incorrect articles displayed!",  // refactor
                expectedArticleList , actualArticleList );

    }

    @Then("user parsed and printed the text of each article in the console with Jsoup library")
    public void parseAndPrintCnnTextBlocks() {

        RestAssured.baseURI = "https://edition.cnn.com";
        final String pageSources = RestAssured.get("/search?q=covid").asString();
        final List<ArticleDTO> actualAllArticles  = cnnSearchPageSteps.parseCnnPageSources(pageSources);

        actualAllArticles.forEach(article -> Logger.out.info(String.format("** [Text Block Title] ** %s\n ** [Text Block Body] ** %s\n",
                article.getTitle(), article.getBody())));

    }
}
