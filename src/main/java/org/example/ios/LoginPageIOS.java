package org.example.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPageIOS extends BasePageIOS<LoginPageIOS>{
    private final By UserNameInput = AppiumBy.id("UserNameInput");
    private final By PasswortInput = AppiumBy.id("PasswortInput");
    private final By ErrorText = AppiumBy.id("ErrorText");
    private final By LoginButton = AppiumBy.id("LoginButton");
    private final By InputTodoField = AppiumBy.id("TodoInput");
    private final By ClearButtonUsername = AppiumBy.id("clearButtonUserName");
    private final By ClearButtonPassword = AppiumBy.id("clearButtonPassword");

    public LoginPageIOS(IOSDriver driver) {
        super(driver);
    }

    public void clearFieldUsername() {
        click(ClearButtonUsername);
    }

    public void clearFieldPassword() {
        click(ClearButtonPassword);
    }

    public void loginWithRightCredentials() {
        sendKeys(UserNameInput, "test123");
        sendKeys(PasswortInput, "1234");
        click(LoginButton);
        Assert.assertTrue(isElementDisplayed(InputTodoField));
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
