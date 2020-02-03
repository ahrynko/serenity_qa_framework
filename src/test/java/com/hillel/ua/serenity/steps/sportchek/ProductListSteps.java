package com.hillel.ua.serenity.steps.sportchek;

import com.hillel.ua.page_object.model.sportchek.SportCheckProducts;
import com.hillel.ua.page_object.pages.sportchek.SportcheckAlpineSkiingPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.List;

public class ProductListSteps extends ScenarioSteps {

    private SportcheckAlpineSkiingPage sportcheckAlpineSkiingPage;

    public ProductListSteps(final Pages pages) {
        this.sportcheckAlpineSkiingPage = pages.getPage(SportcheckAlpineSkiingPage.class);
    }

    @Step
    public List<String> getAlpineSkiingListAtomicText() {
        return sportcheckAlpineSkiingPage.getProductListPanel().getListAtomicText();
    }

    @Step
    public List<SportCheckProducts> getProducts() {
        return sportcheckAlpineSkiingPage.getProductListPanel().getSportCheckProducts();
    }

}
