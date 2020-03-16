package com.hillel.ua.page_object.pages.cnn;

import com.hillel.ua.page_object.model.cnn.Article;
import com.hillel.ua.page_object.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class CnnSearchPage extends AbstractPage {

    private static final String LIST_SEARCH_RESULT = "//div[@class='cnn-search__result cnn-search__result--article']";
    private static final String TITLE_ARTICLE = ".//div[@class='cnn-search__result-contents']/h3/a";
    private static final String BODY_ARTICLE = ".//div[contains(text(),'China')]";


    public CnnSearchPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public List<String> getListAllProducts() {
        return findAll(LIST_SEARCH_RESULT)
                .stream()
                .map(WebElementFacade::getTextValue)
                .limit(20)
                .collect(Collectors.toList());
    }

    public List<Article> getArticleItemsUsingStreamApi(){
        return findAll(LIST_SEARCH_RESULT)
                .stream()
                .map(article -> {  // преобраз. одного сосотояния в другое
                    String title = article.findElement(By.xpath(TITLE_ARTICLE)).getText();
                    String body = article.findElement(By.xpath(BODY_ARTICLE)).getText();

                    return new Article(title, body);
                }).collect(Collectors.toList());

    }
}
