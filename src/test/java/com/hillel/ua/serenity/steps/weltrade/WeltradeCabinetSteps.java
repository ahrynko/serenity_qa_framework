package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.page_object.pages.weltrade.WeltradeCabinetPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class WeltradeCabinetSteps {

    private WeltradeCabinetPage weltradeCabinetPage;

    public WeltradeCabinetSteps(final Pages pages) {
        this.weltradeCabinetPage = pages.getPage(WeltradeCabinetPage.class);
    }

    @Step
    public String getCurrentWeltradeTitle() {
        return weltradeCabinetPage.getCurrentTitle();
    }
}
