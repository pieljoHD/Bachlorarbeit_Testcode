package org.example.utils;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    protected AppiumDriver driver;

    public void setUp(String platform, String deviceId, int wdaLocalPort) {
        AppiumDriverBuilder appiumDriverBuilder = new AppiumDriverBuilder();;
        if ("Android".equalsIgnoreCase(platform)) {
            driver = appiumDriverBuilder.installAndroidAppAndGetDriver(deviceId);
        } else if ("IOS".equalsIgnoreCase(platform)) {
            driver = appiumDriverBuilder.getDriverIOSSession(deviceId, wdaLocalPort);
        } else {
            throw new IllegalArgumentException("Invalid platform: " + platform);
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
