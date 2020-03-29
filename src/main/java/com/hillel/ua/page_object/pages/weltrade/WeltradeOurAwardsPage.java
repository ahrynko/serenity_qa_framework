package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.common.data.PartialUrl;
import com.hillel.ua.page_object.model.weltrade.AwardsModel;
import com.hillel.ua.page_object.pages.AbstractPage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

@PartialUrl(value = "company/awards")
public class WeltradeOurAwardsPage extends AbstractPage {

    private static final String AWARDS_CONTENT_LIST = "//div[@class='awards-list-item']";
    private static final String TITLE_AWARDS = ".//h4[@class='wt_award_name_title']";
    private static final String BODY_AWARDS = ".//div[@class='awards-item-text col-md-9']/div/p";

    public WeltradeOurAwardsPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public List<AwardsModel> parseOurAwardsPageSources(final String pageSources) {
        final Document ourAwards = Jsoup.parse(pageSources);  // разпаршен Html в Document
        final Elements articleBlocks = ourAwards.select(".awards-list-item");  //(collection)
        return articleBlocks.stream()
                .map(articleBlock -> {  //переменная
                    final String title = articleBlock.selectFirst(".wt_award_name_title").text();
                    final String body = articleBlock.selectFirst(".wt_award_text > p").text();
                    return new AwardsModel(title, body);
                })
                .collect(Collectors.toList());
    }

    public List<AwardsModel> getAllAwardsUsingStreamApi(){
        return findAll(AWARDS_CONTENT_LIST)
                .stream()
                .map(article -> {  // преобраз. одного сосотояния в другое
                    String title = article.find(By.xpath(TITLE_AWARDS)).getText();
                    String body = article.find(By.xpath(BODY_AWARDS)).getText();

                    return new AwardsModel(title, body);
                }).collect(Collectors.toList());

    }
}
