package com.hillel.ua.page_object.model.sportchek;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SportCheckProducts implements Comparable<SportCheckProducts> {

    private Integer number;

    @Override
    public int compareTo(SportCheckProducts anotherProduct) { //method сравнивания по полю number
        return this.number - anotherProduct.number;    // this.title.compareTo(anotherProduct.title);
    }
}
