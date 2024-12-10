package org.example.ios;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPageIOS extends BasePageIOS<LoginPageIOS>{
    private final By UserNameInput = AppiumBy.iOSNsPredicateString("name == 'UserNameInput'");
    private final By PasswortInput = AppiumBy.iOSNsPredicateString("name == 'PasswortInput'");
    private final By ErrorText = AppiumBy.iOSNsPredicateString("name == 'ErrorText'");
    private final By LoginButton = AppiumBy.iOSNsPredicateString("name == 'LoginButton'");
    private final By InputTodoField = AppiumBy.iOSNsPredicateString("name == 'TodoInput'");
    private final By ClearButtonUsername = AppiumBy.iOSNsPredicateString("name == 'clearButtonUserName'");
    private final By ClearButtonPassword = AppiumBy.iOSNsPredicateString("name == 'clearButtonPassword'");

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
