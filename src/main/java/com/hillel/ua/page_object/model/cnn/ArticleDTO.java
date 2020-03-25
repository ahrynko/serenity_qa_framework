package com.hillel.ua.page_object.model.cnn;

import lombok.AllArgsConstructor;
import lombok.Getter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)  // скипать все поля кроме (title/body)
public class ArticleDTO {

    @JsonProperty("headline")  // with JSON - REST
    private String title;

    @JsonProperty("body")
    private String body;

/*
    public ArticleDTO(final String title, final String body) { //перечача через конструктор, что-бы не вызывать сеттеры
        this.title = title;
        this.body = body;
    }
*/

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }
}
