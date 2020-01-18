package com.hillel.ua.page_object.model;

import lombok.Data;

@Data
public class UserRegistrationModel {

    private String email;
    private String confirmEmail;
    private String password;
    private String confirmPassword;
}
