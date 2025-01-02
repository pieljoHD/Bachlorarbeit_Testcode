package org.example.ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.utils.AppiumDriverBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;


public class BaseTestIOS {
    public AppiumDriverBuilder appiumDriverBuilder;
    private IOSDriver driver = null;
    public Boolean localhostServerExecution = false;

    public BaseTestIOS() {}

    @BeforeMethod(alwaysRun = true)
    public void initSession() {
        appiumDriverBuilder = new AppiumDriverBuilder();
        localhostServerExecution = true;
        driver = appiumDriverBuilder.installIOSAppAndGetDriver();
        getDriver().activateApp("jockel.BachlorarbeitTestapp");
    }

    @AfterMethod(alwaysRun = true)
    public void closeApp() {
        getDriver().terminateApp("jockel.BachlorarbeitTestapp");
    }

    @AfterSuite(alwaysRun = true)
    public void quitDriverSession() {
        getDriver().quit();
    }

    public IOSDriver getDriver() {
        return driver;
    }
}
