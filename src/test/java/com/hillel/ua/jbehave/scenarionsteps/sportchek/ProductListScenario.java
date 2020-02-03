package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.logging.Logger;
import com.hillel.ua.serenity.steps.sportchek.ProductListSteps;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;

import java.util.List;

public class ProductListScenario  {

    private Logger logger = new Logger();

    @Steps
    private ProductListSteps productListSteps;

    @Then("products are only displayed with this brand: '$ATOMIC'")
    public void retrievedItemList(final List<String> expectedSearchList) {

        final List<String> actualSearchList = productListSteps.getAlpineSkiingListAtomicText();
        Assert.assertFalse("There are not item found! ", actualSearchList.isEmpty());

        actualSearchList.forEach(item -> {
            Assert.assertTrue("There is not such item present! ",item.contains("Atomic"));
        });
        logger.info(actualSearchList);
        logger.info(actualSearchList.size());
    }

}
