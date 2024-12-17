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

    public AndroidDriver installAndroidAppAndGetDriver() {
        caps = setDefaultAndroidCapabilities(caps);
        caps.setCapability("appium:disableIdLocatorAutocompletion", true);
        driver = new AndroidDriver(getHubUrl(), caps);

        return driver;
    }

    public IOSDriver getDriverIOSSession() {
        return new IOSDriver(getHubUrl(), getIOSDefaultCapabilities());
    }

    private DesiredCapabilities getIOSDefaultCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("appium:platformVersion","17.5");
        capabilities.setCapability("appium:automationName", "xcuitest");
        capabilities.setCapability("appium:appPushTimeout", 120000);
        capabilities.setCapability("appium:clearSystemFiles", true);
        capabilities.setCapability("appium:maxTypingFrequency", 30);
        //let appium choose device

        return capabilities;
    }
}

