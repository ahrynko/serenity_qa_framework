package com.hillel.ua.serenity.steps.weltrade;

import com.hillel.ua.page_object.model.weltrade.UserRegistartionErrorsModel;
import com.hillel.ua.page_object.model.weltrade.UserRegistrationModel;
import com.hillel.ua.page_object.pages.weltrade.WeltradePubMainPage;
import com.hillel.ua.page_object.pages.weltrade.WeltradeSignUpPage;
import com.hillel.ua.page_object.panels.weltrade.WeltradeRegistrationPanel;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;

public class WeltradeSignUpSteps {

    private WeltradePubMainPage weltradePubMainPage;
    private WeltradeSignUpPage weltradeSignUpPage;

    public WeltradeSignUpSteps(final Pages pages) {
        this.weltradePubMainPage = pages.getPage(WeltradePubMainPage.class);
    }

    @Step
    public void tryRegisterUser(final UserRegistrationModel userRegistrationModel) {
       final WeltradeRegistrationPanel weltradeRegistrationPanel = weltradeSignUpPage.getRegistrPanel();

       weltradeRegistrationPanel.typeFirstName(userRegistrationModel.getFirstName());
       weltradeRegistrationPanel.typeLastName(userRegistrationModel.getLastName());
       weltradeRegistrationPanel.typeEmail(userRegistrationModel.getEmail());
       weltradeRegistrationPanel.typePhoneNumber(userRegistrationModel.getPhoneNumber());

       weltradeRegistrationPanel.checkedCheckbox();
    }

    @Step
    public UserRegistartionErrorsModel getDisplayedErrors() {
        return weltradeSignUpPage.getRegistrPanel().getRegisterErrors();
    }

}
