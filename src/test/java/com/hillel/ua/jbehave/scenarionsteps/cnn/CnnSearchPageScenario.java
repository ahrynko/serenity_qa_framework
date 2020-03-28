package com.hillel.ua.jbehave.scenarionsteps.cnn;

import com.hillel.ua.logging.Logger;
import com.hillel.ua.page_object.model.cnn.ArticleDTO;
import com.hillel.ua.serenity.steps.cnn.CnnSearchPageSteps;
import com.hillel.ua.web_services.RestTemplate;
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

        final List<ArticleDTO> expectedArticleList = cnnSearchPageSteps.getArticleItems();  //refactor

        //перевести поле объекта в стринг
    /*    ArticleDTO aaa = actualArticleList.get(0);
                aaa.getTitle();*/

        /*actualArticleList.toString();  //ref
        actualArticleList.toArray();     //ref
        System.out.println(actualArticleList.toArray());  //ref
        System.out.println(actualArticleList.toString());  //ref*/

        Serenity.setSessionVariable("expected_article_list").to(expectedArticleList);

        /*Article firstExpected = actualArticleList.get(0);  // get 1 element
        System.out.println(firstExpected.getTitle());
        System.out.println(firstExpected.getBody());*/

    }

    @When("user executed Rest Request with the word '$animals'")
    public void getRestRequest(final String animals) {

        RestTemplate restTemplate = new RestTemplate();
                                                                                   // refactor
        final List<ArticleDTO> actualArticleList = restTemplate.retrieveArticlesFromApi();
        Serenity.setSessionVariable("actual_article_list").to(actualArticleList);

    }

    @Then("compared two List with site and Rest Request")
    public void verifyCompareLists() {

        final List<ArticleDTO> expectedArticleList = Serenity.sessionVariableCalled("expected_article_list"); //link to    //refactor
        final List<ArticleDTO> actualArticleList = Serenity.sessionVariableCalled("actual_article_list"); //link to    //refactor

        ReflectionAssert.assertReflectionEquals("There is incorrect articles displayed!",  // refactor
                expectedArticleList , actualArticleList );

    }

    @Then("user parsed and printed the text of each article in the console")
    public void parseAndPrintCnnTextBlocks() {

        final String pageSources = cnnSearchPageSteps.getPageHtmlSourceCode(); //получить Html

        final List<ArticleDTO> articles = cnnSearchPageSteps.parseCnnPageSources(pageSources);  //expected results

        articles.forEach(article -> Logger.out.info(String.format("** [Text Block] ** %s", article)));

    }
}
