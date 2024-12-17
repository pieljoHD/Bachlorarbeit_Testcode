package org.example.utils;

import io.appium.java_client.AppiumDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import static org.example.utils.SessionManager.getInstance;

public class BaseTest {
    protected AppiumDriver driver;
    protected SessionManager sessionManager = null;

    @Parameters("platform")
    @BeforeMethod
    public void setUp(String platform) {
        sessionManager = getInstance(platform);
        driver = sessionManager.driver;
        sessionManager.openApp();
    }

    @AfterMethod
    public void tearDown() {
        sessionManager.closeApp();
    }
}
