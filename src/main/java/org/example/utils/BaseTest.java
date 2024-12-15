package org.example.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
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
        if(simulator.platform.equals(Constants.IOS)) {
            ((IOSDriver) driver).terminateApp("jockel.BachlorarbeitTestapp");
        } else if(simulator.platform.equals(Constants.Android)) {
            ((AndroidDriver) driver).terminateApp("com.example.todolisttestapplication");
        }
        SimulatorManager.getInstance().setDeviceAvailable(simulator);
    }
}
