package org.example.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverBuilder {
    private URL getHubUrl() {
        URL remoteAddress = null;
        try {
            remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            Assert.fail("Failed to connect to Server: ", e);
        }
        return remoteAddress;
    }

    public AndroidDriver installAndroidAppAndGetDriver() {
        DesiredCapabilities caps = getDefaultAndroidCapabilities();
        return new AndroidDriver(getHubUrl(), caps);
    }

    public IOSDriver installIOSAppAndGetDriver() {
        DesiredCapabilities caps = getDefaultIOSCapabilities();
        return new IOSDriver(getHubUrl(), caps);
    }

    private DesiredCapabilities getDefaultIOSCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("appium:platformVersion", "17.5");
        capabilities.setCapability("appium:automationName", "xcuitest");
        capabilities.setCapability("appium:appPushTimeout", 120000);
        capabilities.setCapability("appium:bundleId", "jockel.BachlorarbeitTestapp");
        capabilities.setCapability("appium:clearSystemFiles", true);
        capabilities.setCapability("appium:maxTypingFrequency", 30);
        //let appium choose device

        return capabilities;
    }

    private DesiredCapabilities getDefaultAndroidCapabilities() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "android");
        caps.setCapability("appium:automationName", "uiautomator2");
        //caps.setCapability("appium:fullReset", true);
        caps.setCapability("appium:appPackage", "com.example.todolisttestapplication");
        caps.setCapability("appium:appActivity", "com.example.todolisttestapplication.MainActivity");
        //caps.setCapability("appium:disableIdLocatorAutocompletion", true);
        //let appium choose device

        return caps;
    }
}

