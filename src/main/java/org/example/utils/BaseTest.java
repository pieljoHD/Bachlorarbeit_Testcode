package org.example.utils;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    protected AppiumDriver driver;

    public void setUp(String platform, String deviceId) {
        AppiumDriverBuilder appiumDriverBuilder = new AppiumDriverBuilder();;
        if ("Android".equalsIgnoreCase(platform)) {
            System.out.println("Create new Driver");
            driver = appiumDriverBuilder.installAndroidAppAndGetDriver(deviceId);
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
