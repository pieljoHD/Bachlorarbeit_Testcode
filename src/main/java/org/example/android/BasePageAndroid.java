package org.example.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class BasePageAndroid <T extends BasePageAndroid<T>> extends BasePage<T> {

    protected static AndroidDriver driver;

    public BasePageAndroid(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public BasePage hideKeyboard() {
        driver.hideKeyboard();
        return this;
    }

    public BasePage sendTextAndHideKeyboard(WebElement element, String text) {
        waitUntilElementIsVisible(element);
        element.click();
        element.clear();
        element.sendKeys(text);
        hideKeyboard();
        return this;
    }

    public BasePage sendTextAndHideKeyboard(By locator, String text) {
        click(locator);
        waitForElementAndClear(locator);
        sendKeys(locator, text);
        if(driver.isKeyboardShown()){
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
        return this;
    }

    public static void pressKey(AndroidKey key){
        driver.pressKey(new KeyEvent(key));
    }

    public static void waitForSeconds(int seconds) throws InterruptedException {
        Thread.sleep(Duration.ofSeconds(seconds).toMillis());
    }
}
