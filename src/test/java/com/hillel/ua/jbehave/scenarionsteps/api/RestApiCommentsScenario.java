package com.hillel.ua.jbehave.scenarionsteps.api;

import com.hillel.ua.api.CommentsApiSteps;
import com.hillel.ua.api.dto.CommentsDTO;
import com.hillel.ua.logging.Logger;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.List;
import java.util.Map;

public class RestApiCommentsScenario {

    private static final String CREATED_POST_KEY = "created_post_key";    //POST (response)ответ
    private static final String EXPECTED_POST_DATA_KEY = "expected_post_data_key";   //POST (current table PostsDTO object)
    private static final String UPDATED_POST_DATA_KEY = "updated_post_data_key";   //PUT (update)
    private static final String FILTERED_POSTS_BY_QUERY_PARAMS_KEY = "filtered_posts_by_query_params_key";  //GET (getByQueryParams)

    private static final Integer EXPECTED_POST_ID = 1;  //DELETE

    @Steps
    private CommentsApiSteps commentsApiSteps;

    @Given("user creates new 'POST', using API: $postData")
    public void createNewPost(final ExamplesTable newPostInfo) {
        final CommentsDTO newCommentsData = newPostInfo.getRowsAs(CommentsDTO.class).get(0);
        final Response newPostResponse = commentsApiSteps.createNewPost(newCommentsData);

        Serenity.setSessionVariable(EXPECTED_POST_DATA_KEY).to(newCommentsData); // положили в сессию табл.'newPostInfo' по полям, кроме id
        Serenity.setSessionVariable(CREATED_POST_KEY).to(newPostResponse);  // положили (response)ответ в сессию
    }

    @Given("user removes Id to API Resources")
    public void deleteApiResources() {

        Logger.out.debug("! ----------- Removing Rest API Created Resources ---------------- !");

        commentsApiSteps.removePostById(EXPECTED_POST_ID);

        Logger.out.debug("! ----------- Removing Rest API Created Resources Done ----------- !");

    }

    @When("user update existing post to comments, using following data: $newPostData")
    public void updateExistingPost(final ExamplesTable requestBody) {

        final CommentsDTO body = requestBody.getRowsAs(CommentsDTO.class).get(0);
        final Response createdPost = Serenity.sessionVariableCalled(CREATED_POST_KEY);
        final Integer createdPostId = createdPost.jsonPath().get("id");
        final CommentsDTO updatedPost = commentsApiSteps.updatePostById(body, createdPostId);
        Serenity.setSessionVariable(UPDATED_POST_DATA_KEY).to(updatedPost);
    }

    @When("user filters retrieved Comments  by next filter params: $filterParams")
    public void filterAllPostsByQueryParameters(final ExamplesTable filterParams) {
        final Map<String, String> queryParams = filterParams.getRow(0);
        final List<CommentsDTO> filteredByQueryParams = commentsApiSteps.getByQueryParams(queryParams);
        Serenity.setSessionVariable(FILTERED_POSTS_BY_QUERY_PARAMS_KEY).to(filteredByQueryParams);
    }

    @Then("new POST should be created")
    public void isNewPostCreated() {

        final Response createdPostResponse = Serenity.sessionVariableCalled(CREATED_POST_KEY); // достали (response)ответ из сессии

        final CommentsDTO actualPost = createdPostResponse.as(CommentsDTO.class); // распарсить json (response)ответ в объект PostsDTO
        final CommentsDTO expectedPost = Serenity.sessionVariableCalled(EXPECTED_POST_DATA_KEY); // достали из сессии табл.'newPostInfo' по полям

        final SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualPost.getBody())     //сравнение по полю body
                .as("There is incorrect body!")
                .isEqualTo(expectedPost.getBody());

        softAssertions.assertThat(actualPost.getAuthor())    //сравнение по полю author
                .as("There is incorrect author!")
                .isEqualTo(expectedPost.getAuthor());

        softAssertions.assertThat(actualPost.getGender())      //сравнение по полю gender
                .as("There is incorrect gender!")
                .isEqualTo(expectedPost.getGender());

        softAssertions.assertAll();
    }

    @Then("current following post should be updated")
    public void  isCreatedPostUpdatedByNewData() {

        final CommentsDTO expectedPostData = Serenity.sessionVariableCalled(UPDATED_POST_DATA_KEY);
        final CommentsDTO actualPostData = commentsApiSteps.getPostById(expectedPostData.getId());

        //Сравили два Post Objects (после PUT, после GET)
        ReflectionAssert.assertReflectionEquals("There is incorrect 'updated' Post!",
                expectedPostData, actualPostData);
    }

    @Then("each filtered POST should contains only the following data: $filteredData")
    public void commentsFilteredCorrectly(final ExamplesTable filteredData) {

        final Map<String, String> expectedFilteredComments = filteredData.getRow(0);

        final List<CommentsDTO> actualFilteredComments = Serenity.sessionVariableCalled(FILTERED_POSTS_BY_QUERY_PARAMS_KEY);

        Assertions.assertThat(actualFilteredComments)
                .as("There are no filtered Comments retrieved!")
                .isNotEmpty();

        actualFilteredComments.forEach(post -> {

            Assertions.assertThat(post.getBody())
                    .as("There is incorrect Body!")
                    .isEqualTo(expectedFilteredComments.get("body"));

            Assertions.assertThat(post.getGender())
                    .as("There is incorrect Gender!")
                    .isEqualTo(expectedFilteredComments.get("gender"));
        });
    }
}
