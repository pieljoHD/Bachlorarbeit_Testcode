package org.example.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static io.appium.java_client.proxy.Helpers.createProxy;

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

    public AndroidDriver installAndroidAppAndGetDriver() throws IOException {
        caps = setDefaultAndroidCapabilities(caps);
        //caps.setCapability("appium:fullReset", true);
        caps.setCapability("appium:appPackage", "com.example.todolisttestapplication");
        caps.setCapability("appium:appActivity", "com.example.todolisttestapplication.MainActivity");
        driver = new AndroidDriver(getHubUrl(), caps);
        System.out.println(driver.getSessionId());

        return driver;
    }

    public IOSDriver getDriverIOSSession() throws IOException {
        return new IOSDriver(getHubUrl(), getIOSDefaultCapabilities());
    }

    private DesiredCapabilities getIOSDefaultCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "ios");
        capabilities.setCapability("appium:automationName", "xcuitest");
        capabilities.setCapability("appium:appPushTimeout", 120000);
        capabilities.setCapability("appium:bundleId", "jockel.BachlorarbeitTestapp");
        capabilities.setCapability("appium:clearSystemFiles", true);
        capabilities.setCapability("appium:maxTypingFrequency", 30);
        //let appium choose device

        return capabilities;
    }
}

