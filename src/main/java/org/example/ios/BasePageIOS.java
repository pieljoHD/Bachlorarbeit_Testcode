package org.example.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.apache.logging.log4j.ThreadContext;
import org.example.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BasePageIOS <T extends BasePageIOS<T>> extends BasePage<T> {
    protected IOSDriver driver;

    public BasePageIOS(IOSDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public static By byText(String text){
        return By.xpath("//*[@value='" + text + "']");
    }

    public BasePageIOS hideKeyboard() {
        driver.hideKeyboard();
        return this;
    }

    public Boolean waitElementByTextIsDisplayed(By locator){
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        }
        catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    public T swipeDownUntilElementIsDisplayed(String elementText) {
        int count = 1;
        boolean visibility = isElementDisplayed(By.xpath("//*[@value='" + elementText + "']"));

        while (!visibility) {
            swipeDown();
            count++;
            visibility = isElementDisplayed(By.xpath("//*[@value='" + elementText + "']"));
            if (count == 9) {
                break;
            }
        }

        return (T) this;
    }

    public T swipeDownUntilElementIsDisplayed(By locator) {
        int count = 1;
        boolean visibility = isElementDisplayed(locator);

        while (!visibility) {
            swipeDown();
            count++;
            visibility = isElementDisplayed(locator);
            if (count == 9) {
                break;
            }
        }

        return (T) this;
    }

    public T scrollToElement(By locator) {
        Map<String, Object> args = new HashMap<>();
        getElement(locator);
        args.put("elementId", ((RemoteWebElement)getElement(locator)).getId());
        driver.executeScript("mobile: scrollToElement", args);
        return (T) this;
    }


    public T swipeUpUntilElementVisible(By locator) {
        int count = 1;
        boolean visibility = isElementDisplayed(locator);

        while (!visibility) {
            swipeUp();
            count++;
            visibility = isElementDisplayed(locator);
            if (count == 9) {
                break;
            }
        }

        return (T) this;
    }

    public void waitElementVisibleAndClick(By locator) {
        wait.until(ExpectedConditions.attributeToBe(locator,"visible","true"));
        getElement(locator).click();
    }
}

