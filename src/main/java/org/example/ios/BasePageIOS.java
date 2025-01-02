package org.example.ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.BasePage;
import org.openqa.selenium.By;

public class BasePageIOS extends BasePage {
    private IOSDriver driver;
    public BasePageIOS(IOSDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void sendTextAndHideKeyboard(By locator, String text) {
        click(locator);
        waitForElementAndClear(locator);
        sendKeys(locator, text);
        if(driver.isKeyboardShown()){
            hideKeyboard();
        }
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }
}

