package com.hillel.ua.page_object.model.weltrade;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentTemplatesModal {

    public PaymentTemplatesModal() {}

    private String template;
    private String purse;
    private String currency;

}
