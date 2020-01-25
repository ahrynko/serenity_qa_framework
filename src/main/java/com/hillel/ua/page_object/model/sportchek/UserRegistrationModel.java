package com.hillel.ua.page_object.model.sportchek;

import lombok.Data;

@Data
public class UserRegistrationModel {

    private String email;
    private String confirmEmail;
    private String password;
    private String confirmPassword;
}
