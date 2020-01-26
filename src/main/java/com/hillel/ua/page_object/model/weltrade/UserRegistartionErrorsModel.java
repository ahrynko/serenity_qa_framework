package com.hillel.ua.page_object.model.weltrade;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRegistartionErrorsModel {

    private String firstNameError;
    private String lastNameError;
    private String emailError;
    private String phoneNumberError;

}
