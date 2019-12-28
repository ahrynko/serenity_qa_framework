package frontend.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriver;

import java.util.stream.Collectors;

public class SearchResultPage extends AbstractPage {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    private static  String SEARCH_MESSAGE_LOCATOR ="//h1";

    public String getSearchMessage(){
        return findAll(SEARCH_MESSAGE_LOCATOR)
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.joining(" "));
    }
}
