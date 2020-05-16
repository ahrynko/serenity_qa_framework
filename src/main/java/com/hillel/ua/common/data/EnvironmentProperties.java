package com.hillel.ua.common.data;

public enum EnvironmentProperties {  //can store constructor

    SPORTCHEK_BASE_URL("sportchek.base.url"),
    GOOGLE_BASE_URL("google.base.url"),
    LOCAL_API_URL("local.api.url"),
    WELTRADE_BASE_URL("weltrade.base.url"),
    CNN_BASE_URL("cnn.base.url"),

    PROD_WELTRADE_CAB_LOGIN_URL("prod.weltrade.cab.login.url"),
    DEV_WELTRADE_CAB_LOGIN_URL("dev.weltrade.cab.login.url"),
    WELTRADE_PUB_QUOTES_URL("weltrade.pub.quotes.url");

    private String propertyKey;

    EnvironmentProperties(final String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String readProperty() {
        final PropertiesReader propertiesReader = new PropertiesReader();
        return propertiesReader.getProperty(propertyKey);
    }

}
