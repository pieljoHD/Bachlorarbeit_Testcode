package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    private AppiumDriver driver;
    private WebDriverWait wait;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage(IOSDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public void click(By locator) {
        waitElementToBeClickable(locator).click();
    }

    public void sendKeys(By locator, String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
    }

    public Boolean isElementDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }
        catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    public WebElement waitElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void swipeDown(){
        int centerX = driver.manage().window().getSize().getWidth() / 2;
        int startY = (int) (driver.manage().window().getSize().getHeight() * 0.8);
        int endY = (int) (driver.manage().window().getSize().getHeight() * 0.3);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        wait.until(drv -> {
            try {
                driver.perform(List.of(scroll));
                return true; // Return true if the condition is met
            } catch (InvalidElementStateException e) {
                return false; // Return false if an exception occurs
            }
        });
    }

    public void swipeUp(){
        int centerX = driver.manage().window().getSize().getWidth() / 2;
        int startY = (int) (driver.manage().window().getSize().getHeight() * 0.25);
        int endY = (int) (driver.manage().window().getSize().getHeight() * 0.8);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), centerX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        wait.until(drv -> {
            try {
                driver.perform(List.of(scroll));
                return true; // Return true if the condition is met
            } catch (InvalidElementStateException e) {
                return false; // Return false if an exception occurs
            }
        });
    }

    public void waitForElementAndClear(By locator) {
        waitElementToBeClickable(locator).clear();
    }
}