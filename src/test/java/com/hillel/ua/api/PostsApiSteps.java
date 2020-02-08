package com.hillel.ua.api;

import com.hillel.ua.api.dto.PostsDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

public class PostsApiSteps extends AbstractApiSteps {

    private static final String POSTS_API_PATH = "/posts";

    @Step
    public Response createNewPost(final PostsDTO postRequest) {
        return RestAssured.given()
                .contentType(ContentType.JSON)      //work with json
                .body(postRequest)        // автоматическое преобразование в json
                .post(POSTS_API_PATH);
    }

    @Step
    public void removePostById(final Integer postId) {
        RestAssured.delete(String.format("%s/%s", POSTS_API_PATH, postId));
    }

}
