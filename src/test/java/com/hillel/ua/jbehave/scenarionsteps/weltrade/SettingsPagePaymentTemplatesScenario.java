package com.hillel.ua.jbehave.scenarionsteps.weltrade;

import com.hillel.ua.common.data.EnvironmentProperties;
import com.hillel.ua.logging.Logger;
import com.hillel.ua.serenity.steps.weltrade.SettingsPagePaymentTemplatesSteps;
import net.thucydides.core.annotations.Steps;
import org.assertj.core.api.Assertions;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

import java.util.List;

public class SettingsPagePaymentTemplatesScenario {

    @Steps
    private SettingsPagePaymentTemplatesSteps paymentTemplatesSteps;

    @When("user opened 'Settings Page Payment templates' by url: '$url'")
    public void openSettingsPagePaymentTemplates(final EnvironmentProperties environmentProperties) {
        final String commonUrl = environmentProperties.readProperty();
        paymentTemplatesSteps.openPageByPartialUrl(commonUrl);
    }

    @When("user chooses QIWI Payment system with Purse number: '$purse'")
    public void addQiwiTemplate(final String purse) {
        paymentTemplatesSteps.choosePaymentSystem();
        paymentTemplatesSteps.chooseQiwi();
        paymentTemplatesSteps.chooseCurrency();
        paymentTemplatesSteps.chooseEurCurrency();
        paymentTemplatesSteps.typePurseNumber(purse);
        paymentTemplatesSteps.clickAddButton();
    }

    @When("user deleted QIWI Payment system template")
    public void deletePaymentTemplate() {
        paymentTemplatesSteps.deletePaymentTemplate();
    }

    @Then("following success toast displayed on the page Payment templates: '$toast'")
    public void verifySuccessToast (final String toast) {
        final String actualToast = paymentTemplatesSteps.getSuccessToast();

        Assertions.assertThat(actualToast) // toast with site
                .as("There is incorrect success toast displayed!")
                .isEqualTo(toast);
    }

    @Then("the template appeared in the list of added templates with the same information as when filling")
    public void retrievedTemplatesList() {
        final List<String> actualTemplatesTitleList = paymentTemplatesSteps.getListTemplatesTitleText();
        final List<String> actualPurseTitleList = paymentTemplatesSteps.getListPurseTitleText();
        final List<String> actualCurrencyTitleList = paymentTemplatesSteps.getListCurrencyTitleText();

        Assert.assertFalse("There are not templates title found!", actualTemplatesTitleList.isEmpty());
        Assert.assertFalse("There are not purse title found!", actualPurseTitleList.isEmpty());
        Assert.assertFalse("There are not currency title found!", actualCurrencyTitleList.isEmpty());

        actualTemplatesTitleList.forEach(title -> {
            Assert.assertTrue("There is no such templates title present! ",title.contains("QIWI"));
        });

        actualPurseTitleList.forEach(title -> {
            Assert.assertTrue("There is no such purse title present! ",title.contains("7999999999"));
        });

        actualCurrencyTitleList.forEach(title -> {
            Assert.assertTrue("There is no such currency title present! ",title.contains("EUR"));
        });

        Logger.out.info(actualTemplatesTitleList);
        Logger.out.info(actualTemplatesTitleList.size());
        Logger.out.info(actualPurseTitleList);
        Logger.out.info(actualPurseTitleList.size());
        Logger.out.info(actualCurrencyTitleList);
        Logger.out.info(actualCurrencyTitleList.size());

    }

    @Then("the template was successfully deleted and does not appear in the list")
    public void verifyTemplateDelete() {

        boolean check = paymentTemplatesSteps.isTemplatesTitlePresent();
        Assert.assertFalse("There are templates title found!", check);
    }
}
