package com.hillel.ua.page_object.model.weltrade;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor
public class AwardsModel {

    private String title;
    private String body;

    @Override
    public boolean equals(Object o) {
        AwardsModel that = (AwardsModel) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(body, that.body);
    }

}
