package com.hillel.ua.jbehave.scenarionsteps.api;

import com.hillel.ua.api.ProfileApiSteps;
import com.hillel.ua.api.dto.ProfileDTO;
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

public class RestApiProfileScenario {

    private static final String CREATED_POST_KEY = "created_post_key";    //POST (response)ответ
    private static final String EXPECTED_POST_DATA_KEY = "expected_post_data_key";   //POST (current table PostsDTO object)
    private static final String UPDATED_POST_DATA_KEY = "updated_post_data_key";   //PUT (update)
    private static final String FILTERED_POSTS_BY_QUERY_PARAMS_KEY = "filtered_posts_by_query_params_key";  //GET (getByQueryParams)

    private static final Integer EXPECTED_POST_ID = 1;  //DELETE

    @Steps
    private ProfileApiSteps profileApiSteps;

    @Given("user creates new 'POST', using API to profile: $postData")
    public void createNewPost(final ExamplesTable newPostInfo) {
        final ProfileDTO newProfileData = newPostInfo.getRowsAs(ProfileDTO.class).get(0);
        final Response newPostResponse = profileApiSteps.createNewPost(newProfileData);

        Serenity.setSessionVariable(EXPECTED_POST_DATA_KEY).to(newProfileData); // положили в сессию табл.'newPostInfo' по полям, кроме id
        Serenity.setSessionVariable(CREATED_POST_KEY).to(newPostResponse);  // положили (response)ответ в сессию
    }

    @Given("user removes Id to API Resources profile")
    public void deleteApiResources() {

        Logger.out.debug("! ----------- Removing Rest API Created Resources ---------------- !");

        profileApiSteps.removePostById(EXPECTED_POST_ID);

        Logger.out.debug("! ----------- Removing Rest API Created Resources Done ----------- !");

    }

    @When("user update existing post to profile, using following data: $newPostData")
    public void updateExistingPost(final ExamplesTable requestBody) {

        final ProfileDTO body = requestBody.getRowsAs(ProfileDTO.class).get(0);
        final Response createdPost = Serenity.sessionVariableCalled(CREATED_POST_KEY);
        final Integer createdPostId = createdPost.jsonPath().get("id");
        final ProfileDTO updatedPost = profileApiSteps.updatePostById(body, createdPostId);
        Serenity.setSessionVariable(UPDATED_POST_DATA_KEY).to(updatedPost);
    }

    @When("user filters retrieved Prifile  by next filter params: $filterParams")
    public void filterAllPostsByQueryParameters(final ExamplesTable filterParams) {
        final Map<String, String> queryParams = filterParams.getRow(0);
        final List<ProfileDTO> filteredByQueryParams = profileApiSteps.getByQueryParams(queryParams);
        Serenity.setSessionVariable(FILTERED_POSTS_BY_QUERY_PARAMS_KEY).to(filteredByQueryParams);
    }

    @Then("new POST should be created to profile")
    public void isNewPostCreated() {

        final Response createdPostResponse = Serenity.sessionVariableCalled(CREATED_POST_KEY); // достали (response)ответ из сессии

        final ProfileDTO actualPost = createdPostResponse.as(ProfileDTO.class); // распарсить json (response)ответ в объект PostsDTO
        final ProfileDTO expectedPost = Serenity.sessionVariableCalled(EXPECTED_POST_DATA_KEY); // достали из сессии табл.'newPostInfo' по полям

        final SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(actualPost.getName())     //сравнение по полю name
                .as("There is incorrect name!")
                .isEqualTo(expectedPost.getName());

        softAssertions.assertThat(actualPost.getTel())    //сравнение по полю tel
                .as("There is incorrect tel!")
                .isEqualTo(expectedPost.getTel());

        softAssertions.assertThat(actualPost.getEmail())      //сравнение по полю email
                .as("There is incorrect email!")
                .isEqualTo(expectedPost.getEmail());

        softAssertions.assertAll();
    }

    @Then("current following post should be updated to profile")
    public void  isCreatedPostUpdatedByNewData() {

        final ProfileDTO expectedPostData = Serenity.sessionVariableCalled(UPDATED_POST_DATA_KEY);
        final ProfileDTO actualPostData = profileApiSteps.getPostById(expectedPostData.getId());

        //Сравили два Post Objects (после PUT, после GET)
        ReflectionAssert.assertReflectionEquals("There is incorrect 'updated' Post!",
                expectedPostData, actualPostData);
    }

    @Then("each filtered POST should be contains only the following data: $filteredData")
    public void getProfileFilteredCorrectly(final ExamplesTable filteredData) {

        final Map<String, String> expectedFilteredProfile = filteredData.getRow(0);

        final List<ProfileDTO> actualFilteredProfile = Serenity.sessionVariableCalled(FILTERED_POSTS_BY_QUERY_PARAMS_KEY);

        Assertions.assertThat(actualFilteredProfile)
                .as("There are no filtered Profile retrieved!")
                .isNotEmpty();

        actualFilteredProfile.forEach(post -> {

            Assertions.assertThat(post.getTel())
                    .as("There is incorrect Tel!")
                    .isEqualTo(Integer.valueOf(expectedFilteredProfile.get("tel")));

            Assertions.assertThat(post.getEmail())
                    .as("There is incorrect Email!")
                    .isEqualTo(expectedFilteredProfile.get("email"));
        });
    }
}
