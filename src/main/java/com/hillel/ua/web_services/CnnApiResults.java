package com.hillel.ua.web_services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hillel.ua.page_object.model.cnn.ArticleDTO;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CnnApiResults {

    @JsonProperty("result")  // with JSON - REST
    private List<ArticleDTO> results;

    public List<ArticleDTO> getResults() {
        return results;
    }
}
