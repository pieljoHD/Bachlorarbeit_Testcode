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
        openApp();
    }

    @AfterMethod
    public void tearDown() {
        closeApp();
        SimulatorManager.getInstance().setDeviceAvailable(simulator);
    }

    public void openApp() {
        if(driver != null) {
            if(driver instanceof IOSDriver) {
                ((IOSDriver) driver).activateApp("jockel.BachlorarbeitTestapp");
            } else if(driver instanceof AndroidDriver) {
                ((AndroidDriver) driver).activateApp("com.example.todolisttestapplication");
            }
        }
    }

    public void closeApp() {
        if(simulator.platform.equals(Constants.IOS)) {
            ((IOSDriver) driver).terminateApp("jockel.BachlorarbeitTestapp");
        } else if(simulator.platform.equals(Constants.Android)) {
            ((AndroidDriver) driver).terminateApp("com.example.todolisttestapplication");
        }
    }
}