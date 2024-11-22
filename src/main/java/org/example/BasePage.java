package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage <T extends BasePage<T>>{

    protected AppiumDriver driver;
    protected WebDriverWait wait;

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

    public void sendKeys(By parentLocator, By childLocator, String text) {
        wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(parentLocator, childLocator)).get(0).sendKeys(text);
    }

    public void click(WebElement element) {
        waitElementToBeClickable(element);
        element.click();
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

    public WebElement waitElementToBeClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @SuppressWarnings("unchecked")
    public T waitUntilElementIsVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return (T) this;
    }
    public void waitUntilElementIsVisible(WebElement locator) {
        wait.until(ExpectedConditions.visibilityOf(locator));
    }

    @SuppressWarnings("unchecked")
    public T waitUntilElementIsVisible(String locator) {
        final String selector = "new UiSelector().text(\"" + locator + "\").className(\"android.widget.TextView\")";
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator(selector)));

        return (T) this;
    }

    public void swipeDown(By locator){
        Rectangle rect = driver.findElement(locator).getRect();
        int centerX = driver.manage().window().getSize().getWidth() / 2;
        int startY = rect.y + (int)(rect.height * 0.7);
        int endY = rect.y + (int)(rect.height * 0.2);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 0);
        scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), centerX, startY));
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), centerX, endY));
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(scroll));
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

    public void waitForElementAndClear(WebElement element) {
        waitElementToBeClickable(element).clear();
    }

}