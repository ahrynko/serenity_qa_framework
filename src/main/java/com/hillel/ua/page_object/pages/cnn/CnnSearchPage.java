package com.hillel.ua.page_object.pages.cnn;

import com.hillel.ua.page_object.model.cnn.ArticleDTO;
import com.hillel.ua.page_object.pages.AbstractPage;
import net.serenitybdd.core.pages.WebElementFacade;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class CnnSearchPage extends AbstractPage {

    private WebDriver webDriver;

    private static final String LIST_SEARCH_RESULT = "//div[@class='cnn-search__result cnn-search__result--article' or (@class='cnn-search__result cnn-search__result--gallery') or (@class='cnn-search__result cnn-search__result--video')]";
    private static final String TITLE_ARTICLE = ".//div[@class='cnn-search__result-contents']/h3/a";
    private static final String BODY_ARTICLE = ".//div[@class='cnn-search__result-contents']/div[2]";

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

    public List<ArticleDTO> getArticleItemsUsingStreamApi(){
        return findAll(LIST_SEARCH_RESULT)
                .stream()
                .map(article -> {  // преобраз. одного сосотояния в другое
                    String title = article.find(By.xpath(TITLE_ARTICLE)).getText();
                    String body = article.find(By.xpath(BODY_ARTICLE)).getText();

                    return new ArticleDTO(title, body);
                }).collect(Collectors.toList());

    }

    public String getPageHtmlSourceCode() {
        return webDriver.getPageSource();  // возврат Html
    }

    public List<ArticleDTO> parseCnnPageSources(final String pageSources) {
        final Document cnnArticles = Jsoup.parse(pageSources);  // разпаршен Html в Document
        final Elements articleBlocks = cnnArticles.select("cnn-search__result cnn-search__result--article");  //10 (collection)
        return articleBlocks.stream()
                .map(articleBlock -> {  //переменная
                    final String title = articleBlock.selectFirst("h3 a[href]").text();
                    final String body = articleBlock.selectFirst(".cnn-search__result-body").text();
                    return new ArticleDTO(title, body);
                })
                .collect(Collectors.toList());
    }
}
