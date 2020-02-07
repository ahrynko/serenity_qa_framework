package com.hillel.ua.common.data;

public enum EnvironmentProperties {  //can store constructor

    SPORTCHEK_BASE_URL("sportchek.base.url"),
    GOOGLE_BASE_URL("google.base.url");

    private String propertyKey;

    EnvironmentProperties(final String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String readProperty() {
        final PropertiesReader propertiesReader = new PropertiesReader();
        return propertiesReader.getProperty(propertyKey);
    }

}