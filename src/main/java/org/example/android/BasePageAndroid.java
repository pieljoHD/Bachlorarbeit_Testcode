package org.example.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.example.BasePage;
import org.openqa.selenium.By;

public class BasePageAndroid extends BasePage {
    private AndroidDriver driver;
    public BasePageAndroid(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void sendTextAndHideKeyboard(By locator, String text) {
        click(locator);
        waitForElementAndClear(locator);
        sendKeys(locator, text);
        if(driver.isKeyboardShown()){
            driver.pressKey(new KeyEvent(AndroidKey.BACK));
        }
    }
}
