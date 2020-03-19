package com.hillel.ua.jbehave.scenarionsteps.cnn;

import com.hillel.ua.logging.Logger;
import com.hillel.ua.page_object.model.cnn.Article;
import com.hillel.ua.serenity.steps.cnn.CnnSearchPageSteps;
import io.restassured.RestAssured;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import java.util.List;

public class CnnSearchPageScenario {

    @Steps
    private CnnSearchPageSteps cnnSearchPageSteps;

    @When("user retrieved items to list with site")
    public void retrievedItemList() {

        final List<Article> actualArticleList = cnnSearchPageSteps.getArticleItems();

        //перевести поле объекта в стринг
        Article  aaa = actualArticleList.get(0);
                aaa.getTitle();

        /*actualArticleList.toString();  //ref
        actualArticleList.toArray();     //ref
        System.out.println(actualArticleList.toArray());  //ref
        System.out.println(actualArticleList.toString());  //ref*/

        Serenity.setSessionVariable("actual_article_list").to(actualArticleList);

        /*Article firstExpected = actualArticleList.get(0);  // get 1 element
        System.out.println(firstExpected.getTitle());
        System.out.println(firstExpected.getBody());*/

    }

    @When("user executed Rest Request with the word '$animals'")
    public void getRestRequest(final String animals) {

        final List<Article> expectedArticleList = Serenity.sessionVariableCalled("actual_article_list"); //link to    //refactor

        RestAssured.baseURI = "https://edition.cnn.com";
        final String ccnHtmlCode = RestAssured.get("/search?size=10&q=China").asString();

//        final List<Article> articleList = cnnSearchPageSteps.parseCnnTextBlocks(ccnHtmlCode);

//        Serenity.setSessionVariable("actual_article_list").to(articleList);

//        articleList.forEach(line -> Logger.out.info(String.format("** [Text Block] ** %s", line)));
    }

    @Then("compared two List with site and Rest Request")
    public void verifyCompareLists() {



    }

}
