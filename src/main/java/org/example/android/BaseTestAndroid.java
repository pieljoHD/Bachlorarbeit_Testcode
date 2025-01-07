package org.example.android;


import io.appium.java_client.android.AndroidDriver;
import org.example.utils.AppiumDriverBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTestAndroid {
    private AndroidDriver driver;

    public BaseTestAndroid() {}

    @BeforeMethod
    public void initSession() {
        AppiumDriverBuilder appiumDriverBuilder = new AppiumDriverBuilder();
        driver = appiumDriverBuilder.installAndroidAppAndGetDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void closeApp() {
        AndroidDriver driver = getDriver();
        driver.quit();
    }

    public synchronized AndroidDriver getDriver() {
        return driver;
    }
}