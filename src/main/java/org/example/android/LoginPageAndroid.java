package org.example.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPageAndroid extends BasePageAndroid<LoginPageAndroid>{
    private final By UserNameInput = AppiumBy.id("UserNameInput");
    private final By PasswortInput = AppiumBy.id("PasswortInput");
    private final By ErrorText = AppiumBy.id("ErrorText");
    private final By LoginButton = AppiumBy.id("LoginButton");
    private final By InputTodoField = AppiumBy.id("todoInput");
    private final By ClearButtonUserName = AppiumBy.id("clearButtonUserName");
    private final By ClearButtonPassword = AppiumBy.id("clearButtonPassword");

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
