package com.hillel.ua.api;

import com.hillel.ua.api.dto.CommentsDTO;
import com.hillel.ua.api.dto.PostsDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
        RestAssured.delete(String.format("%s/%s", POSTS_API_PATH, postId)); //DELETE
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

    @Step
    public List<CommentsDTO> getByQueryParams(final Map<String, String> params) {  //фильтр по параметрам
        return Arrays.asList(RestAssured.given()
                .queryParams(params)
                .contentType(ContentType.JSON)
                .get(POSTS_API_PATH)                //GET
                .as(CommentsDTO[].class));
    }
}
