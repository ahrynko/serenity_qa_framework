package com.hillel.ua.page_object.model.weltrade;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class QuotesDTO {

    private String currency_pair;
    private Double quotes_buy;
    private Double quotes_sell;

    public String getCurrencyPair() {
        return currency_pair;
    }

    public Double getQuotesBuy() {
        return quotes_buy;
    }

    public Double getQuotesSell() {
        return quotes_sell;
    }

}
