package org.example.ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.utils.AppiumDriverBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTestIOS {
    private IOSDriver driver;

    public BaseTestIOS() {}

    @BeforeMethod(alwaysRun = true)
    public void initSession() {
        AppiumDriverBuilder appiumDriverBuilder = new AppiumDriverBuilder();
        driver = appiumDriverBuilder.installIOSAppAndGetDriver();
        getDriver().activateApp("jockel.BachlorarbeitTestapp");
    }

    @AfterMethod(alwaysRun = true)
    public void closeApp() {
        getDriver().terminateApp("jockel.BachlorarbeitTestapp");
        driver.quit();
    }

    public IOSDriver getDriver() {
        return driver;
    }
}
