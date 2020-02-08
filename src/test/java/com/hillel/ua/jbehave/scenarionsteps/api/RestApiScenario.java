package com.hillel.ua.jbehave.scenarionsteps.api;

import com.hillel.ua.api.PostsApiSteps;
import com.hillel.ua.api.dto.PostsDTO;
import com.hillel.ua.logging.Logger;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.SoftAssertions;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.model.ExamplesTable;

public class RestApiScenario {

    @Steps
    private PostsApiSteps postsApiSteps;

    private static final String CREATED_POST_KEY = "created_post_key";
    private static final String EXPECTED_POST_DATA_KEY = "expected_post_data_key";
    private static final Integer EXPECTED_POST_ID = 1;

    @Given("user removes Id to Api Resources")
    public void deleteApiResources() {

        Logger.out.debug("! ----------- Removing Rest API Created Resources ---------------- !");

        postsApiSteps.removePostById(EXPECTED_POST_ID);

        Logger.out.debug("! ----------- Removing Rest API Created Resources Done ----------- !");
    }


    @Given("user creates new 'Post', using API: $postData")
    public void createNewPost(final ExamplesTable  newPostInfo) {
        final PostsDTO newPostsData = newPostInfo.getRowsAs(PostsDTO.class).get(0);
        final Response newPostResponse = postsApiSteps.createNewPost(newPostsData);

        Serenity.setSessionVariable(EXPECTED_POST_DATA_KEY).to(newPostsData); // положили в сессию табл.'newPostInfo' по полям, кроме id
        Serenity.setSessionVariable(CREATED_POST_KEY).to(newPostResponse);  // положили (response)ответ в сессию
    }

    @Then("new post should be created")
    public void isNewPostCreated() {

        final Response createdPostResponse = Serenity.sessionVariableCalled(CREATED_POST_KEY); // достали (response)ответ из сессии

        final PostsDTO actualPost = createdPostResponse.as(PostsDTO.class); // распарсить json (response)ответ в объект PostsDTO
        final PostsDTO expectedPost = Serenity.sessionVariableCalled(EXPECTED_POST_DATA_KEY); // достали из сессии табл.'newPostInfo' по полям

        final SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(createdPostResponse.getStatusCode())  //проверка ответа- 201
                .as("Incorrect status code!")
                .isEqualTo(201);

        softAssertions.assertThat(actualPost.getTitle())     //сравнение по полям
                .as("There is incorrect title!")
                .isEqualTo(expectedPost.getTitle());

        softAssertions.assertThat(actualPost.getAuthor())    //сравнение по полям
                .as("There is incorrect author!")
                .isEqualTo(expectedPost.getAuthor());

        softAssertions.assertThat(actualPost.getAge())      //сравнение по полям
                .as("There is incorrect age!")
                .isEqualTo(expectedPost.getAge());

        softAssertions.assertAll();
    }
}

