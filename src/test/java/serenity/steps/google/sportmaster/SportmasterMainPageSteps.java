package serenity.steps.google.sportmaster;

import frontend.pages.SportmasterMainPage;
import frontend.panels.SearchPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.yecht.Data;

public class SportmasterMainPageSteps extends ScenarioSteps {

    private SportmasterMainPage sportmasterMainPage;

    public SportmasterMainPageSteps(final Pages pages){
        sportmasterMainPage=pages.getPage(SportmasterMainPage.class);
    }

    @Step
    public void openPage(final String link){
        sportmasterMainPage.openAt(link);
    }

    @Step
    public void searchFor(final String item){
       final SearchPanel searchPanel = sportmasterMainPage.getSearchPanel();
       searchPanel.inputSearchText(item);

    }
}
