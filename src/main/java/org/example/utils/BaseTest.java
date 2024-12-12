package org.example.utils;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private AppiumDriver driver = null;
    public AppiumDriverBuilder appiumDriverBuilder;

    public BaseTest(PLATFORM platform) {
        if (platform == PLATFORM.ANDROID) {
            driver = appiumDriverBuilder.installAndroidAppAndGetDriver();
        } else if (platform == PLATFORM.IOS) {
            driver = appiumDriverBuilder.getDriverIOSSession();
        }
    }

    @BeforeMethod
    public void openApp(){
        appiumDriverBuilder = new AppiumDriverBuilder();
    }

    @AfterMethod(alwaysRun = true)
    public void closeApp() {
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void quitDriverSession() {
        driver.quit();
    }

    public synchronized Object getDriver() {
        return driver;
    }
}
