package com.hillel.ua.api;

import com.hillel.ua.api.dto.CommentsDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import static java.lang.String.format;

public class CommentsApiSteps extends AbstractApiSteps {

    private static final String POSTS_API_PATH = "/comments";

    @Step
    public Response createNewPost(final CommentsDTO postRequest) {
        return RestAssured.given()
                .contentType(ContentType.JSON)      //work with json
                .body(postRequest)        // автоматическое преобразование в json
                .post(POSTS_API_PATH);    //POST
    }

    @Step
    public void removePostById(final Integer postId) {
        RestAssured.delete(String.format("%s/%s", POSTS_API_PATH, postId));
    }

    @Step
    public CommentsDTO updatePostById(final CommentsDTO newPostData, final Integer existingPostId) {
        return RestAssured.given()
                .body(newPostData)
                .contentType(ContentType.JSON)
                .put(format("%s/%s", POSTS_API_PATH, existingPostId))   //PUT
                .as(CommentsDTO.class);
    }

    @Step
    public CommentsDTO getPostById(final Integer postId) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .get(format("%s/%s", POSTS_API_PATH, postId))  //GET
                .as(CommentsDTO.class);
    }
}
