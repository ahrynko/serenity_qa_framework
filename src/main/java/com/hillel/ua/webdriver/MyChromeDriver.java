package com.hillel.ua.webdriver;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

public class MyChromeDriver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        try {
            ChromeOptions capabilities = new ChromeOptions();
            // Add  don't work
            Cookie samplecookie = new Cookie("_gid", "tQeZ4R0WCHnjbHJJsUC7jVnK_9v1oPGUKzyweOncvbQLIru7N8PIGNneP4zJUspdVQ3NlQ");

            return new ChromeDriver(ChromeDriverService.createDefaultService(), capabilities);
        }
        catch (Exception e) {
            throw new Error(e);
        }
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
