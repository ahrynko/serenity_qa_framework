package com.hillel.ua.page_object.model.sportchek;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
public class SportCheckProducts implements Comparable<SportCheckProducts> {

    private static final String PRODUCT_TITLE_LOCATOR = ".//span[@class='product-title-text']";
    private static final String RATING_VALUE_LOCATOR = ".//span[@class='rating__value']";

    private String title;
    private Integer number;

    @Override
    public int compareTo(SportCheckProducts anotherProduct) { //method сравнивания по полю number
        return this.number - anotherProduct.number;
    }
}
