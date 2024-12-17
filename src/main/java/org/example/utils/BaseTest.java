package org.example.utils;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {
    protected AppiumDriver driver;

    @Parameters("platform")
    @BeforeMethod
    public void setUp(String platform) {
        AppiumDriverBuilder appiumDriverBuilder = new AppiumDriverBuilder();;
        if ("Android".equalsIgnoreCase(platform)) {
            driver = appiumDriverBuilder.installAndroidAppAndGetDriver();
        } else if ("IOS".equalsIgnoreCase(platform)) {
            driver = appiumDriverBuilder.getDriverIOSSession();
        } else {
            throw new IllegalArgumentException("Invalid platform: " + platform);
        }
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("killed driver Session");
        if (driver != null) {
            driver.quit();
        }
    }
}
