package com.hillel.ua.page_object.pages.weltrade;

import com.hillel.ua.common.data.PartialUrl;
import com.hillel.ua.page_object.model.weltrade.QuotesDTO;
import com.hillel.ua.page_object.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

@PartialUrl(value = "tools/quotes/")
public class WeltradeCurrencyQuotesPage extends AbstractPage {

    private static final String LIST_CURRENCY_QUOTES_RESULT = "(//div[@class='container'])[3]";
    private static final String QUOTES_PAIR = ".//div[@class='wt_quotes_table__pair']";
    private static final String QUOTES_BUY = ".//div[@class='wt-quotes-merge wt-quotes-bid']";
    private static final String QUOTES_SELL= ".//div[@class='wt-quotes-merge wt-quotes-ask']";


    public WeltradeCurrencyQuotesPage(final WebDriver webDriver) {
        super(webDriver);
    }


    public List<QuotesDTO> getArticleItemsUsingStreamApi() {
        return findAll(LIST_CURRENCY_QUOTES_RESULT)
                .stream()
                .map(quotes -> {  // преобраз. одного сосотояния в другое
                    String currency_pair = quotes.find(By.xpath(QUOTES_PAIR)).getText();
                    Double quotes_buy = Double.parseDouble(quotes.find(By.xpath(QUOTES_BUY)).getText());
                    Double quotes_sell = Double.parseDouble(quotes.find(By.xpath(QUOTES_SELL)).getText());

                    return new QuotesDTO(currency_pair, quotes_buy, quotes_sell);
                }).collect(Collectors.toList());
    }


}
