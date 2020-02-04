package com.hillel.ua.webdriver;

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
            // Add

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
