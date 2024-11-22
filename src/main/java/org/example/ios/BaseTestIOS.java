package org.example.ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.utils.AppiumDriverBuilder;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.format.DateTimeFormatter;


public class BaseTestIOS {
    public AppiumDriverBuilder appiumDriverBuilder;
    private IOSDriver driver = null;
    public Boolean localhostServerExecution = false;

    public BaseTestIOS() {}

    @BeforeMethod(alwaysRun = true)
    public void initSession() throws IOException {
        appiumDriverBuilder = new AppiumDriverBuilder();
        localhostServerExecution = true;
        driver = appiumDriverBuilder.getDriverIOSSession();
        getDriver().activateApp("jockel.BachlorarbeitTestapp");
    }

    @AfterMethod(alwaysRun = true)
    public  void closeApp() {
        getDriver().terminateApp("jockel.BachlorarbeitTestapp");
        getDriver().quit();
    }

    public IOSDriver getDriver() {
        return driver;
    }
}
