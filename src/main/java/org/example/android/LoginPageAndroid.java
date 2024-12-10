package org.example.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPageAndroid extends BasePageAndroid<LoginPageAndroid>{
    private final By UserNameInput = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"UserNameInput\")");
    private final By PasswortInput = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"PasswortInput\")");
    private final By ErrorText =AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ErrorText\")");
    private final By LoginButton = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"LoginButton\")");
    private final By InputTodoField = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"todoInput\")");
    private final By ClearButtonUserName = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"clearButtonUserName\")");
    private final By ClearButtonPassword = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"clearButtonPassword\")");

    public LoginPageAndroid(AndroidDriver driver) {
        super(driver);
    }

    public void loginWithRightCredentials() {
        sendKeys(UserNameInput, "test123");
        sendKeys(PasswortInput, "1234");
        click(LoginButton);
        Assert.assertTrue(isElementDisplayed(InputTodoField));
    }

    public void clearUserName() {
        click(ClearButtonUserName);
    }

    public void clearPassword() {
        click(ClearButtonPassword);
    }

    public void loginWithCredentials(String username, String password) {
        sendKeys(UserNameInput, username);
        sendKeys(PasswortInput, password);
        click(LoginButton);
    }

    public void checkNotOnLoginPage() {
        waitElementToBeClickable(InputTodoField);
        Assert.assertTrue(isElementDisplayed(InputTodoField));
    }

    public void checkErrorTextVisible() {
        Assert.assertTrue(isElementDisplayed(ErrorText));
    }
}
