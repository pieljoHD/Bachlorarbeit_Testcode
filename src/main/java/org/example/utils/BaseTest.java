package org.example.utils;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    protected AppiumDriver driver;
    Simulator simulator;

    public void setUp(String platform) {
        if (Constants.Android.equalsIgnoreCase(platform)) {
            simulator = SimulatorManager.getInstance().getAvailableSimulator(Constants.Android);
        } else if (Constants.IOS.equalsIgnoreCase(platform)) {
            simulator = SimulatorManager.getInstance().getAvailableSimulator(Constants.IOS);
        } else {
            throw new IllegalArgumentException("Invalid platform: " + platform);
        }
        driver = simulator.driver;
    }

    @AfterMethod
    public void tearDown() {
        SimulatorManager.getInstance().setDeviceAvailable(simulator);
    }
}
