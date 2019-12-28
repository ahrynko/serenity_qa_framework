package serenity.steps.google;

import frontend.pages.GoogleMainPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class GoogleMainPageTestSteps extends ScenarioSteps {

    private GoogleMainPage googleMainPage;

    public GoogleMainPageTestSteps(final Pages pages) {
        googleMainPage = pages.getPage(GoogleMainPage.class);
    }

    @Step
    public String getDisplayedTitle() {
        return googleMainPage.getCurrentTitle();
    }

    @Step
    public void openGooglePage(final String link) {
        googleMainPage.openAt(link);
    }

    @Step
    public Boolean isLogoDisplayed() {
       googleMainPage.getLogoVisibility();
       return isLogoDisplayed();
    }
}
