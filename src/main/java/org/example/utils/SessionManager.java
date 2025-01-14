package org.example.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.util.HashMap;
import java.util.Map;

public final class SessionManager {

    private static SessionManager INSTANCE;
    public AppiumDriver driver = null;

    private SessionManager(AppiumDriver d) {
        driver = d;
    }

    public static SessionManager getInstance(String platform) {
        if(INSTANCE == null) {
            System.out.println("Create new SessionManager");
            AppiumDriver tmpDriver = null;
            AppiumDriverBuilder appiumDriverBuilder = new AppiumDriverBuilder();
            if(platform.equals("Android")) {
                tmpDriver = appiumDriverBuilder.installAndroidAppAndGetDriver();
            } else if(platform.equals("IOS")) {
                tmpDriver = appiumDriverBuilder.getDriverIOSSession();
            }
            INSTANCE = new SessionManager(tmpDriver);
        }

        return INSTANCE;
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
        if(driver != null) {
            final Map<String, Object> appArgs = new HashMap<>();
            if(driver instanceof IOSDriver) {
                appArgs.put("bundleId", "jockel.BachlorarbeitTestapp");
                appArgs.put("timeout", 0);
                driver.executeScript("mobile:terminateApp", appArgs);
            } else if(driver instanceof AndroidDriver) {
                appArgs.put("appId", "com.example.todolisttestapplication");
                appArgs.put("timeout", 0);
                driver.executeScript("mobile:terminateApp", appArgs);
                System.out.println("Closing Android App");
            }
        }
    }

    public void resetSessionManager() {
        System.out.println("Tear Down");
        INSTANCE = null;
        driver.quit();
    }
}