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

    public AndroidDriver installAndroidAppAndGetDriver(String deviceId) {
        caps = setDefaultAndroidCapabilities(caps);
        caps.setCapability("appium:appPackage", "com.example.todolisttestapplication");
        caps.setCapability("appium:appActivity", "com.example.todolisttestapplication.MainActivity");
        caps.setCapability("appium:disableIdLocatorAutocompletion", true);
        caps.setCapability("appium:udid", deviceId);
        driver = new AndroidDriver(getHubUrl(), caps);

        return driver;
    }

    public IOSDriver getDriverIOSSession(String deviceId, int wdaLocalPort) {
        return new IOSDriver(getHubUrl(), getIOSDefaultCapabilities(deviceId, wdaLocalPort));
    }

    private DesiredCapabilities getIOSDefaultCapabilities(String deviceId, int wdaLocalPort) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("appium:automationName", "xcuitest");
        capabilities.setCapability("appium:appPushTimeout", 120000);
        capabilities.setCapability("appium:bundleId", "jockel.BachlorarbeitTestapp");
        capabilities.setCapability("appium:clearSystemFiles", true);
        capabilities.setCapability("appium:maxTypingFrequency", 30);
        capabilities.setCapability("appium:udid", deviceId);
        capabilities.setCapability("appium:wdaLocalPort", wdaLocalPort);
        capabilities.setCapability("appium:derivedDataPath","/Users/johannespielmeier/Library/Developer/Xcode/DerivedData");
        //let appium choose device

        return capabilities;
    }
}

