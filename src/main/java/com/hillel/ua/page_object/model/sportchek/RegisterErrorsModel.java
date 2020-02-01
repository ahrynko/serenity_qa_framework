package com.hillel.ua.page_object.model.sportchek;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterErrorsModel {

    public RegisterErrorsModel() {}

    private String emailError;
    private String confirmEmailError;
    private String passwordError;
    private String confirmPasswordError;
}
