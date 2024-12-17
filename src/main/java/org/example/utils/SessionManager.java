package org.example.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

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
            if(driver instanceof IOSDriver) {
                ((IOSDriver) driver).terminateApp("jockel.BachlorarbeitTestapp");
            } else if(driver instanceof AndroidDriver) {
                ((AndroidDriver) driver).terminateApp("com.example.todolisttestapplication");
            }
        }
    }

    public void resetSessionManager() {
        System.out.println("Tear Down");
        INSTANCE = null;
        driver.quit();
    }
}