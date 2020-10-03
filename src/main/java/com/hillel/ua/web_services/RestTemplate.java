package com.hillel.ua.web_services;

import com.hillel.ua.page_object.model.cnn.ArticleDTO;
import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import java.util.List;


public class RestTemplate {

    private static final String SEARCH_ENDPOINT = "/content";

    public RestTemplate() {
        RestAssured.config = RestAssured.config().sslConfig(new SSLConfig().relaxedHTTPSValidation());
        RestAssured.baseURI = "https://search.api.cnn.io";   //?size=10&q=China
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public List<ArticleDTO> retrieveArticlesFromApi() {  //actual results

//        final Map<String, String> queryParams = new HashMap<>();
//        queryParams.put("size", "10");
//        queryParams.put("q", "China");
        // GET >> получили response  и распарсили в объект CnnApiResults
        final CnnApiResults response = RestAssured.given()
                .contentType(ContentType.JSON)
                .queryParam("size", "10")
                .queryParam("q", "China")
                .get(SEARCH_ENDPOINT).as(CnnApiResults.class);
        return response.getResults();

    }

}
