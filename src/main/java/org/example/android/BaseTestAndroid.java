package org.example.android;


import io.appium.java_client.android.AndroidDriver;
import org.example.utils.AppiumDriverBuilder;
import org.testng.annotations.*;

import java.io.IOException;

public class BaseTestAndroid {
    private AndroidDriver driver = null;
    public AppiumDriverBuilder appiumDriverBuilder;
    public static Boolean localhostServerExecution = false;

    public BaseTestAndroid() {
        System.out.println("super BaseTestAndroid called");
        localhostServerExecution = true;
    }

    @BeforeMethod
    public void openApp() throws IOException{
        appiumDriverBuilder = new AppiumDriverBuilder();
        System.setProperty("test.type", "android");
        driver = appiumDriverBuilder.installAndroidAppAndGetDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeApp() {
        AndroidDriver driver = getDriver();
        driver.quit();
    }

    @AfterSuite(alwaysRun = true)
    public void quitDriverSession() {
        getDriver().quit();
    }

    public synchronized AndroidDriver getDriver() {
        return driver;
    }
}