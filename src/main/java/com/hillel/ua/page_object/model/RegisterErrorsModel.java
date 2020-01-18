package com.hillel.ua.page_object.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterErrorsModel {

    private String emailError;
    private String confirmEmailError;
    private String passwordError;
    private String confirmPasswordError;
}
