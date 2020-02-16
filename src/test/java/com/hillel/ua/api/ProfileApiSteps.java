package com.hillel.ua.api;

import com.hillel.ua.api.dto.ProfileDTO;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static java.lang.String.format;

public class ProfileApiSteps extends AbstractApiSteps {

    private static final String POSTS_API_PATH = "/profile";

    @Step
    public Response createNewPost(final ProfileDTO postRequest) {
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
    public ProfileDTO updatePostById(final ProfileDTO newPostData, final Integer existingPostId) {
        return RestAssured.given()
                .body(newPostData)
                .contentType(ContentType.JSON)
                .put(format("%s/%s", POSTS_API_PATH, existingPostId))   //PUT
                .as(ProfileDTO.class);
    }

    @Step
    public ProfileDTO getPostById(final Integer postId) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .get(format("%s/%s", POSTS_API_PATH, postId))  //GET
                .as(ProfileDTO.class);
    }

    @Step
    public List<ProfileDTO> getByQueryParams(final Map<String, String> params) {  //фильтр по параметрам
        return Collections.singletonList(RestAssured.given()
                .queryParams(params)
                .contentType(ContentType.JSON)
                .get(POSTS_API_PATH)                //GET
                .as(ProfileDTO.class));
    }
}
