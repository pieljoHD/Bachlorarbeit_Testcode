package org.example.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.example.BasePage;
import org.openqa.selenium.*;
import java.time.Duration;

public class BasePageAndroid <T extends BasePageAndroid<T>> extends BasePage<T> {

    protected static AndroidDriver driver;
    public final By androidViewViewXPath = By.xpath("//*[@class='android.view.View']");

    public BasePageAndroid(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }


    public void clickByViewView(By id, int number) {
        getElement(id).findElements(androidViewViewXPath).get(number).click();
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
