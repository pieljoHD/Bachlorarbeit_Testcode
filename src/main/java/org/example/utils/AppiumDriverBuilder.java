package org.example.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverBuilder {

    DesiredCapabilities caps = new DesiredCapabilities();
    AndroidDriver driver;

    private URL getHubUrl() {
        URL remoteAddress = null;
        try {
            remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            Assert.fail("Selenium Grid address is malformed. Exception message: ", e);
        }
        return remoteAddress;
    }

    public DesiredCapabilities setDefaultAndroidCapabilities(DesiredCapabilities caps) {
        caps.setCapability("platformName", "android");
        caps.setCapability("appium:automationName", "uiautomator2");

        return caps;
    }

    public AndroidDriver installAndroidAppAndGetDriver(Simulator simulator) {
        caps = setDefaultAndroidCapabilities(caps);
        caps.setCapability("appium:appPackage", "com.example.todolisttestapplication");
        caps.setCapability("appium:appActivity", "com.example.todolisttestapplication.MainActivity");
        caps.setCapability("appium:disableIdLocatorAutocompletion", true);
        caps.setCapability("appium:udid", simulator.uuid);

        driver = new AndroidDriver(getHubUrl(), caps);

        return driver;
    }

    public IOSDriver getDriverIOSSession(Simulator simulator) {
        return new IOSDriver(getHubUrl(), getIOSDefaultCapabilities(simulator));
    }

    private DesiredCapabilities getIOSDefaultCapabilities(Simulator simulator) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("appium:automationName", "xcuitest");
        capabilities.setCapability("appium:appPushTimeout", 120000);
        capabilities.setCapability("appium:bundleId", "jockel.BachlorarbeitTestapp");
        capabilities.setCapability("appium:clearSystemFiles", true);
        capabilities.setCapability("appium:maxTypingFrequency", 30);
        capabilities.setCapability("appium:udid", simulator.uuid);
        capabilities.setCapability("appium:wdaLocalPort", simulator.wdaLocalPort);
        capabilities.setCapability("appium:derivedDataPath","/Users/johannespielmeier/Library/Developer/Xcode/DerivedData");
        //let appium choose device

        return capabilities;
    }
}

