package com.hillel.ua.jbehave.scenarionsteps.sportchek;

import com.hillel.ua.logging.Logger;
import com.hillel.ua.page_object.model.sportchek.SportCheckProducts;
import com.hillel.ua.serenity.steps.sportchek.ProductListSteps;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;
import org.unitils.reflectionassert.ReflectionAssert;

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

    @Then("products are filtered by the specified filter: '$TECNO PRO'")
    public void retrievedProductList(final List<String> expectedProductList) {

        final List<String> actualSearchList = productListSteps.getListTecnoProText();
        Assert.assertFalse("There are not item found! ", actualSearchList.isEmpty());

        actualSearchList.forEach(item -> {
            Assert.assertTrue("There is not such item present! ",item.contains("Tecnopro"));
        });
        logger.info(actualSearchList);
        logger.info(actualSearchList.size());
    }

    @Then("products are sorted by the number of stars")
    public void orderByNumberStars() {

        final List<SportCheckProducts> sortedSportCheckItemsList = productListSteps.getProducts();

        ReflectionAssert.assertReflectionEquals("There is incorrect sorting found! ",
                "unsorted", sortedSportCheckItemsList);
    }

    @Then("all filters by product were reset")
    public void retrievedProductListAfterReset() {

        //transfer ---------session  to openAlpineSkiingPage---------//

        final List<String> expectedListProducts = Serenity.sessionVariableCalled("expected_filters_before_reset");
        final List<String> actualProductList = productListSteps.getListAllProducts();

        ReflectionAssert.assertReflectionEquals("There are incorrect products displayed!",
                expectedListProducts, actualProductList);

        logger.info(expectedListProducts);
        logger.info(actualProductList);
    }
}
