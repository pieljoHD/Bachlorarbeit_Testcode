package org.example.utils;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    protected AppiumDriver driver;
    String device;

    public void setUp(String platform) {

        AppiumDriverBuilder appiumDriverBuilder = new AppiumDriverBuilder();

        if ("Android".equalsIgnoreCase(platform)) {
            //device = SimulatorManager.getInstance().getAvailableAndroidDevice();
            System.out.println("Start with device " + device);
            driver = appiumDriverBuilder.installAndroidAppAndGetDriver(device);
        } else if ("IOS".equalsIgnoreCase(platform)) {
            driver = appiumDriverBuilder.getDriverIOSSession();
        } else {
            throw new IllegalArgumentException("Invalid platform: " + platform);
        }
    }

    @AfterMethod
    public void tearDown() {
        SimulatorManager.getInstance().setDeviceAvailable(device);
        if (driver != null) {
            driver.quit();
        }
    }
}
