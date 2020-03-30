package com.hillel.ua.web_services;

import com.hillel.ua.page_object.model.cnn.ArticleDTO;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestTemplate {

    private static final String SEARCH_ENDPOINT = "/content";

    public RestTemplate() {
        RestAssured.baseURI = "https://search.api.cnn.io";   //?size=10&q=China
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public List<ArticleDTO> retrieveArticlesFromApi() {  //actual results

        final Map<String, String> queryParams = new HashMap<>();
        queryParams.put("size", "10");
        queryParams.put("q", "China");
        // GET >> получили response  и распарсили в объект CnnApiResults
        final CnnApiResults response = RestAssured.get(SEARCH_ENDPOINT, queryParams).as(CnnApiResults.class);  //given().accept(ContentType.JSON)  //refactor .get
        return response.getResults();

    }

}
