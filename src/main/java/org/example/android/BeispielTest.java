package org.example.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BeispielTest
{
    @Test
    public void BeispielTest() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        AndroidDriver driver;
        caps.setCapability("platformName", "android");
        caps.setCapability("appium:automationName", "uiautomator2");
        caps.setCapability("appium:appPackage", "com.example.testApp");
        caps.setCapability("appium:appActivity", "com.example.testApp.MainActivity");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By BeispielButton = By.xpath("//*[@resource-id='beispielButton']");
        wait.until(ExpectedConditions.elementToBeClickable(BeispielButton)).click();
        driver.quit();
    }
}
