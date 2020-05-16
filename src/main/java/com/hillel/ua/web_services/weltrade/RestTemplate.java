package com.hillel.ua.web_services.weltrade;

import com.hillel.ua.page_object.model.weltrade.QuotesDTO;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.util.List;

public class RestTemplate {

    private static final String SEARCH_ENDPOINT = "/export/quotes.json";

    public RestTemplate() {
        RestAssured.baseURI = "https://quotes.weltrade.com";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public List<QuotesDTO> retrieveQuotesFromApi() { //actual results

        final QuotesApiResults response =  RestAssured.get(SEARCH_ENDPOINT).as(QuotesApiResults.class); // refactor get
        return response.getResults();
    }

}
