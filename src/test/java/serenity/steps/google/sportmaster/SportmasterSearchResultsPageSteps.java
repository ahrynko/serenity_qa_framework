package serenity.steps.google.sportmaster;

import frontend.pages.SearchResultPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

public class SportmasterSearchResultsPageSteps extends ScenarioSteps {
    private SearchResultPage searchResultPage;

    public SportmasterSearchResultsPageSteps (final Pages pages){
        searchResultPage= pages.getPage(SearchResultPage.class);
    }

    @Step
    public String getDisplayedSearchMessage(){
        return searchResultPage.getSearchMessage();
    }
}
