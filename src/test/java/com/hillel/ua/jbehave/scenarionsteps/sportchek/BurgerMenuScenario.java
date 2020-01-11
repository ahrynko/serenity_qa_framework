package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.serenity.steps.sportchek.BurgerMenuSteps;
import com.hillel.ua.serenity.steps.sportchek.HeaderPanelSteps;
import com.hillel.ua.serenity.steps.sportchek.SportCheckMainPageSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.unitils.reflectionassert.ReflectionAssert;

import java.util.Collections;
import java.util.List;

public class BurgerMenuScenario {

  @Steps
  private SportCheckMainPageSteps sportCheckMainPageSteps;

  @Steps
  private HeaderPanelSteps headerPanelSteps; //step to case cases

  @Steps
  private BurgerMenuSteps burgerMenuSteps; //step to case cases

  @Given("user opened site, using next url: '$url'")
  public void openSite(final String url) {
    sportCheckMainPageSteps.openPage(url);
  }

  @When("user clicks burger menu button")
  public void openBurgerMenu() {
    headerPanelSteps.openBurgerMenu();
  }

  @Then("following menu items are displayed: '$menuItems'")
  public void verifyBurgerMenuItems(final List<String> expectedMenuItems) {

    final List<String> actualMenuItems =  burgerMenuSteps.getMenuItems();

      Collections.sort(expectedMenuItems);
      Collections.sort(actualMenuItems);

    ReflectionAssert.assertReflectionEquals("There is incorrect burger menu items displayed!",
            expectedMenuItems, actualMenuItems);
  }

}
