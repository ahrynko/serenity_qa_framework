package com.hillel.ua.page_object.model.sportchek;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
@AllArgsConstructor
public class SportCheckProducts implements Comparable<SportCheckProducts> {

    private String title;
    private Integer number;

    @Override
    public int compareTo(SportCheckProducts anotherProduct) { //method сравнивания по полю number
        return this.number - anotherProduct.number;
    }
}
