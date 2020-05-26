package com.hillel.ua.page_object.model.weltrade;

import lombok.Data;

@Data
public class ChangePassModel {

    private String validPassword;
    private String newPassword;
    private String repeatNewPassword;

}
