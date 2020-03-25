package com.hillel.ua.web_services;

import com.hillel.ua.page_object.model.cnn.ArticleDTO;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestTemplate {

    private static final String SERCH_ENDPOINT = "/content";

    public RestTemplate() {
        RestAssured.baseURI = "https://search.api.cnn.io";
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public List<ArticleDTO> retrieveArticlesFromApi() {  //actual results

        final Map<String, String> queryParams = new HashMap<>();
        queryParams.put("q", "China");
        queryParams.put("size", "10");
        // GET >> получили response  и распарсили в объект CnnApiResults
        final CnnApiResults response = RestAssured.get(SERCH_ENDPOINT, queryParams).as(CnnApiResults.class);  //given().accept(ContentType.JSON)
        return response.getResults();

    }

}
